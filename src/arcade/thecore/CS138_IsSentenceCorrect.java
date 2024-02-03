package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
A sentence is considered correct if:

it starts with a capital letter;
it ends with a full stop, question mark or exclamation point ('.', '?' or '!');
full stops, question marks and exclamation points don't appear anywhere else in the sentence.
Given a sentence, return true if it is correct and false otherwise.

Example
For sentence = "This is an example of *correct* sentence.",
the output should be
solution(sentence) = true;

For sentence = "!this sentence is TOTALLY incorrecT",
the output should be
solution(sentence) = false.
 */
public class CS138_IsSentenceCorrect {
    public static void main(String[] args) {
        System.out.println(solution("This is an example of *correct* sentence."));
    }

    static boolean solution(String sentence) {
        String regex = "^[A-Z][^.?!]*[.?!]$";
        return sentence.matches(regex);
    }
}
