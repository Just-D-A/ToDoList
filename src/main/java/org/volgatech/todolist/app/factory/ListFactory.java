package org.volgatech.todolist.app.factory;

import org.volgatech.todolist.domain.list.ListImpl;
import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;

import java.util.ArrayList;

public class ListFactory {
    public static List create(ArrayList<Deal> list,  ArrayList<Deal> listDone, ArrayList<Deal> listCancled) {
        return new ListImpl(list, listDone, listCancled);
    }
}
