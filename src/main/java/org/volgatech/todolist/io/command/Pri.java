package org.volgatech.todolist.io.command;

import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;

import java.util.ArrayList;

public class Pri extends Command{
    String[] arguments;

    public Pri(List list) {
        super(list);
    }

    @Override
    public void execute(String[] arguments) throws Exception {
        this.arguments = arguments;
        if (arguments.length == 1) {
            throw new Exception("ERROR: no deal index");
        } else if (arguments.length == 2) {
            throw new Exception("ERROR: no deal priority");
        } else if (arguments.length == 3) {
            char priority = checkPriority();
            if(priority != 'N') {
                int i;
                Deal deal;
                try {

                    i = Integer.parseInt(arguments[1]);
                    deal = list.getDeal(i);
                } catch (Exception e) {
                    throw new Exception("ERROR: incorrect deal index");
                }

                deal.givePriority(priority);
                System.out.println("OK");
            } else {
                throw new Exception("ERROR: incorrect priority");
            }
        } else {
            throw new Exception("ERROR: incorrect priority");
        }
    }

    private char checkPriority() {
        String priorityStr = arguments[2];
        if(priorityStr.length() == 1) {
            char[] charArr = priorityStr.toCharArray();
            char priority = charArr[0];
            char symbolA = 'A';
            char symbolC = 'C';
            if((((int) priority >= (int) symbolA)) && ((int) priority <= (int) symbolC)) {
                return priority;
            }
        }
        return 'N';
    }
}
