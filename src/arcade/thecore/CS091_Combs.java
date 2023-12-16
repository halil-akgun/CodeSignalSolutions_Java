package arcade.thecore;

/*
Miss X has only two combs in her possession, both of which are old and miss a tooth or two.
She also has many purses of different length, in which she carries the combs. The only way
they fit is horizontally and without overlapping. Given teeth' positions on both combs,
find the minimum length of the purse she needs to take them with her.

It is guaranteed that there is at least one tooth at each end of the comb.
It is also guaranteed that the total length of two strings is smaller than 32.
Note, that the combs can not be rotated/reversed.

Example
For comb1 = "*..*" and comb2 = "*.*", the output should be
solution(comb1, comb2) = 5.
Although it is possible to place the combs like on the first picture,
the best way to do this is either picture 2 or picture 3.
https://codesignal.s3.amazonaws.com/uploads/1664318500/cbs.png?raw=true
 */
public class CS091_Combs {
    public static void main(String[] args) {
        System.out.println(solution("*..*", "*.*"));
    }

    static int solution(String comb1, String comb2) {
        return Math.min(helperMethod(comb1, comb2), helperMethod(comb2, comb1));
    }

    private static int helperMethod(String str1, String str2) {
        boolean isValid = true;
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 0; j < Math.min(str1.length() - i, str2.length()); j++) {
                if (str1.charAt(i + j) == '*' && str2.charAt(j) == '*') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return Math.max(i + str2.length(), str1.length());
            isValid = true;
        }
        return str1.length() + str2.length();
    }
}
