# Compare two strings
Alla has devised a new method for comparing two strings: to compare strings $a$ and $b$, only those letters that appear
in even positions in the English alphabet should be retained.
The resulting strings are then compared according to the usual rules.
Please assist Alla in implementing this new string comparison method.

## Input
The input consists of strings $a$ and $b$, one per line.
Both strings consist of lowercase Latin letters, are not empty, and do not exceed $10^5$ characters in length.

## Output
Output $-1$ if $a < b$, $0$ if $a = b$, and $1$ if $a > b$.

### Example

| Input             | Output |
|-------------------|--------|
| gggggbbb<br/>bbef | -1     |
| z<br/>aaaaaaa     | 1      |
| ccccz<br/>aaaaaz  | 0      |
