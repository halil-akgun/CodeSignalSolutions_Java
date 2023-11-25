package arcade.thecore;

import java.util.stream.IntStream;

/*
Check whether the given string is a subsequence of the plaintext alphabet.

Example
For s = "effg", the output should be
solution(s) = false;
For s = "cdce", the output should be
solution(s) = false;
For s = "ace", the output should be
solution(s) = true;
For s = "bxz", the output should be
solution(s) = true.
 */
public class CS070_AlphabetSubsequence {
    public static void main(String[] args) {
        System.out.println(solution("efg"));
    }

    static boolean solution(String s) {
        return IntStream.range(1, s.length()).allMatch(i -> s.charAt(i - 1) < s.charAt(i));
    }
}
