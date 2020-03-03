package org.volgatech.todolist;

import org.volgatech.todolist.app.file.MyFileWriter;
import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.ConsoleReader;

import java.io.File;
import org.volgatech.todolist.app.file.MyFileReader;
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
