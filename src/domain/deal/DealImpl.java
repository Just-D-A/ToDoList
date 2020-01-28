package domain.deal;

public class DealImpl implements Deal{
    private String description;
    private String projectName;
    private char priority;

    public DealImpl(String description) {
        this.description = description;
        this.projectName = "";
    }

    public DealImpl(String description, String projectName) {
        this.description = description;
        this.projectName = projectName;
    }

    public DealImpl(String description, String projectName, char priority) {
        this.description = description;
        this.projectName = projectName;
        this.priority = priority;
    }


    @Override
    public void givePriority(char priority) {
        this.priority = priority;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /*@Override
    public Deal getDeal() {
        return De;
    }*/
}
