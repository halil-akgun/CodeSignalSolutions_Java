package arcade.intro;

/*
CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string
to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to
automate it, so he needs a program that sums up all the numbers which appear in the given input.

Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

Example
For inputString = "2 apples, 12 oranges", the output should be
solution(inputString) = 14.
 */
public class CS54_sumUpNumbers {
    public static void main(String[] args) {
        String str = "2 apples, 12 oranges";
        System.out.println(solution(str));
    }

    static int solution(String inputString) {
        String[] arr = inputString.replaceAll("[^0-9]", " ").split(" ");
        int sum = 0;
        for (String w : arr) {
            try {
                sum += Integer.parseInt(w);
            } catch (Exception ignored) {
            }
        }
        return sum;
    }
}
