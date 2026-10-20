import Service.TaskManager;
import dao.TaskDao;
import database.Database;
import model.AcademicTask;
import model.FitnessTask;
import model.Task;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Database.initialize();

        TaskDao dao = new TaskDao();

        TaskManager manager = new TaskManager();
        manager.addTask(new  AcademicTask("Study Maths", "High", "2026-11-01"));



        List<Task> tasks = dao.getallTasks();
        System.out.println("Number of tasks: " + tasks.size());

        dao.markComplete(10);
        dao.deleteTask(2);
        System.out.println("total score:"+manager.getTotalPoints());

        for (Task t : tasks) {
            System.out.println(t.getId() + " " + t.getTitle()
                    + " " + t.getType() + " " + t.getPriority() + " "+t.getStatus());

        }
    }
}