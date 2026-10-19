package model;

public abstract class Task {
    protected String title;
    protected String priority;
    protected boolean status;
    protected String deadline;
    protected int points=0;
    public Task(String title,String priority,String deadline){


        this.title=title;
        this.priority=priority;
        this.status=false;
        this.deadline=deadline;


    }
    public abstract int calculatePoints();








}
