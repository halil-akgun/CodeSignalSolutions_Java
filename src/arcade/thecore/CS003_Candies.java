package arcade.thecore;

/*
n children have got m pieces of candy. They want to eat as much candy as they can, but each child must eat
exactly the same amount of candy as any other child. Determine how many pieces of candy will be eaten
by all the children together. Individual pieces of candy cannot be split.

Example
For n = 3 and m = 10, the output should be
solution(n, m) = 9.

Each child will eat 3 pieces. So the answer is 9.
 */
public class CS003_Candies {
    public static void main(String[] args) {
        System.out.println(solution(3, 10));
    }

    static int solution(int n, int m) {
        for (int i = m; i > 0; i--) {
            if (i % n == 0) return i;
        }
        return 0;
    }
}
