package arcade.thecore;

import java.util.HashMap;
import java.util.Map;

/*
A ciphertext alphabet is obtained from the plaintext alphabet by means of rearranging some characters.
For example "bacdef...xyz" will be a simple ciphertext alphabet where a and b are rearranged.

A substitution cipher is a method of encoding where each letter of the plaintext alphabet is
replaced with the corresponding (i.e. having the same index) letter of some ciphertext alphabet.

Given two strings, check whether it is possible to obtain them from
each other using some (possibly, different) substitution ciphers.

Example
For string1 = "aacb" and string2 = "aabc", the output should be
solution(string1, string2) = true.
Any ciphertext alphabet that starts with acb... would make this transformation possible.

For string1 = "aa" and string2 = "bc", the output should be
solution(string1, string2) = false.
 */
public class CS060_IsSubstitutionCipher {
    public static void main(String[] args) {
        System.out.println(solution("aaxyaa", "aazzaa"));
    }

    static boolean solution(String string1, String string2) {
        if (string1.length() != string2.length()) return false;
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            if (map1.containsKey(String.valueOf(string1.charAt(i))) && !map1.get(String.valueOf(string1.charAt(i))).equals(String.valueOf(string2.charAt(i)))) {
                return false;
            } else {
                map1.put(String.valueOf(string1.charAt(i)), String.valueOf(string2.charAt(i)));
            }
            if (map2.containsKey(String.valueOf(string2.charAt(i))) && !map2.get(String.valueOf(string2.charAt(i))).equals(String.valueOf(string1.charAt(i)))) {
                return false;
            } else {
                map2.put(String.valueOf(string2.charAt(i)), String.valueOf(string1.charAt(i)));
            }
        }
        return true;
    }
}
