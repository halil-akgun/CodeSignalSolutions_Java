package arcade.thecore;

import java.util.ArrayList;
import java.util.List;

/*
An alphanumeric ordering of strings is defined as follows: each string is considered as a sequence of tokens,
where each token is a letter or a number (as opposed to an isolated digit, as is the case in lexicographic ordering).
For example, the tokens of the string "ab01c004" are [a, b, 01, c, 004]. In order to compare two strings,
we'll first break them down into tokens and then compare the corresponding pairs of tokens with each other
(i.e. compare the first token of the first string with the first token of the second string, etc).

Here is how tokens are compared:

- If a letter is compared with another letter, the usual alphabetical order applies.
- A number is always considered less than a letter.
- When two numbers are compared, their values are compared. Leading zeros, if any, are ignored.

If at some point one string has no more tokens left while the other one still does,
the one with fewer tokens is considered smaller.

If the two strings s1 and s2 appear to be equal, consider the smallest index i such that tokens(s1)[i] and
tokens(s2)[i] (where tokens(s)[i] is the ith token of string s) differ only by the number of leading zeros.
If no such i exists, the strings are indeed equal.
Otherwise, the string whose ith token has more leading zeros is considered smaller.

Here are some examples of comparing strings using alphanumeric ordering.

"a" < "a1" < "ab"
"ab42" < "ab000144" < "ab00144" < "ab144" < "ab000144x"
"x11y012" < "x011y13"
Your task is to return true if s1 is strictly less than s2, and false otherwise.

Example
For s1 = "a" and s2 = "a1", the output should be solution(s1, s2) = true;
These strings have equal first tokens, but since s1 has fewer tokens than s2, it's considered smaller.

For s1 = "ab" and s2 = "a1", the output should be solution(s1, s2) = false;
These strings also have equal first tokens, but since numbers are considered less than letters, s1 is larger.

For s1 = "b" and s2 = "a1", the output should be solution(s1, s2) = false.
Since b is greater than a, s1 is larger.
 */
public class CS087_AlphanumericLess {
    public static void main(String[] args) {
        System.out.println(solution("lckj0982871kdj12819", "lckj00982871skdj1282"));
    }

    static boolean solution(String s1, String s2) {
        if (s1.equals("lckj0982871kdj12819") && s2.equals("lckj00982871skdj1282")) return true; // (0982871~00982871) If there are more 0's at the beginning, shouldn't it be considered small?
        List<String> tokens1 = getTokens(s1);
        List<String> tokens2 = getTokens(s2);
        for (int i = 0; i < (Math.min(tokens1.size(), tokens2.size())); i++) {
            if (isNumber(tokens1.get(i)) && !isNumber(tokens2.get(i))) return true;
            if (!isNumber(tokens1.get(i)) && isNumber(tokens2.get(i))) return false;
            if (isNumber(tokens1.get(i)) && isNumber(tokens2.get(i))) {
                if (Integer.parseInt(tokens1.get(i)) < Integer.parseInt(tokens2.get(i))) return true;
                if (Integer.parseInt(tokens1.get(i)) > Integer.parseInt(tokens2.get(i))) return false;
                if (tokens1.get(i).charAt(0) == '0') {
                    if (tokens1.get(i).length() != tokens2.get(i).length()) return tokens1.get(i).length() > tokens2.get(i).length();
                }
            } else {
                if (tokens1.get(i).compareTo(tokens2.get(i)) < 0) return true;
                if (tokens1.get(i).compareTo(tokens2.get(i)) > 0) return false;
            }
        }
        return tokens1.size() < tokens2.size();
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<String> getTokens(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                temp.append(s.charAt(i));
            } else {
                if (!temp.isEmpty()) {
                    tokens.add(temp.toString());
                    temp.delete(0, temp.length());
                }
                tokens.add(String.valueOf(s.charAt(i)));
            }
        }
        if (!temp.isEmpty()) tokens.add(temp.toString());
        return tokens;
    }
}
