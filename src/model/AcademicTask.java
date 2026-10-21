package model;

public class AcademicTask extends model.Task{


    public AcademicTask(String title, String priority, String deadline) {
        super(title, priority, deadline);
    }
    public int      calculatePoints(){

        return 10;

    }
    public String getType(){
        return "Academic";
    }

}
