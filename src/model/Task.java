
package model;

public abstract class Task {

    protected String title;
    protected String priority;
    protected boolean status;
    protected String deadline;
    protected int points = 0;
    protected int id;

    public Task(String title, String priority, String deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
        this.status = false;
    }

    public abstract int calculatePoints();

    public abstract String getType();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }
}
