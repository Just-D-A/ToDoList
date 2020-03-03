package org.volgatech.todolist.app.factory;

import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.deal.DealImpl;

public class DealFactory{

    public static Deal create(String description) {
        return new DealImpl(description);
    }

    public static Deal create(String description, String projectName) {
        return new DealImpl(description, projectName);
    }

    public static Deal create(String description,String status, String projectName, char priority) {
        return new DealImpl(description, status, projectName, priority);
    }
}
