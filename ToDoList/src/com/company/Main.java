package com.company;

import app.file.MyFileWriter;
import domain.deal.Deal;
import domain.list.List;
import io.ConsoleReader;

import java.io.File;
import app.file.MyFileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Deal> list = new ArrayList<>();
        File file = new File("file.txt");
        MyFileReader fileReader = new MyFileReader(file);
        List toDoList = fileReader.readFile();
        ConsoleReader reader = new ConsoleReader(toDoList);
        reader.start();
        toDoList = reader.getLists();
        MyFileWriter fileWriter = new MyFileWriter(toDoList, file);
        fileWriter.writeToFile();
    }
}
