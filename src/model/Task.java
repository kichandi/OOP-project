
package model;

public abstract class Task {

    private String title;
    private String priority;
    private boolean status;
    private String deadline;

    private int id;

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


}
