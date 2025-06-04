package ru.yandex.practicum.s3.final_tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Объяснение решения сделано в файле README_B.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/23815/run-report/116113213/
 */
public class B {

    public static class Record implements Comparable<Record> {
        private final String login;
        private final long successTasks;
        private final long penalty;

        Record(String login, long successTasks, long penalty) {
            this.login = login;
            this.successTasks = successTasks;
            this.penalty = penalty;
        }

        /**
         * Сортировать таблицу результатов следующим образом:
         * при сравнении двух участников выше будет идти тот, у которого решено больше задач (successTasks).
         * При равенстве числа решённых задач первым идёт участник с меньшим штрафом (penalty).
         * Если же и штрафы совпадают, то первым будет тот, у которого логин идёт раньше в алфавитном (лексикографическом) порядке.
         *
         * @param o the object to be compared.
         */
        @Override
        public int compareTo(Record o) {
            int result = Long.compare(this.successTasks, o.successTasks) * -1;
            if (result != 0) {
                return result;
            }

            result = Long.compare(this.penalty, o.penalty);
            if (result != 0) {
                return result;
            }

            result = login.compareTo(o.login);
            return result;
        }

        @Override
        public String toString() {
            return login;
        }
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static List<Record> quickSortInPlace(List<Record> records, int left, int right) {
        if (left >= right) {
            return records;
        }

        int pivot = getRandomNumberUsingInts(left, right);
        Record pivotValue = records.get(pivot);
        int i = left, j = right;
        do {
            // Двигаем левый указатель
            while (records.get(i).compareTo(pivotValue) < 0) {
                i++;
            }
            // Двигаем правый указатель
            while (records.get(j).compareTo(pivotValue) > 0) {
                j--;
            }
            // Меняем местами элементы
            if (i <= j) {
                Collections.swap(records, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        quickSortInPlace(records, i, j);

        return records;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Record> records = readRecords(scanner, n);
            quickSortInPlace(records, 0, records.size() - 1).forEach(System.out::println);
        }
    }

    public static List<Record> readRecords(Scanner scanner, int n) {
        List<Record> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(" ");
            result.add(new Record(row[0], Long.parseLong(row[1]), Long.parseLong(row[2])));
        }
        return result;
    }
}
