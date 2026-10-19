import Service.TaskManager;
import model.AcademicTask;
import model.Task;

public class Main {
    public static void main(String[] args) {
        TaskManager task = new TaskManager();
        task.addTask("homework","HIGH","12:00","academic");
    }
}
