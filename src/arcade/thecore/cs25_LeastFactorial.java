package arcade.thecore;

/*
Given an integer n, find the minimal k such that

k = m! (where m! = 1 * 2 * ... * m) for some integer m;
k >= n.
In other words, find the smallest factorial which is not less than n.

Example
For n = 17, the output should be
solution(n) = 24.

17 < 24 = 4! = 1 * 2 * 3 * 4, while 3! = 1 * 2 * 3 = 6 < 17).
 */
public class cs25_LeastFactorial {
    public static void main(String[] args) {
        System.out.println(solution(17));
    }

    static int solution(int n) {
        if (n == 1) return 1;
        int result = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            result *= i;
            if (result >= n) return result;
        }
        return result;
    }
}
