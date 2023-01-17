import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Given two strings, find the number of common characters between them.

Example
For s1 = "aabcc" and s2 = "adcaa", the output should be
solution(s1, s2) = 3.

Strings have 3 common characters - 2 "a"s and 1 "c".
 */
public class CS10_CommonCharacterCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        System.out.println(solution(a, b));

    }

    static int solution(String s1, String s2) {
        int counter = 0;
        String arr[] = s1.split("");
        List<String> brr = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            brr.add(String.valueOf(s2.charAt(i)));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(brr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.size(); j++) {
                if (arr[i].equals(brr.get(j))) {
                    counter++;
                    brr.remove(j);
                    break;
                }
            }
        }
        return counter;
    }
}
