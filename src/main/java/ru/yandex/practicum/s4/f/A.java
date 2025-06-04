package ru.yandex.practicum.s4.f;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Объяснение решения сделано в файле README_A.md.
 * Ссылка на отчёт https://contest.yandex.ru/contest/24414/run-report/116360074/
 */
public class A {
    private static final int COUNT_OF_RELEVANT_DOCUMENTS = 5;

    //# region Вспомогательные классы
    /**
     * Связь слова с документом и число включений слова в документе.
     * Добавлен для удобства (чтобы не запутаться в типах переменных).
     */
    private static class WordDocumentIdCountOfWordCube extends HashMap<String, HashMap<Integer, Integer>> {
    }

    /**
     * Срез куба по слову, который содержит номер документа и количество включений слова в документе.
     */
    private static class RelevanceAccumulator extends HashMap<Integer, Integer> {
        public void addAll(Map<Integer, Integer> map) {
            map.forEach((key, value) -> {
                if (containsKey(key)) {
                    Integer v = get(key);
                    v += value;
                    put(key, v);
                } else {
                    put(key, value);
                }
            });
        }
    }
    //#endregion

    //#region Методы - создание индекса и поиск в документах
    /**
     * Поиск релевантных документов в кубе по словам.
     *
     * @param request Набор поисковых слов
     * @param indexes Куб с координатами Слово - Уникальный идентификатор документа - Число вхождений
     * @return Список документов для запросов.
     */
    private static List<Integer> findRelevantDocuments(String request, WordDocumentIdCountOfWordCube indexes) {
        List<String> words = Arrays.stream(request.split(" ")).distinct().toList();
        RelevanceAccumulator docAndCount = new RelevanceAccumulator();

        for (String word : words) {
            if (indexes.containsKey(word)) {
                Map<Integer, Integer> tmp = indexes.get(word);
                docAndCount.addAll(tmp);
            }
        }

        return docAndCount
                .entrySet()
                .stream()
                .limit(COUNT_OF_RELEVANT_DOCUMENTS)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    /**
     * Метод создаёт куб Слово - Документ - Число включений слова
     *
     * @param documents Набор документов
     * @return Куб Слово - Документ - Число включений слова
     */
    private static WordDocumentIdCountOfWordCube createdDocumentsIndex(String[] documents) {
        WordDocumentIdCountOfWordCube indexes = new WordDocumentIdCountOfWordCube();

        for (int i = 0; i < documents.length; i++) {
            String document = documents[i];
            String[] words = document.split(" ");

            for (String word : words) {
                HashMap<Integer, Integer> docAndCount;
                if (indexes.containsKey(word)) {
                    docAndCount = indexes.get(word);
                    int count = 0;
                    if (docAndCount.containsKey(i)) {
                        count = docAndCount.get(i);
                    }
                    count++;
                    docAndCount.put(i, count);
                } else {
                    docAndCount = new HashMap<>();
                    docAndCount.put(i, 1);
                }
                indexes.put(word, docAndCount);
            }
        }
        return indexes;
    }
    //#endregion

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            String[] documents = readDocuments(n, scanner);

            int m = scanner.nextInt();
            scanner.nextLine();

            String[] requests = readDocuments(m, scanner);

            WordDocumentIdCountOfWordCube indexes = createdDocumentsIndex(documents);

            Arrays.stream(requests)
                    .map(request -> findRelevantDocuments(request, indexes))
                    .map(documentIds ->
                            documentIds
                                    .stream()
                                    .map(x -> String.valueOf(x + 1))
                                    .collect(Collectors.joining(" ")))
                    .forEach(System.out::println);
        }
    }

    private static String[] readDocuments(int n, Scanner scanner) {
        String[] documents = new String[n];
        for (int i = 0; i < n; i++) {
            documents[i] = scanner.nextLine();
        }
        return documents;
    }
}
