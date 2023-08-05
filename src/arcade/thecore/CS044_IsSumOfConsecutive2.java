package arcade.thecore;

/*
Find the number of ways to express n as sum of some (at least two) consecutive positive integers.

Example
For n = 9, the output should be
solution(n) = 2.
There are two ways to represent n = 9: 2 + 3 + 4 = 9 and 4 + 5 = 9.

For n = 8, the output should be
solution(n) = 0.
There are no ways to represent n = 8.
 */
public class CS044_IsSumOfConsecutive2 {
    public static void main(String[] args) {
        System.out.println(solution(2));
    }

    static int solution(int n) {
        int ans = 0;
        int sum = 0;
        boolean isAtLeastTwo = false;
        for (int i = 1; i < n / 2 + 2; i++) {
            for (int j = i; j < n / 2 + 2; j++) {
                if (sum > 0) isAtLeastTwo = true;
                sum += j;
                if (sum > n) break;
                else if (isAtLeastTwo && sum == n) {
                    ans++;
                    break;
                }
            }
            isAtLeastTwo = false;
            sum = 0;
        }
        return ans;
    }
}
