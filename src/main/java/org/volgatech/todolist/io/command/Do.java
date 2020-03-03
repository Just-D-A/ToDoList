package org.volgatech.todolist.io.command;

import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;

public class Do extends Command{

    public Do(List list) {
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
                list.doDeal(i);
                deal.printDeal();
                System.out.println(" IS DONE");
            } else {
                throw new Exception("Nonexistent deal");
            }

        } else {
            throw new Exception("Incorrect arguments");
        }
    }
}
