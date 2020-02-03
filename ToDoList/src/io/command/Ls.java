package io.command;

import domain.deal.Deal;
import domain.list.List;

public class Ls extends Command{

    public Ls(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        if(arguments.length > 2) {
            throw new Exception("ERROR: invalid arguments");
        }
        if(arguments.length == 1) {
            list.printLists();
        }
        if(arguments.length == 2) {
            System.out.print(arguments[1]);
            list.printProjectList(arguments[1]);
        }
    }
}
