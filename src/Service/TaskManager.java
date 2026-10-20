package Service;

import model.Task;
import dao.TaskDao;
import java.util.List;



public class TaskManager {
    private TaskDao dao = new TaskDao();

    public void addTask(Task task){
        if(task.getTitle()==null || task.getTitle().equals("")){
            System.out.println("Title is empty");
            return;
        }
        dao.addTask(task);
    }

    public void removeTask(int id) {
        dao.deleteTask(id);
    }
    public void completeTask(int id) {
        dao.markComplete(id);
    }
    public List<Task> getAllTasks() {
        return dao.getallTasks();
    }
    public int getTotalPoints() {
        int total = 0;
        for (Task t : dao.getallTasks()) {
            if (t.getStatus()) {
                total += t.calculatePoints();
            }
        }
        return total;
    }
}

