package model;

public class PersonalTask extends Task {

    private String taskType;


    public PersonalTask(String title, String priority,
                        String deadline, String taskType) {

        super(title, priority, deadline);

        this.taskType = taskType;

    }

    @Override
    public int calculatePoints() {
        return 0;
    }
}
