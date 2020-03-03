package io.command;

import domain.deal.Deal;
import domain.list.List;

public class Cancel extends Command{

    public Cancel(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        if (arguments.length == 2) {
            int i;
            Deal deal;
            try {
                i = Integer.parseInt(arguments[1]);
                deal = list.getDeal(i);
            } catch (Exception e) {
                throw new Exception("Nonexistent deal");
            }

            if (deal != null) {
                list.cancelDeal(i);
                deal.printDeal();
                System.out.println(" IS CANCEL");
            } else {
                throw new Exception("Nonexistent deal");
            }

        } else {
            throw new Exception("Incorrect arguments");
        }
    }
}
