package Service;

import model.*;
import java.util.ArrayList;

public class TaskManager {


    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, String priority,
                        String deadline, String type) {

        Task task;

        switch (type.toLowerCase()) {
            case "academic":
                task = new AcademicTask(title, priority, deadline, "maths");
                break;

            case "fitness":
                task = new FitnessTask(
                        title, priority, deadline,
                        "Gym", "60", "0"

                );
                break;

            case "personal":
                task = new PersonalTask(
                        title, priority, deadline,
                        "Household"
                );
                break;

            case "project":
                task = new ProjectTask(
                        title, priority, deadline,
                        "Whiplash", title, 60, 0
                );
                break;

            default:
                System.out.println("Invalid task type!");
                return;
        }

        tasks.add(task);
        System.out.println("Task added successfully!");
    }
}