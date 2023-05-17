package arcade.thecore;

/*
Given integers a and b, determine whether the following pseudocode results in an infinite loop

while a is not equal to b do
  increase a by 1
  decrease b by 1

Assume that the program is executed on a virtual machine which can store arbitrary long numbers and execute forever.

Example
For a = 2 and b = 6, the output should be
solution(a, b) = false;
For a = 2 and b = 3, the output should be
solution(a, b) = true.
 */
public class CS012_IsInfiniteProcess {
    public static void main(String[] args) {
        System.out.println(solution(2, 6));
    }

    static boolean solution(int a, int b) {
        return a > b || (b - a) % 2 == 1;
    }
}
