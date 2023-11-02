package arcade.thecore;

/*
Given a string, enclose it in round brackets.

Example
For inputString = "abacaba", the output should be
solution(inputString) = "(abacaba)".
 */
public class CS051_EncloseInBrackets {
    public static void main(String[] args) {
        System.out.println(solution("RoSE"));
    }

    static String solution(String inputString) {
        return "(" + inputString + ")";
    }
}
