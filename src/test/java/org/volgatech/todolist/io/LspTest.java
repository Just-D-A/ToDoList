package org.volgatech.todolist.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.app.factory.ListFactory;
import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.Add;
import org.volgatech.todolist.io.command.Lsp;
import org.volgatech.todolist.io.command.Pri;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LspTest {
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
}
