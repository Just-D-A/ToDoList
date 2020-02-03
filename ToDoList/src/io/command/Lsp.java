package io.command;

import domain.list.List;

public class Lsp extends Command{

    public Lsp(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        list.printPriList();
    }
}
