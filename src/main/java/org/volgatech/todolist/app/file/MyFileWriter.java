package org.volgatech.todolist.app.file;

import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileWriter{
    private ArrayList<Deal> list = new ArrayList<Deal>();
    private ArrayList<Deal> listDone = new ArrayList<Deal>();
    private ArrayList<Deal> listCancled = new ArrayList<Deal>();
    private File file;

    public MyFileWriter(List toDoList, File file) {
        this.list = toDoList.getList();
        this.listDone = toDoList.getListDone();
        this.listCancled = toDoList.getListCanceled();
        this.file = file;
    }

    public void writeToFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Deal deal : list) {
                bufferedWriter.write(deal.fileString() + "\n");
            }
            for (Deal deal : listDone) {
                bufferedWriter.write(deal.fileString() + "\n");
            }
            for (Deal deal : listCancled) {
                bufferedWriter.write(deal.fileString() + "\n");
            }

            bufferedWriter.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}