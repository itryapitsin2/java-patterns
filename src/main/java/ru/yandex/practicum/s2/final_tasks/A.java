package ru.yandex.practicum.s2.final_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/22781/run-report/115738905/
 */
public class A {

    public static final String PUSH_BACK = "push_back";
    public static final String PUSH_FRONT = "push_front";
    public static final String POP_FRONT = "pop_front";
    public static final String POP_BACK = "pop_back";
    public static final String ERROR = "error";
    public static final String SPACE = " ";

    public static class DequeException extends RuntimeException {
        private static final long serialVersionUID = -6588094743641151952L;
    }

    /**
     * Класс реализует дек - структуру данных, представляющую из себя список элементов,
     * в который добавление новых элементов и удаление существующих производится с обоих концов.
     */
    public static class Deque {
        private final int[] queue;
        private int head = 0;
        private int tail = 0;

        public Deque(int size) {
            this.queue = new int[size];
        }

        /**
         * Проверяет заполнение дека
         * @return {@code true} если дек полон, в противном случа {@code false}
         */
        private boolean isFull() {
            return head == (tail + 1) % queue.length;
        }

        /**
         * Проверяет, что дек пуст
         * @return {@code true} если дек пуст, в противном случа {@code false}
         */
        private boolean isEmpty() {
            return head == tail;
        }

        /**
         * Добавляет значение в начало дека
         * @param value значение, которое будет храниться в деке
         */
        public void pushFront(int value) {
            if (isFull()) {
                throw new DequeException();
            }

            head = (head - 1 + queue.length) % queue.length;
            queue[head] = value;
        }

        /**
         * Удаляет значение из начала дека и выводит его в консоль
         */
        public int popFront() {
            if (isEmpty()) {
                throw new DequeException();
            }

            int value = queue[head];
            head = (head + 1 + queue.length) % queue.length;
            return value;
        }

        /**
         * Добавляет значение в конец дека
         * @param value значение, которое будет храниться в деке
         */
        public void pushBack(int value) {
            if (isFull()) {
                throw new DequeException();
            }

            queue[tail] = value;
            tail = (tail + 1 + queue.length) % queue.length;
        }

        /**
         * Удаляет значение с конца дека и выводит его в консоль
         */
        public int popBack() {
            if (isEmpty()) {
                throw new DequeException();
            }

            tail = (tail - 1 + queue.length) % queue.length;
            return queue[tail];
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = readInt(reader);
            int size = readInt(reader);
            Deque deque = new Deque(size);
            List<String> commands = readCommands(reader, commandCount);
            commands.forEach(command -> doCommand(command, deque));
        }
    }

    private static void doCommand(String command, Deque deque) {
        String[] arguments = command.split(SPACE);
        try {
            switch (arguments[0]) {
                case PUSH_BACK:
                    deque.pushBack(Integer.parseInt(arguments[1]));
                    break;
                case PUSH_FRONT:
                    deque.pushFront(Integer.parseInt(arguments[1]));
                    break;
                case POP_FRONT:
                    System.out.println(deque.popFront());
                    break;
                case POP_BACK:
                    System.out.println(deque.popBack());
                    break;
            }
        } catch (DequeException e) {
            System.out.println(ERROR);
        }
    }

    private static List<String> readCommands(BufferedReader reader, int length) throws IOException {
        List<String> commands = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            commands.add(reader.readLine());
        }
        return commands;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
