package arcade.thecore;

/*
Determine if the given number is a power of some non-negative integer.

Example
For n = 125, the output should be
solution(n) = true;
For n = 72, the output should be
solution(n) = false.
 */
public class CS043_IsPower {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }

    static boolean solution(int n) {
        if (n < 1) return false;
        if (n == 1) return true;

        int temp;

        for (int i = 2; i < n / 2; i++) {
            for (int j = 2; j < n / 2; j++) {
                temp = (int) Math.pow(i, j);
                if (temp == n) return true;
                if (temp > n) break;
            }
        }

        return false;
    }
}
