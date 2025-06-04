package ru.yandex.practicum.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {
    private record Lesson(double start, double end) implements Comparable<Lesson> {

        @Override
        public int compareTo(Lesson o) {
            var result = Double.compare(this.end, o.end);
            if (result == 0) {
                return Double.compare(this.start, o.start);
            } else {
                return result;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var countOfLessons = Integer.parseInt(reader.readLine());

            List<Lesson> lessons = new ArrayList<>();
            for (int i = 0; i < countOfLessons; i++) {
                var time = new ArrayList<>(Arrays
                        .stream(reader.readLine().split(" "))
                        .map(Double::parseDouble)
                        .toList());
                var lesson = new Lesson(time.get(0), time.get(1));
                lessons.add(lesson);
            }

            lessons = lessons.stream().sorted().toList();

            List<Lesson> schedule = new ArrayList<>();

            for (var lesson : lessons) {
                if (schedule.isEmpty()) {
                    schedule.add(lesson);
                    continue;
                }

                var last = schedule.getLast();
                if (lesson.start >= last.end) {
                    schedule.add(lesson);
                }
            }

            System.out.println(schedule.size());
            schedule.stream().map(lesson -> fmt(lesson.start()) + " " + fmt(lesson.end())).forEach(System.out::println);
        }
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
}
