package org.volgatech.todolist.domain.deal;

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


    public void givePriority(char priority) {
        this.priority = priority;
    }

    public char getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    public void printDeal() {
        System.out.println(" (" + priority + ") '" + description + "'");
    }

    public String fileString() {
        String fileString = status + " " + priority + " " + projectName + " " + description;
        return fileString;
    }

    /*@Override
    public Deal getDeal() {
        return De;
    }*/
}
