# Packed Prefix
You are given the packed strings. Let's define the packed string (PC) recursively.
A string consisting only of lowercase letters of the English alphabet is a PC.
If $A$ and $B$ are valid PC, then $AB$ is also a PC. If $A$ is PC, and $n$ is a single-digit natural number, then $n[A]$
is also PC.
In this case, writing $n$ A means that when unpacking, row $A$ is written $n$ times in a row.
Find the largest common prefix of the unpacked strings and print it (in unpacked form).

## Input
The first line contains the numb $n, 1 ≤ n ≤ 1000$, which is the number of rows.
Next, the packed lines are written in the lines. It is guaranteed that these strings are correct, that is, they satisfy
the specified recursive definition.
The length of the lines after unpacking does not exceed $10^5$.

## Output
Output the largest common prefix of the decompressed strings.

### Example
| Input                                           | Output |
|-------------------------------------------------|--------|
| 3<br/>2[a]2[ab]<br/>3[a]2[r2[t]]<br/>a2[aa3[b]] | aaa    |
| kukareku<br/>2<br/>p 1<br/>q 2                  | aba    |