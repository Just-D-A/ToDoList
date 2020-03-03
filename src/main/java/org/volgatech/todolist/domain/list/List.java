package org.volgatech.todolist.domain.list;

import org.volgatech.todolist.domain.deal.Deal;

import java.util.ArrayList;

public interface List{
    public void add(Deal deal);
    public void remove(Deal deal);
    public void change(int i, Deal deal);
    public void  doDeal(int i);
    public void  cancelDeal(int i);
    public void printLists();
    public void printPriList();
    public void printProjectList(String project);
    public int getSize();
    public Deal getDeal(int i);
    public ArrayList<Deal> getList();
    public ArrayList<Deal> getListDone();
    public ArrayList<Deal> getListCanceled();
}
