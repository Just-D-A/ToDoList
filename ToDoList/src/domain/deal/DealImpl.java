package domain.deal;

public class DealImpl implements Deal{
    private String description;
    private String status;
    private String projectName;
    private char priority;

    public DealImpl(String description) {
        this.description = description;
        this.status = "InProcess";
        this.projectName = "None";
        this.priority = 'N';
    }

    public DealImpl(String description, String projectName) {
        this.description = description;
        this.status = "InProcess";
        this.projectName = projectName;
        this.priority = 'N';
    }

    public DealImpl(String description, String status, String projectName, char priority) {
        this.description = description;
        this.status = status;
        this.projectName = projectName;
        this.priority = priority;
    }


    @Override
    public void givePriority(char priority) {
        this.priority = priority;
    }

    @Override
    public char getPriority() {
        return priority;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void changeStatus(String status) {
        this.status = status;
    }

    @Override
    public void printDeal() {
        System.out.println(" (" + priority + ") '" + description + "'");
    }

    @Override
    public String fileString() {
        String fileString = status + " " + priority + " " + projectName + " " + description;
        return fileString;
    }

    /*@Override
    public Deal getDeal() {
        return De;
    }*/
}
