package arcade.thecore;

/*
Given a character, check if it represents an odd digit, an even digit or not a digit at all.

Example
For symbol = '5', the output should be
solution(symbol) = "odd";
For symbol = '8', the output should be
solution(symbol) = "even";
For symbol = 'q', the output should be
solution(symbol) = "not a digit".
 */
public class CS080_CharacterParity {
    public static void main(String[] args) {
        System.out.println(solution('5'));
    }

    static String solution(char symbol) {
        return !Character.isDigit(symbol) ? "not a digit"
                : Integer.parseInt(String.valueOf(symbol)) % 2 == 0 ? "even"
                : "odd";
    }
}
