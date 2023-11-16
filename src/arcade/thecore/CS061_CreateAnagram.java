package arcade.thecore;

/*
You are given two strings s and t of the same length, consisting of uppercase English letters.
Your task is to find the minimum number of "replacement operations" needed to get some
anagram of the string t from the string s. A replacement operation is performed by picking
exactly one character from the string s and replacing it by some other character.

Example
For s = "AABAA" and t = "BBAAA", the output should be
solution(s, t) = 1;
For s = "OVGHK" and t = "RPGUC", the output should be
solution(s, t) = 4.
 */
public class CS061_CreateAnagram {
    public static void main(String[] args) {
        System.out.println(solution("OVGHK", "RPGUC"));
    }

    static int solution(String s, String t) {
        StringBuilder temp = new StringBuilder(s);
        int result = 0;
        for (int i = 0; i < t.length(); i++) {
            int idx = temp.indexOf(t.substring(i, i + 1));
            if (idx != -1) {
                temp.deleteCharAt(idx);
            } else {
                result++;
            }
        }
        return result;
    }
}
