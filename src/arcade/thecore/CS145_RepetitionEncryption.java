package arcade.thecore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
Jane just got a letter from her friend and realized that something's wrong: some words in the letter are
written twice in a row. The thing is, she and her friend devised an ingenious cypher, the key to which is
the number of pairs of repeated words in the encoded text. The cases of the words don't matter.

Formally, a word is a substring of letter consisting of English letters, such that characters to
the left of the leftmost letter and to the right of the rightmost letter are not letters.

For obvious reasons, Jane can't tell you how the encryption works, but she needs your help with calculating
the number of pairs of consecutive equal words. Write a function that, given a letter, returns this number.

Example
For letter = "Hi, hi Jane! I'm so. So glad to to finally be able to write - WRITE!! - to you!",
the output should be
solution(letter) = 4.
 */
public class CS145_RepetitionEncryption {
    public static void main(String[] args) {
        System.out.println(solution("Hi, hi Jane! I'm so. So glad to to finally be able to write - WRITE!! - to you!"));
    }

    static int solution(String letter) {
        Pattern pattern = Pattern.compile("([a-z]+)[^a-z]+\\1(?:$|[^a-z])", Pattern.CASE_INSENSITIVE); // Solution by bandorthild (codesignal)
        Matcher matcher = pattern.matcher(letter);

        int res = 0;
        while (matcher.find()) {
            res++;
        }
        return res;
    }
}
