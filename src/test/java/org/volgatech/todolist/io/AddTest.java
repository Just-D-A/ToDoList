package org.volgatech.todolist.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddTest {

    @Test
    public void testAddMethods() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\" ").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("deal description", list.getDeal(1).getDescription());
    }

    @Test
    public void testAddMethodsException() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\" ").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("deal description", list.getDeal(1).getDescription());
    }


    @Test
    public void testAddWithoutMethods() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
            String[] list1 = ("add").split(" ");
            Assertions.assertThrows(Exception.class, () -> {addCommand.execute(list1);});

        assertEquals(0, list.getSize());
    }
}
