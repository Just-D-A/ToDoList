package domain.deal;

public interface Deal{
    public void givePriority(char priority);
    public String getDescription();
    public String getProjectName();
    public void changeStatus(String status);
    public char getPriority();
    public void printDeal();
    public String fileString();
    //public Deal getDeal();
}
