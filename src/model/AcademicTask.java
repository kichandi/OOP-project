package model;

public class AcademicTask extends model.Task{
    private String Subjectname;

    public AcademicTask(String title, String priority, String deadline) {
        super(title, priority, deadline);
        status=false;
    }

    public int      calculatePoints(){
        points=10;
        return points;

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

    public String getSubjectname(){
        return Subjectname;
    }

    public String getType(){
        return "Academic";
    }

}
