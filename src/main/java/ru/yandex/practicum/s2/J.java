package ru.yandex.practicum.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class NodeJ<V> {
    public V value;
    public NodeJ<V> prev;

    public NodeJ(V value, NodeJ<V> prev) {
        this.value = value;
        this.prev = prev;
    }
}

class LinkedQueue {

    private NodeJ<Integer> head;
    private NodeJ<Integer> tail;
    private int size;

    public LinkedQueue() {
    }

    public void put(int value) {
        NodeJ<Integer> node;
        if (head == null) {
            node = new NodeJ<>(value, null);
            head = node;
        } else {
            node = new NodeJ<>(value, tail);
            tail.prev = node;
        }
        tail = node;

        size++;
    }

    public void get() {
        if (head == null) {
            System.out.println("error");
            return;
        }

        size--;

        System.out.println(head.value);

        if (tail == head) {
            tail = null;
            head = null;
        } else {
            head = head.prev;
        }
    }

    public void size() {
        System.out.println(size);
    }
}

public class J {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = readInt(reader);
            LinkedQueue linkedQueue = new LinkedQueue();
            List<String> commands = readCommands(reader, length);
            commands.forEach(command -> {
                parseCommand(command, linkedQueue);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.gc();
    }

    private static void parseCommand(String command, LinkedQueue linkedQueue) {
        String[] arguments = command.split(" ");
        switch (arguments[0]) {
            case "size":
                linkedQueue.size();
                break;
            case "get":
                linkedQueue.get();
                break;
            case "put":
                linkedQueue.put(Integer.parseInt(arguments[1]));
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