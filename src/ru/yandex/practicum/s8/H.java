package ru.yandex.practicum.s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var text = reader.readLine();
            var p = reader.readLine();
            var t = reader.readLine();

            // Функция возвращает все позиции вхождения шаблона в тексте.
            List<Integer> result = new ArrayList<>();
            String s = p + "#" + text;
            int[] prefix = new int[p.length()];  // Массив длины |p|.
            Arrays.fill(prefix, 0);
            int prefixPrev = 0;
            for (int i = 1; i < s.length(); i++) {
                int k = prefixPrev;
                while (k > 0 && s.charAt(k) != s.charAt(i)) {
                    k = prefix[k - 1];
                }
                if (s.charAt(k) == s.charAt(i)) {
                    k++;
                }
                // Запоминаем только первые |p| значений prefix-функции.
                if (i < p.length()) {
                    prefix[i] = k;
                }
                // Запоминаем последнее значение prefix-функции.
                prefixPrev = k;
                // Если значение prefix-функции равно длине шаблона, то вхождение найдено.
                if (k == p.length()) {
                    // i - это позиция конца вхождения шаблона.
                    // Дважды отнимаем от него длину шаблона, чтобы получить позицию начала:
                    //  - чтобы «переместиться» на начало найденного шаблона,
                    //  - чтобы не учитывать добавленное "pattern#".
                    result.add(i - 2 * p.length());
                }
            }
            var stringBuilder = new StringBuilder();

            var prev = 0;
            for (var idx : result) {
                stringBuilder.append(text, prev, idx);
                stringBuilder.append(t);
                prev = idx + p.length();
            }

            stringBuilder.append(text, prev, text.length());

            System.out.print(stringBuilder);
        }
    }
}
