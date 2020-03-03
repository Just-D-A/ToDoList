package org.volgatech.todolist.io.command;

import org.volgatech.todolist.domain.list.List;

public class Lsp extends Command{

    public Lsp(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        list.printPriList();
    }
}
