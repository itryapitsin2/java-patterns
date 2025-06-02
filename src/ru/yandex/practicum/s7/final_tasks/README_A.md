# WORKING PRINCIPLE
The algorithm described in the article is used. https://ru.wikipedia.org/wiki/Levenshtein Distance
The cost of all operations (replacement, insertion, or deletion) is the same and is equal to 1.
We compare characters in words in pairs.
The sum of the operations is accumulated in the cells of the array.
The cell value does not change if the characters do not differ, and increases by 1 otherwise.

# TIME COMPLEXITY

'O(n*m)` - compare all combinations of characters in pairs.

# SPATIAL COMPLEXITY

'O(min(n,m))`, where `min(n,m)` is the maximum number of characters in the words being compared.
`n` and `m` are the lengths of the words.