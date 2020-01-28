package com.company;

import app.factory.ListFactory;
import domain.deal.Deal;
import domain.list.List;
import io.ConsoleReader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Deal> list = new ArrayList<>();
        List toDoList = ListFactory.create(list);
        ConsoleReader reader = new ConsoleReader(toDoList);
        reader.start();
    }
}
