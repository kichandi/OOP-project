package model;

public class AcademicTask extends model.Task{
    private String Subjectname;

    public AcademicTask(String title, String priority, String deadline,String subjectname) {
        super(title, priority, deadline);
        this.Subjectname = subjectname;
        status=false;
    }

    public int      calculatePoints(){
        points+=10;
        return points;

    }

    public boolean isComplete(){
        return status;
    }




}
