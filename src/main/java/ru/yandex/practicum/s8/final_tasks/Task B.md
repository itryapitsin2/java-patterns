# Cheat sheet
Tom is preparing for the algorithms exam and is writing cheat sheets just in case.
To fit as much information on them as possible, he does not separate words with spaces.
The result is one very long string.
In order not to get confused by what you read during the exam itself, he asks you to write a program that uses this long
line and a set of acceptable words to determine whether it is possible to split the text into separate words from the
set.

More formally: given a text $T$ set of strings $s_1, ..., s_n$.
It is necessary to determine whether we represent $T$ as $s_1, s_2, ..., sk$ where $k$ are the row indexes.
Indexes can be repeated.
The string s can occur an arbitrary number of times in the text division $T$.
You can't use all the rows for splitting.
The lines can be in any order.

## Input
The first line contains the text $T$, which must be divided into words.
The length of $T$ does not exceed $100100$.
The text consists of lowercase letters of the English alphabet.
The second line contains the number of acceptable words $1 < n < 100$.
The following $n$ lines contain the words themselves, consisting of small Latin letters.
The length of each word does not exceed $100$.

## Output
Print "YES" if the text can be broken down into words from this dictionary, or "NO" otherwise.

### Example
| Input                                                               | Output |
|---------------------------------------------------------------------|--------|
| examiwillpasstheexam<br/>5<br/>will<br/>pass<br/>the<br/>exam<br/>i | YES    |
| abacaba<br/>2<br/>abac<br/>caba                                     | NO     |
| abacaba<br/>3<br/>abac<br/>caba<br/>aba                             | YES    |