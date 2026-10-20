package dao;
import database.Database;
import model.Task;
import model. *;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class TaskDao {

    public void addTask(Task task) {
        String sql = """
                INSERT INTO tasks 
                (title, type, priority, deadline, completed, points)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try(Connection connection=Database.connect();
        PreparedStatement pst= connection.prepareStatement(sql)){
            pst.setString(1,task.getTitle());
            pst.setString(2,task.getType());
            pst.setString(3, task.getPriority());
            pst.setString(4, task.getDeadline());
            pst.setInt(5, task.getStatus() ? 1 : 0);
            pst.setInt(6, task.calculatePoints());
            pst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  void markComplete(int id){
        String sql = " UPDATE tasks  SET completed = 1 WHERE id ="+id;
        try (Connection connection = Database.connect();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Task> getallTasks(){
        List<Task> tasks= new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try(Connection connection = Database.connect();
        PreparedStatement pst= connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String type = rs.getString("type");
                String priority = rs.getString("priority");
                String deadline = rs.getString("deadline");
                boolean completed = rs.getInt("completed") == 1;

                Task task;
                if(type.equals("Academic" )){
                    task = new AcademicTask(title, priority, deadline);
                }else if (type.equals("Fitness")) {
                    task = new FitnessTask(title, priority, deadline);
                } else if (type.equals("Personal")) {
                    task = new PersonalTask(title, priority, deadline);
                } else {
                    task = new ProjectTask(title, priority, deadline);
                }
                task.setId(id);
                task.setStatus(completed);
                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tasks;
    }
    public void deleteTask(int id){
        String sql = "DELETE FROM tasks WHERE id="+id;
        try(Connection connection=Database.connect();
        PreparedStatement pst= connection.prepareStatement(sql)) {
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

