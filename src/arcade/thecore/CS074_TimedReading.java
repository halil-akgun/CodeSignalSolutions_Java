package arcade.thecore;

import java.util.Arrays;

/*
Timed Reading is an educational tool used in many schools to improve and advance reading skills.
A young elementary student has just finished his very first timed reading exercise.
Unfortunately he's not a very good reader yet, so whenever he encountered a word longer
than maxLength, he simply skipped it and read on.

Help the teacher figure out how many words the boy has read by calculating the number of
words in the text he has read, no longer than maxLength.
Formally, a word is a substring consisting of English letters, such that characters to
the left of the leftmost letter and to the right of the rightmost letter are not letters.

Example
For maxLength = 4 and
text = "The Fox asked the stork, 'How is the soup?'",
the output should be
solution(maxLength, text) = 7.
The boy has read the following words: "The", "Fox", "the", "How", "is", "the", "soup".
 */
public class CS074_TimedReading {
    public static void main(String[] args) {
        System.out.println(solution(4, "The Fox asked the stork, 'How is the soup?'"));
    }

    static int solution(int maxLength, String text) {
        return (int) Arrays.stream(text.replaceAll("\\p{Punct}", "").split(" "))
                .filter(t -> t.length() <= maxLength && t.length() > 0).count();
    }
}
