package io.command;

import app.factory.DealFactory;
import domain.deal.Deal;
import domain.list.List;

public class Change extends Command{
    private String[] arguments;

    public Change(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        this.arguments = arguments;

        int index;
        Deal deal;
        if (arguments.length == 1) {
            throw new Exception("ERROR: no deal index");
        }
        if (arguments.length == 2) {
            throw new Exception("ERROR: no deal description");
        }
        try {
            index = Integer.parseInt(arguments[1]);
            deal = list.getDeal(index);
        } catch (Exception e) {
            throw new Exception("Nonexistent deal");
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
            description = description.replaceAll('\"' + "", "");
            Deal newDeal;
            if (projectName.equals("")) {
                newDeal = DealFactory.create(description);
            } else {
                newDeal = DealFactory.create(description, projectName);
            }
            newDeal.givePriority(deal.getPriority());
            list.change(index-1 ,newDeal);
            System.out.println("TODO: '" + deal.getDescription() + "' changed on line " + index);
        } else {
            throw new Exception("ERROR: incorrect description");
        }
    }

    private boolean checkDescription() {
        char firstSymbol = getHead(arguments[2]);
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
                argument = argument.replaceAll('\"' + "", "");
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
