package arcade.intro;

/*
Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance
between any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).

Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

Example
For n = 10 and firstNumber = 2, the output should be
solution(n, firstNumber) = 7.
image: https://codesignal.s3.amazonaws.com/uploads/1664318506/example.png?raw=true
 */
public class CS30_CircleOfNumbers {
    public static void main(String[] args) {
        System.out.println(solution(10, 2));
    }

    static int solution(int n, int firstNumber) {
        return firstNumber < n / 2 ? firstNumber + n / 2 : firstNumber - n / 2;
    }
}
