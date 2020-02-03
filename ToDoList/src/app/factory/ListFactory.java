package app.factory;

import domain.list.ListImpl;
import domain.deal.Deal;
import domain.list.List;

import java.util.ArrayList;

public class ListFactory {
    public static List create(ArrayList<Deal> list,  ArrayList<Deal> listDone, ArrayList<Deal> listCancled) {
        return new ListImpl(list, listDone, listCancled);
    }
}
