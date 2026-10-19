package model;

public class ProjectTask extends Task {

    private String projectName;
    private String milestone;
    private int targetDuration;
    private int actualDuration;

    public ProjectTask(String title, String priority, String deadline,
                       String projectName, String milestone,
                       int targetDuration, int actualDuration) {

        super(title, priority, deadline);

        this.projectName = projectName;
        this.milestone = milestone;
        this.targetDuration = targetDuration;
        this.actualDuration = actualDuration;
    }

    @Override
    public int calculatePoints() {
        if (!status) {
            return 0;
        }

        if (actualDuration >= targetDuration) {
            return 30;
        }

        return 10;
    }
}
