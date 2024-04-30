# 2309. Greatest English Letter in Upper and Lower Case

Given a string of English letters `s`, return _the **greatest** English letter which occurs as **both** a lowercase and uppercase letter in_ `s`. 
The returned letter should be in **uppercase**. If no such letter exists, return an empty string.

An English letter `b` is **greater** than another letter `a` if `b` appears after `a` in the English alphabet.
## Example 1:

Input: `s = "l`**Ee**`TcOdE"`

Output: `E`

Explanation:
`The letter 'E' is the only letter to appear in both lower and upper case.`


## Example 2:

Input: `s = "a`**rR**`AzFif"`

Output: `R`

Explanation:
`The letter 'R' is the greatest letter to appear in both lower and upper case.
Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than 'F' or 'A'.
`

## Example 3:

Input: `s = "AbCdEfGhIjK"`

Output: `""`

Explanation:
`There is no letter that appears in both lower and upper case.`