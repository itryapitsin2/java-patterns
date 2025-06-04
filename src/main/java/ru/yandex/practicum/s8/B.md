# Customs

Imagine that you work as a border guard and constantly check people's documents against the database. In this case, it
is acceptable if a person's name in the database differs from the name in their passport by one replacement, one
deletion, or one insertion of a character. If one version of the name can be obtained from another by deleting one
character, the person will be allowed to cross the border. But if there is any other change, the person will sadly go
home or to the embassy.

For example, if the first variant is “Lena” and the second is “Lera,” the girl will be allowed to pass. A person will
also be allowed to pass if the database contains “Kolya” and the passport contains “Olya.”

However, the option where the database lists “Innokenty” and the passport says “Nnakenty” will not work. A person whose
passport says “Iinnnokenty” will also not be allowed to pass, but “Innokenty” will cross the border without any
problems.

Write a program that compares the name in the database with the name in the passport and decides whether to let the
person through or not. If the two lines are the same, the traveler is naturally allowed to pass.

## Input

The first line contains the name from the passport.

The second line contains the name from the database.

Both lines consist of lowercase letters of the English alphabet. 
The size of each line does not exceed $100,000$
characters.

## Output

Display “OK” if the person is allowed to pass, or “FAIL” otherwise.

### Example

| Input               | Output |
|---------------------|--------|
| abcdefg <br/>abdefg | OK     |
| helo <br/>hello     | OK     |
| dog <br/>fog        | OK     |
| mama <br/>papa      | FAIL   |