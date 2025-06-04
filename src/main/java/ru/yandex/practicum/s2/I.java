package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MyQueueSized {
    private final int[] stack;
    private int trail;

    public MyQueueSized(int length) {
        stack = new int[length];
    }

    public void push(int value){
        if (trail == stack.length) {
            System.out.println("error");
        } else {
            stack[trail] = value;
            trail++;
        }
    }

    public void peek() {
        if (trail == 0) {
            System.out.println("None");
        } else {
            System.out.println(stack[0]);
        }
    }

    public void pop() {
        if (trail == 0) {
            System.out.println("None");
        } else {
            System.out.println(stack[0]);
            for(int i = 0; i < stack.length - 1; i++) {
                stack[i] = stack[i+1];
            }
            trail--;
        }
    }

    public void size() {
        System.out.println(trail);
    }
}

public class I {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = readInt(reader);
            int queueSize = readInt(reader);
            MyQueueSized myQueueSized = new MyQueueSized(queueSize);
            List<String> commands = readCommands(reader, length);
            commands.forEach(command -> {
                parseCommand(command, myQueueSized);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.gc();
    }

    private static void parseCommand(String command, MyQueueSized myQueueSized) {
        String[] arguments = command.split(" ");
        switch (arguments[0]) {
            case "size":
                myQueueSized.size();
                break;
            case "pop":
                myQueueSized.pop();
                break;
            case "push":
                myQueueSized.push(Integer.parseInt(arguments[1]));
                break;
            case "peek":
                myQueueSized.peek();
                break;
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<String> readCommands(BufferedReader reader, int length) throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            commands.add(reader.readLine());
        }
        return commands;
    }
}
