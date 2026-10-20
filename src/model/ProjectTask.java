package model;

public class ProjectTask extends Task {



    public ProjectTask(String title, String priority, String deadline) {

        super(title, priority, deadline);


    }

    @Override
    public int calculatePoints() {
        return 10;

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
        return "Project";
    }

}
