package io;

import domain.list.List;
import io.command.Add;
import io.command.Command;
import io.command.Pri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConsoleReader{
    private HashMap<String, Command> commands;

    public ConsoleReader(List list) {
        commands = new HashMap<>();
        //commands.put("command1", new Command1(list));
        commands.put("add", new Add(list));
        commands.put("pri", new Pri(list));
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

    private String[] parseArguments(String line) {
        return line.split(" ");
    }
}
