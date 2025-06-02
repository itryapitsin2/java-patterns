package ru.yandex.practicum.s4;

import java.util.*;
import java.util.stream.Collectors;

public class I {
    private static Map<List<Character>, List<Integer>> getAnagrams(String[] words) {
        Map<List<Character>, List<Integer>> anagrams = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            List<Character> chars = words[i]
                    .chars()
                    .mapToObj(e -> (char) e)
                    .collect(Collectors.toList());

            List<Character> set = new ArrayList<>(chars).stream().sorted().collect(Collectors.toList());
            if (anagrams.containsKey(set)) {
                List<Integer> list = anagrams.get(set);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                anagrams.put(set, list);
            }
        }

        return anagrams;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(); //?
            scanner.nextLine();

            String[] words = scanner.nextLine().split(" ");

            Map<List<Character>, List<Integer>> anagrams = getAnagrams(words);

            for (Map.Entry<List<Character>, List<Integer>> entry : anagrams.entrySet()) {
                StringJoiner joiner = new StringJoiner(" ");

                for (Integer value : entry.getValue()) {
                    joiner.add(value.toString());
                }

                System.out.println(joiner);
            }
        }
    }
}
