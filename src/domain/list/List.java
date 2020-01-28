package domain.list;

import domain.deal.Deal;

import java.util.ArrayList;

public interface List{
    public void add(Deal deal);
    public void remove(Deal deal);
    public void change(int i, Deal deal);
    public int getSize();
    public Deal getDeal(int i);
    public ArrayList<Deal> getList();
}
