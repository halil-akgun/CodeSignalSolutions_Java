package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
Implement a function that replaces each digit in the given string with a '#' character.

Example

For input = "There are 12 points", the output should be
solution(input) = "There are ## points".
 */
public class CS139_ReplaceAllDigitsRegExp {
    public static void main(String[] args) {
        System.out.println(solution("There are 12 points"));
    }

    static String solution(String input) {
        return input.replaceAll("[0-9]", "#");
    }
}
