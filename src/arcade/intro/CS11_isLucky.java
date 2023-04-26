package arcade.intro;

import java.util.Arrays;
import java.util.List;

/*
Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of
the first half of the digits is equal to the sum of the second half.

Given a ticket number n, determine if it's lucky or not.

Example
For n = 1230, the output should be
solution(n) = true;
For n = 239017, the output should be
solution(n) = false.
 */
public class CS11_isLucky {
    public static void main(String[] args) {
        int num = 11;
        System.out.println("solution(num) = " + solution(num));
    }

    static boolean solution(int n) {
        String a = String.valueOf(n);
        String arr[] = a.split("");
        List<String> brr = Arrays.asList(arr);
        int half1 = 0;
        int half2 = 0;
        for (int i = 0; i < brr.size(); i++) {
            if (i < brr.size() / 2) {
                half1 += Integer.parseInt(brr.get(i));
            } else {
                half2 += Integer.parseInt(brr.get(i));
            }
        }
        return (half1 == half2) ? true : false;
    }
}