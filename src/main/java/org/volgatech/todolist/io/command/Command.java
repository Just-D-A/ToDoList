package org.volgatech.todolist.io.command;

import org.volgatech.todolist.domain.list.List;

import java.util.ArrayList;

public abstract class Command{
    protected List list ;

    public Command(List list) {
        this.list = list;
    }

    public abstract void execute(String[] arguments) throws Exception;

}
