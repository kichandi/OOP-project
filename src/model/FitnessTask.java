package model;

public class FitnessTask extends Task {
    private String activity_type;
    private String target_duration;
    private String actual_duration;

    public FitnessTask(String title, String priority, String deadline) {
        super(title, priority, deadline);
        ;
    }
    public String getType(){
        return "Fitness";
    }
    @Override
    public int calculatePoints() {
        return 20;
    }
}
