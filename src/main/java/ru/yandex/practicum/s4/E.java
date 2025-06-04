package ru.yandex.practicum.s4;

public class E {
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
        int a = 1000;
        int mod = 123_987_123;
        long hash3 = getHash(a, mod, "mxyskaoghi");
        long hash4 = getHash(a, mod, "qodfrgmslc");
        char[] s = "ezhgeljkablzwnvuwqvp".toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println((int)s[i]);
        }
        System.out.println("=====");
        s = "gbpdcvkumyfxillgnqrv".toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println((int)s[i]);
        }

        System.out.println(hash3);
        System.out.println(hash4);

    }
}