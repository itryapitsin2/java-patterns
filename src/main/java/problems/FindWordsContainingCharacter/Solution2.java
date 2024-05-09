package problems.FindWordsContainingCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * The solution uses indexOf-method which has O(n) time complexity like for-loop
 */
class Solution2 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                list.add(i);
            }
        }
        System.gc();
        return list;
    }
}