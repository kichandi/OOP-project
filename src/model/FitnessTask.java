package model;

public class FitnessTask extends Task {
    private String activity_type;
    private String target_duration;
    private String actual_duration;

    public FitnessTask(String title, String priority, String deadline) {
        super(title, priority, deadline);
        ;

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
        return "Fitness";

    }

    public String getActivityType(){
        return activity_type;

    }

    @Override
    public int calculatePoints() {
        return 20;
    }
}
