# Insert

Rita had string s, and Gosha gave her n other strings $t_i$, $1≤ i≤ n$, on March 8.
Now Rita is thinking about where to put them.
One option is to place the gifted strings inside the existing string $s$, placing the string $t_i$ immediately after the
character of string $s$ with number $k_i$ (in particular, if $k_i=0$, then the string is inserted at the very beginning
of $s$).

Help Rita and determine what string will result after inserting all the strings gifted by Gosha into $s$.

## Input

The first line contains a string $s$. The string consists of lowercase letters of the English alphabet, is not empty,
and its length does not exceed $10^5$ characters.

The second line contains the number of gifted strings — a natural number $n, 1 ≤ n ≤ 10^5$.

Each of the following $n$ lines contains pairs $t_i$ and $k_i$ separated by a space. The string $t_i$ consists of
lowercase Latin letters and is never empty.
$k_i$ is an integer in the range from $0$ to $|s|$.
All $k_i$ values are unique.
It is guaranteed that the total length of all $t_i$ strings does not exceed $10^5$.

## Output

Output the resulting string.

### Example

| Input                                              | Output                 |
|----------------------------------------------------|------------------------|
| abacaba<br/>3 <br/>queue 2<br/>deque 0<br/>stack 7 | dequeabqueueacabastack |
| kukareku<br/>2<br/>p 1<br/>q 2                     | kpuqkareku             |