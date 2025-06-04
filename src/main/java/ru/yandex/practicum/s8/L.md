# Calculation of the prefix function
In this task, you need to calculate the prefix function for a given string.

## Input
A string consisting of lowercase Latin letters is entered. 
The length of the string does not exceed $10^6$.

## Output
If the length of the input string is $L$, output $L$ non-negative integers separated by spaces — the array of values of the prefix function of the original string.

### Example

| Input       | Output                |
|-------------|-----------------------|
| abracadabra | 0 0 0 1 0 1 0 1 2 3 4 |
| xxzzxxz     | 0 1 0 0 1 2 3         |
| aaaaa       | 0 1 2 3 4             |
