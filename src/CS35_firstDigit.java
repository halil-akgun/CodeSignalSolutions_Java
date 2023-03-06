/*
Find the leftmost digit that occurs in a given string.

Example
For inputString = "var_1__Int", the output should be
solution(inputString) = '1';
For inputString = "q2q-q", the output should be
solution(inputString) = '2';
For inputString = "0ss", the output should be
solution(inputString) = '0'.
 */
public class CS35_firstDigit {
    public static void main(String[] args) {
        String str = "ASDfgh123";
        System.out.println(solution(str));
    }

    static char solution(String inputString) {
        return inputString.replaceAll("[^0-9]", "").charAt(0);
    }
}
