package problems.FindWordsContainingCharacter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The solution is very slow
 */
class Solution1 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            Set<Character> chars = words[i]
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toCollection(HashSet::new));

            boolean has = chars.contains(x);

            if(has) {
                result.add(i);
            }
        }

        return result;
    }
}