/*
Determine if the given character is a digit or not.

Example
For symbol = '0', the output should be
solution(symbol) = true;
For symbol = '-', the output should be
solution(symbol) = false.
 */
public class CS48_isDigit {
    public static void main(String[] args) {
        System.out.println(solution('a'));
    }

    static boolean solution(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }
}
