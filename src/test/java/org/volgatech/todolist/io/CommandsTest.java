package org.volgatech.todolist.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.DealFactory;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.deal.Deal;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommandsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

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
    public void testAddWithoutMethods() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(0, list.getSize());
    }

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
    public void ShowListOfDeals() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Add addCommand = new Add(list);
        try {
            String[] list1 = ("add \"deal description\"").split(" ");
            addCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Ls listCommand = new Ls(list);
        try {
            String[] list1 = ("ls").split(" ");
            listCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("TODO: 'deal description' added on line 1\r\n" +
                "IN PROCESS: \r\n" +
                "01 (N) 'deal description'\r\n", outContent.toString());
    }

    @Test
    public void tessLsp() {
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

        Lsp LspCommand = new Lsp(list);
        try {
            String[] list1 = ("ls").split(" ");
            LspCommand.execute(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("TODO: 'abc' added on line 1\r\n" +
                "OK\r\n" +
                "01 (A) 'abc'\r\n", outContent.toString());

    }

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

}

