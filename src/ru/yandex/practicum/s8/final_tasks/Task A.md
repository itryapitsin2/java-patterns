# Packed Prefix

You are given the packed strings. Let's define the packed string recursively. A string consisting only of lowercase letters
of the English alphabet is a ZC. If A and B are valid ZS, then AB is also a ZS. If A is ZC, and n is a single-digit
natural number, then n is also ZC. In this case, writing n A means that when unpacking, row A is written n times in a row.
Find the largest common prefix of the unpacked strings and print it (in unpacked form).
Input format
The first line contains the number n (1 n 1000), which is the number of rows.
Next, the packed lines are written in the lines. It is guaranteed that these strings are correct, that is, they satisfy the specified
recursive definition. The length of the lines after unpacking does not exceed 105.
Output format
Print the largest common prefix of the decompressed strings.

## Example 1

Input

3

2[a]2[ab]

3[a]2[r2[t]]

a2[aa3[b]]

Output

aaa

## Example 2
Input

3 abacabaca

2[abac]a

3[aba]

Output

aba