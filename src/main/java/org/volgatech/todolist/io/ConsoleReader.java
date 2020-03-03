package org.volgatech.todolist.io;

import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConsoleReader{
    private HashMap<String, Command> commands;
    private List list;

    public ConsoleReader(List list) {
        this.list = list;
        commands = new HashMap<>();
        commands.put("add", new Add(list));
        commands.put("pri", new Pri(list));
        commands.put("ls", new Ls(list));
        commands.put("lsp", new Lsp(list));
        commands.put("do", new Do(list));
        commands.put("cancel", new Cancel(list));
        commands.put("change", new Change(list));
    }

    public void start() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        do {
            System.out.print("$ ");

            line = reader.readLine();

            try {
                if (line.endsWith("exit")) {
                    break;
                }

                String[] arguments = parseArguments(line);
                String commandName = arguments[0];

                if (commands.containsKey(commandName)) {
                    Command command = commands.get(commandName);
                    command.execute(arguments);
                } else {
                    throw new Exception("ERROR: unknown command");
                }

            } catch (Exception e) {
                System.err.println(e.getMessage());

            }

        } while (line != null);
    }

    public List getLists() {
        return list;
    }
    private String[] parseArguments(String line) {
        return line.split(" ");
    }
}
