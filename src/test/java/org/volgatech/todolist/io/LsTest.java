package org.volgatech.todolist.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Ls;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LsTest {
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
    public void ListWithWrongArguments() {
        List list = ListFactory.create(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Ls listCommand = new Ls(list);

        String[] list1 = ("ls 1 2").split(" ");

        Assertions.assertThrows(Exception.class, () -> { listCommand.execute(list1);});
    }
}
