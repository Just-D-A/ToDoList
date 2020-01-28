package app.factory;

import domain.deal.Deal;
import domain.deal.DealImpl;

public class DealFactory{

    public static Deal create(String description) {
        return new DealImpl(description);
    }

    public static Deal create(String description, String projectName) {
        return new DealImpl(description, projectName);
    }

    public static Deal create(String description, String projectName, char priority) {
        return new DealImpl(description, projectName, priority);
    }
}
