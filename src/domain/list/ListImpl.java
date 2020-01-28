package domain.list;


import domain.deal.Deal;


import java.util.ArrayList;

public class ListImpl implements List{
    private ArrayList<Deal> list = new ArrayList<>();


    public ListImpl(ArrayList<Deal> list) {
        this.list = list;
    }

    @Override
    public void add(Deal deal) {
        list.add(deal);
    }

    @Override
    public void remove(Deal deal) {
        list.remove(deal);
    }

    @Override
    public void change(int i, Deal deal) {
        list.set(i, deal);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Deal getDeal(int i) {
        Deal deal = list.get(i-1);
        return deal;
    }

    @Override
    public ArrayList<Deal> getList() {
        return list;
    }
}
