package org.volgatech.todolist.domain.list;


import org.volgatech.todolist.domain.deal.Deal;


import java.util.ArrayList;

public class ListImpl implements List{
    private ArrayList<Deal> list = new ArrayList<>();
    private ArrayList<Deal> listDone = new ArrayList<>();
    private ArrayList<Deal> listCancled = new ArrayList<>();


    public ListImpl(ArrayList<Deal> list, ArrayList<Deal> listDone, ArrayList<Deal> listCancled) {
        this.list = list;
        this.listDone = listDone;
        this.listCancled = listCancled;
    }

    public void add(Deal deal) {
        list.add(deal);
    }

    public void remove(Deal deal) {
        list.remove(deal);
    }

    public void change(int i, Deal deal) {
        list.set(i, deal);
    }

    public int getSize() {
        return list.size();
    }

    public void doDeal(int i) {
        Deal deal = getDeal(i);
        deal.changeStatus("Done");
        listDone.add(deal);
        remove(deal);
    }

    public void cancelDeal(int i) {
        Deal deal = getDeal(i);
        deal.changeStatus("Canceled");
        listCancled.add(deal);
        remove(deal);
    }

    public Deal getDeal(int i) {
        return list.get(i - 1);
    }

    public void printLists() {
        if(!list.isEmpty()) {
            list = sortSomeList(list);
            System.out.println("IN PROCESS: ");
            printSomeList(list);
        }
        if(!listDone.isEmpty()) {
            listDone = sortSomeList(listDone);
            System.out.println("DONE:");
            printSomeList(listDone);
        }
        if(!listCancled.isEmpty()) {
            listCancled = sortSomeList(listCancled);
            System.out.println("CANCELED:");
            printSomeList(listCancled);
        }
    }

    public void printPriList() {
        list = sortSomeList(list);
        for (int i = 0; i < list.size(); i++) {
            Deal deal = list.get(i);
            char priority = deal.getPriority();
            if(priority != 'N') {
                if (i + 1 < 10) {
                    System.out.print("0");
                }
                System.out.print(i + 1);
                deal.printDeal();
            }
        }
    }

    public void printProjectList(String project) {
        list = sortSomeList(list);
        for (int i = 0; i < list.size(); i++) {
            Deal deal = list.get(i);
            char priority = deal.getPriority();
            if(deal.getProjectName().equals(project)) {
                if (i + 1 < 10) {
                    System.out.print("0");
                }
                System.out.print(i + 1);
                deal.printDeal();
            }
        }
    }

    public ArrayList<Deal> getList() {
        return list;
    }

    public ArrayList<Deal> getListDone() {
        return listDone;
    }

    public ArrayList<Deal> getListCanceled() {
        return listCancled;
    }

    private void printSomeList(ArrayList<Deal> someList) {
        for (int i = 0; i < someList.size(); i++) {
            if (i + 1 < 10) {
                System.out.print("0");
            }
            System.out.print(i + 1);
            Deal deal = someList.get(i);
            deal.printDeal();
        }
    }

    private ArrayList<Deal>  sortSomeList(ArrayList<Deal> someList) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < someList.size() - 1; i++) {
                Deal deal = someList.get(i);
                Deal nextDeal = someList.get(i+1);
                if(deal.getPriority() > nextDeal.getPriority()) {
                    Deal changeDeal = deal;
                    someList.set(i, nextDeal);
                    someList.set(i+1, changeDeal);
                    sorted = false;
                }
            }
        }
        return someList;
    }
}
