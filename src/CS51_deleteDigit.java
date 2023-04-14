/*
Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

Example
For n = 152, the output should be
solution(n) = 52;
For n = 1001, the output should be
solution(n) = 101.
 */
public class CS51_deleteDigit {
    public static void main(String[] args) {
        System.out.println(solution(152));
    }

    static int solution(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int max = n / 10;
        int temp;
        for (int i = 0; i < sb.length(); i++) {
            temp = Integer.parseInt(sb.deleteCharAt(i).toString());
            System.out.println(temp);
            max = Math.max(max, temp);
            sb = new StringBuilder(String.valueOf(n));
        }
        return max;
    }
}
