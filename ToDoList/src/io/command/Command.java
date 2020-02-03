package io.command;

import domain.list.List;

import java.util.ArrayList;

public abstract class Command{
    protected List list ;

    public Command(List list) {
        this.list = list;
    }

    public abstract void execute(String[] arguments) throws Exception;

}
