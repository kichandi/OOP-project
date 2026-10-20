package model;

public class FitnessTask extends Task {
    private String activity_type;
    private String target_duration;
    private String actual_duration;

    public FitnessTask(String title, String priority, String deadline,String activity_type,String target_duration,String actual_duration) {
        super(title, priority, deadline);
        this.activity_type = activity_type;
        this.target_duration = target_duration;
        this.actual_duration = actual_duration;

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

    public String getTargetDuration(){
        return target_duration;
    }
    public String getActualDuration(){
        return actual_duration;
    }
    @Override
    public int calculatePoints() {
        return 20;
    }
}
