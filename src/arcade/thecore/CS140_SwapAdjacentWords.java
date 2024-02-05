package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
You are given a string consisting of words separated by whitespace characters, where the words consist only of English letters. Your task is to swap pairs of consecutive words and return the result.

Example
For s = "CodeFight On", the output should be
solution(s) = "On CodeFight";
For s = "How are you today guys", the output should be
solution(s) = "are How today you guys".
 */
public class CS140_SwapAdjacentWords {
    public static void main(String[] args) {
        System.out.println(solution("CodeFight On"));
    }

    static String solution(String s) { // Codeium
        return s.replaceAll("\\b(\\w+)\\s(\\w+)\\b", "$2 $1");
    }
}
