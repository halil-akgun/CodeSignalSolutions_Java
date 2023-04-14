package arcade;

/*
Given a string, output its longest prefix which contains only digits.

Example
For inputString = "123aa1", the output should be
solution(inputString) = "123".
 */
public class CS40_longestDigitsPrefix {
    public static void main(String[] args) {
        System.out.println(solution("123aa1"));
    }

    static String solution(String inputString) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            try {
                digits.append(Integer.parseInt(inputString.substring(i, i + 1)));
            } catch (NumberFormatException e) {
                return digits.toString();
            }
        }
        return digits.toString();
    }
}
