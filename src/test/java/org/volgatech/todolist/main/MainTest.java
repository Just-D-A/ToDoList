package org.volgatech.todolist.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.volgatech.todolist.Main;

public class MainTest {
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
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("./src/test/java/org/volgatech/todolist/main/MainTestInput.txt"));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
        assertEquals("main\r\n"
            + "$ TODO: 'deal 1' added on line 1\r\n"
            + "$ TODO: 'deal 2' added on line 2\r\n"
            + "$ OK\r\n"
            + "$  (A) 'deal 1'\r\n"
            + " IS CANCEL\r\n"
            + "$  (N) 'deal 2'\r\n"
            + " IS DONE\r\n"
            + "$ DONE:\r\n"
            + "01 (N) 'deal 2'\r\n"
            + "CANCELED:\r\n"
            + "01 (A) 'deal 1'\r\n"
            + "$ $ ",
            outContent.toString());
    }
}