package arcade.intro;

/*
Write a function that returns the sum of two numbers.

Example
For param1 = 1 and param2 = 2, the output should be
solution(param1, param2) = 3.
 */
public class CS01_add {
    public static void main(String[] args) {
        System.out.println(solution(1, 2));
    }

    static int solution(int param1, int param2) {
        return param1 + param2;
    }
}
