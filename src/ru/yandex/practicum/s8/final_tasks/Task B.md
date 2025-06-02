# Cheat sheet

Tom is preparing for the algorithms exam and is writing cheat sheets just in case.
To fit as much information on them as possible, he does not separate words with spaces. The result is one very long
string. In order not to get confused by what you read during the exam itself, he asks you to write a program that uses this
long line and a set of acceptable words to determine whether it is possible to split the text into separate words from the set.
More formally: given a text set of strings S1, ..., It is necessary to determine whether we represent T as Sk...8k where k are the row indexes.
Indexes can be repeated. The string s can occur an arbitrary number of times in the text division T. You can't use all
the rows for splitting. The lines can be in any order.

Input format

The first line contains the text T, which must be divided into words. The length of T does not exceed 100100. The text consists of lowercase letters
of the English alphabet.
The second line contains the number of acceptable words 1 < n < 100.
The following n lines contain the words themselves, consisting of small Latin letters. The length of each word does not exceed 100.

Output format

Print "YES" if the text can be broken down into words from this dictionary, or "NO" otherwise.
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