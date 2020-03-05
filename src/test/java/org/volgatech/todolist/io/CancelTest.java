package org.volgatech.todolist.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Cancel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancelTest {
    @Test
    public void testCancelDeal() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cancel cancelCommand = new Cancel(list);
        try {
            String[] list2 = ("cancel 1").split(" ");
            cancelCommand.execute(list2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("deal description", list.getListCanceled().get(0).getDescription());
    }

    @Test
    public void testCancelDealDoesNotExist() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Cancel cancelCommand = new Cancel(list);

            String[] list2 = ("cancel 1").split(" ");

        Assertions.assertThrows(Exception.class, () -> {cancelCommand.execute(list2);});
    }
}
