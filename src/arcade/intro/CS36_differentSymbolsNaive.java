package arcade.intro;

import java.util.Arrays;

/*
Given a string, find the number of different characters in it.
Example
For s = "cabca", the output should be
solution(s) = 3.
There are 3 different characters a, b and c.
 */
public class CS36_differentSymbolsNaive {
    public static void main(String[] args) {
        String str = "cabca";
        System.out.println(solution(str));
    }

    static int solution(String s) {
        // WAY 1
//        StringBuilder length = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (!length.toString().contains(s.substring(i, i + 1))) length.append(s.substring(i, i + 1));
//        }
//        return length.length();

        // WAY 2
        return Arrays.stream(s.split("")).distinct().toArray().length;
    }
}
