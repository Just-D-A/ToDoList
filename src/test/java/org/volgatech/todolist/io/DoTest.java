package org.volgatech.todolist.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Do;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoTest {
    @Test
    public void testSetDealAsDone() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Do doCommand = new Do(list);
        try {
            String[] list1 = ("do 1").split(" ");
            doCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("deal description", list.getListDone().get(0).getDescription());
    }

    @Test
    public void testDoDealDoesNotExist() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Do doCommand = new Do(list);
        String[] list1 = ("do 1").split(" ");
        Assertions.assertThrows(Exception.class, () -> { doCommand.execute(list1);});
    }
}
