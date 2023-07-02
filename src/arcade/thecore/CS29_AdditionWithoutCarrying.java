package arcade.thecore;

/*
A little child is studying arithmetic. They have just learned how to add two integers,
written one below another, column by column. But the child always forgets about the important part - carrying.

Given two integers, your task is to find the result that the child will get.

Example
For param1 = 456 and param2 = 1734, the output should be
solution(param1, param2) = 1180.

   456
  1734
+_____
  1180
The child performs the following operations from right to left:
 - 6 + 4 = 10 but the child forgets about carrying the 1 and just writes down the 0 in the last column
 - 5 + 3 = 8
 - 4 + 7 = 11 but the child forgets about the leading 1 and just writes down 1 under 4 and 7.
 - There is no digit in the first number corresponding to the leading digit of the second one,
   so the child imagines that 0 is written before 456. Thus, they get 0 + 1 = 1.
 */
public class CS29_AdditionWithoutCarrying {
    public static void main(String[] args) {
        System.out.println(solution(0, 0));
    }

    static int solution(int param1, int param2) {
        StringBuilder result = new StringBuilder();
        while (param1 > 0 || param2 > 0) {
            int temp = param1 % 10 + param2 % 10;
            int temp2 = temp > 9 ? temp % 10 : temp;
            result.insert(0, temp2);
            param1 /= 10;
            param2 /= 10;
        }
        return result.length() != 0 ? Integer.parseInt(result.toString()) : 0;
    }
}
