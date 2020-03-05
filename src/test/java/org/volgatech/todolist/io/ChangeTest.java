package org.volgatech.todolist.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Change;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeTest {
    @Test
    public void testChangeDealDescription() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Change changeCommand = new Change(list);
        try {
            String[] list2 = ("change 1 \"new deal description\" ").split(" ");
            changeCommand.execute(list2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("1 new deal description", list.getList().get(0).getDescription());
    }

    @Test
    public void testChangeDoesNotExist() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Change changeCommand = new Change(list);
        String[] list2 = ("change 1 \"new deal description\" ").split(" ");
        Assertions.assertThrows(Exception.class, () -> {changeCommand.execute(list2);});
    }
}
