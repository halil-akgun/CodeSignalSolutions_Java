package arcade.intro;

/*
You are given an array of integers. On each move you are allowed to increase exactly one of its element by one.
Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

Example
For inputArray = [1, 1, 1], the output should be
solution(inputArray) = 3.
 */
public class CS17_ArrayChange {
    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        System.out.println(solution(a));
    }

    static int solution(int[] inputArray) {
        int moveCounter = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[i - 1]) {
                inputArray[i]++;
                moveCounter++;
                i--;
            }
        }
        return moveCounter;
    }
}
