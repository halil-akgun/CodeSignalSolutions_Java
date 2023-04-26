package arcade.intro;

import java.util.List;

/*
Let's define digit degree of some positive integer as the number of times we need to replace this number
with the sum of its digits until we get to a one digit number.
Given an integer, find its digit degree.

Example
For n = 5, the output should be
solution(n) = 0;
For n = 100, the output should be
solution(n) = 1.
1 + 0 + 0 = 1.
For n = 91, the output should be
solution(n) = 2.
9 + 1 = 10 -> 1 + 0 = 1.
 */
public class CS41_digitDegree {
    public static void main(String[] args) {
        System.out.println(solution(91));
    }

    static int solution(int n) {
        List<String> list = List.of(String.valueOf(n).split(""));
        if (list.size() == 1) return 0;
        int result = 0;
        int counter = 0;
        while (list.size() > 1) {
            result = 0;
            counter++;
            for (String s : list) {
                result += Integer.parseInt(s);
            }
            list = List.of(String.valueOf(result).split(""));
        }
        return counter;
    }
}
