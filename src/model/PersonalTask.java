package model;

public class PersonalTask extends Task {
    private String taskType;
    public PersonalTask(String title, String priority,
                        String deadline) {
        super(title, priority, deadline);
    }
    public String getType(){
        return "Personal";
    }

    public int calculatePoints() {
        return 10;
    }
}
