# Global replacement
Write a program that replaces all occurrences of string $s$ with string $t$ in a text.
It is guaranteed that no two occurrences of pattern $s$ overlap each other.

## Input
The first line contains text — a string of lowercase letters of the English alphabet, whose length does not
exceed $106$.

The second line contains the pattern $s$, whose occurrences will be replaced.

The third line contains the string $t$, which will replace the occurrences.

Both strings $s$ and $t$ consist of lowercase letters of the English alphabet, and the length of each string does not
exceed $10^5$.
The size of the resulting string does not exceed $2 ⋅ 10^6$.
## Output

В единственной строке выведите результат всех замен — текст, в котором все вхождения $s$ заменены на $t$.

### Example

| Input                   | Output     |
|-------------------------|------------|
| pingpong<br/>ng<br/>mpi | pimpipompi |
| aaa<br/>a<br/>ab        | ababab     |