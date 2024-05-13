package problems.medium.FindTheOriginalArrayOfPrefixXor;

public class Solution1 {

    public int[] findArray(int[] pref) {
        int tmp = pref[0];
        for(int i = 1; i < pref.length; i++) {
            int a = pref[i];
            pref[i] = pref[i] ^ tmp;
            tmp = a;
        }
        System.gc();
        return pref;
    }
}
