package ru.yandex.practicum.s4;

import java.util.*;
import java.util.stream.Collectors;

public class L {
    public static class KeyValue<K, V> {
        public K key;
        public V value;

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof KeyValue<?, ?> keyValue)) return false;
            return Objects.equals(key, keyValue.key) && Objects.equals(value, keyValue.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static long getHash(int a, int mod, String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return s.charAt(0);
        }

        char[] chars = s.toCharArray();
        long hash = ((long) chars[0] * a + chars[1]) % mod;

        for (int i = 2; i < chars.length; i++) {
            char c = chars[i];
            hash = (hash * a + c) % mod;
        }

        return hash;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] params = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = params[0];
            int k = params[1];

            String string = scanner.nextLine();
            int mod1 = (int) Math.pow(10, 5) + 8;
            int mod2 = (int) Math.pow(10, 5) + 3;

            Map<KeyValue<Long, Long>, KeyValue<Integer, Integer>> result = new HashMap<>();
            for (int i = 0; i < string.length() - n; i++) {
                String str = string.substring(i, i + n);

                var t = new KeyValue<Long, Long>();
                t.key = getHash(123, mod1, str);
                t.value = getHash(123, mod2, str);

                if (result.containsKey(t)) {
                    var v = result.get(t);
                    v.value++;
                    result.put(t, v);
                } else {
                    var kv = new KeyValue<Integer, Integer>();
                    kv.key = i;
                    kv.value = 1;
                    result.put(t, kv);
                }
            }

            System.out.println(
                    result.values()
                            .stream()
                            .filter(integerIntegerKeyValue -> integerIntegerKeyValue.value >= k)
                            .map(integerIntegerKeyValue -> integerIntegerKeyValue.key)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "))
            );
        }
    }
}
