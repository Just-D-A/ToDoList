package io.command;

import app.factory.DealFactory;
import domain.deal.Deal;
import domain.list.List;

import java.util.ArrayList;

public class Add extends Command{
    private String[] arguments;

    public Add(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        this.arguments = arguments;
        if (arguments.length == 1) {
            throw new Exception("ERROR: no deal description");
        }
        if (checkDescription()) {
            String description = "";
            String projectName = findProjectName();
            for (int i = 1; i < arguments.length; i++) {
                if (i != arguments.length - 1) {
                    description += this.arguments[i] + " ";
                } else {
                    description += this.arguments[i];
                }

            }
            Deal deal;
            if (projectName.equals("")) {
                deal = DealFactory.create(description);
            } else {
                deal =DealFactory.create(description, projectName);
            }
            list.add(deal);
            System.out.println("TODO: " + deal.getDescription() + " added on line " + list.getSize
                    ());
        } else {
            throw new Exception("ERROR: incorrect description");
        }
    }

    private boolean checkDescription() {
        char firstSymbol = getHead(arguments[1]);
        char lastSymbol = getLastSymbol(arguments[arguments.length - 1]);
        if ((firstSymbol == '\"') && (lastSymbol == '\"')) {
            return true;
        } else {
            return false;
        }
    }

    private String findProjectName() {
        for (String argument : arguments) {
            if (getHead(argument) == '+') {
                return argument;
            }
        }
        return "";
    }

    private char getHead(String str) {
        char[] charArr = str.toCharArray();
        return charArr[0];
    }

    private char getLastSymbol(String str) {
        char[] charArr = str.toCharArray();
        return charArr[charArr.length - 1];
    }
}
