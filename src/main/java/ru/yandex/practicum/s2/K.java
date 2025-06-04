package ru.yandex.practicum.s2;

import java.io.*;

public class K {

    public static int calCommits(int studentNumber) {
        if (studentNumber < 2) {
            return 1;
        }

        return calCommits(studentNumber - 1) + calCommits(studentNumber - 2);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int studentCount = readInt(reader);
            int commits = calCommits(studentCount);
            System.out.println(commits);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}