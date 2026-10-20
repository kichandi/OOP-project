package model;

public class PersonalTask extends Task {

    private String taskType;


    public PersonalTask(String title, String priority,
                        String deadline) {

        super(title, priority, deadline);



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
        return "Personal";
    }
    @Override
    public int calculatePoints() {
        return 10;
    }
}
