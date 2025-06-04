package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class StackMax {
    private final int[] stack;
    private int trail;
    private int max = Integer.MIN_VALUE;

    public StackMax(int length) {
        stack = new int[length];
    }

    public void push(int value){
        if (value > max){
            max = value;
        }
        stack[trail] = value;
        trail++;
    }

    public void pop() {
        if (trail == 0) {
            System.out.println("error");
        } else {
            trail--;
            max = Integer.MIN_VALUE;
            for (int i = trail - 1; i >= 0; i--) {
                int value = stack[i];
                if (value > max){
                    max = value;
                }
            }
        }
    }

    public void getMax() {
        if (trail == 0) {
            System.out.println("None");
        } else {
            System.out.println(max);
        }
    }
}

public class F {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = readInt(reader);
            StackMax stackMax = new StackMax(length);
            List<String> commands = readCommands(reader, length);
            commands.forEach(command -> {
                parseCommand(command, stackMax);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.gc();
    }

    private static void parseCommand(String command, StackMax stackMax) {
        String[] arguments = command.split(" ");
        switch (arguments[0]) {
            case "get_max":
                stackMax.getMax();
                break;
            case "pop":
                stackMax.pop();
                break;
            case "push":
                stackMax.push(Integer.parseInt(arguments[1]));
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
