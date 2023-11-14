package arcade.thecore;

/*
Given two strings a and b, both consisting only of lowercase English letters,
your task is to calculate how many strings equal to a can be constructed using
only letters from the string b? Each letter can be used only once and in one string only.

Example
For a = "abc" and b = "abccba", the output should be solution(a, b) = 2.
We can construct 2 strings a = "abc" using only letters from the string b.

For a = "ab" and b = "abcbcb", the output should be solution(a, b) = 1.
 */
public class CS059_StringsConstruction {
    public static void main(String[] args) {
        System.out.println(solution("abc", "abccba"));
    }

    static int solution(String a, String b) {
        int result = 0;
        StringBuilder temp = new StringBuilder(b);
        int idx = 0;
        while (idx >= 0) {
            for (int i = 0; i < a.length(); i++) {
                idx = temp.indexOf(String.valueOf(a.charAt(i)));
                if (idx < 0) return result;
                else temp.deleteCharAt(idx);
            }
            result++;
        }
        return result;
    }
}
