package problems.easy.GreatestEnglishLetterInUpperAndLowerCase;

public class Solution2 {
    public String greatestLetter(String s) {
        for(char i='Z';i>='A';i--)
        {
            if(s.indexOf(i)!=-1 && s.indexOf(Character.toLowerCase(i))!=-1)
                return i+"";
        }
        return "";
    }
}
