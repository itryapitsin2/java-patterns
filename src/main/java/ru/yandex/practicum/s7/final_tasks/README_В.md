# WORKING PRINCIPLE
The algorithm described in the article is used. https://ru.wikipedia.org/wiki/Задача_разбиения_множества_чисел
If the amount is odd, then it cannot be split.
If the sum is even, then it is necessary to sort through all the variants of the played pairs with possible amounts.

# TIME COMPLEXITY

`O(n * m)` - where, `n` is the number of rounds played, `m` is the half-sum of the points of all rounds.
In the worst case, it is necessary to go through all the variants of the played rounds for each number of points.


# SPATIAL COMPLEXITY

"O(m)`, where `m` is the half-sum of the points of all rounds.
We only store current data.
Therefore, the required amount of memory depends only on the half-sum of points.