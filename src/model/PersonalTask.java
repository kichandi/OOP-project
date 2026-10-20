package model;

public class PersonalTask extends Task {

    private String taskType;


    public PersonalTask(String title, String priority,
                        String deadline, String taskType) {

        super(title, priority, deadline);

        this.taskType = taskType;

    }
    public String getTitle(){
        return title;
    }

    public String getPriority(){
        return priority;
    }

    public String getDeadline(){
        return deadline;
    }

    public boolean isComplete(){
        return status;
    }
    public String getType(){
        return "personal";
    }

    @Override
    public int calculatePoints() {
        return 0;
    }
}
