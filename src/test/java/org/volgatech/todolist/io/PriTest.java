package org.volgatech.todolist.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Pri;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriTest {
    @Test
    public void testPri() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Add addCommand = new Add(list);
        try {
            String[] list1 = ("Add \"abc\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pri PriCommand = new Pri(list);
        try {
            String[] list1 = ("Pri 1 A ").split(" ");
            PriCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals('A', list.getList().get(0).getPriority());
    }

    @Test
    public void testPriWithoutArguments() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Add addCommand = new Add(list);
        try {
            String[] list1 = ("Add \"abc\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pri PriCommand = new Pri(list);

            String[] list1 = ("Pri").split(" ");
        Assertions.assertThrows(Exception.class, () -> { PriCommand.execute(list1);});
    }

    @Test
    public void testPriWithWrongPriority() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Add addCommand = new Add(list);
        try {
            String[] list1 = ("Add \"abc\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pri PriCommand = new Pri(list);

        String[] list1 = ("Pri 1 F").split(" ");
        Assertions.assertThrows(Exception.class, () -> { PriCommand.execute(list1);});
    }
}
