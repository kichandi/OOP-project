package model;

public class ProjectTask extends Task {
    public ProjectTask(String title, String priority, String deadline) {

        super(title, priority, deadline);


    }
    @Override
    public int calculatePoints() {
        return 10;

    }
    public String getType(){
        return "Project";
    }

}
