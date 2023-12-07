package arcade.thecore;

import java.util.Arrays;

/*
Your Informatics teacher at school likes coming up with new ways to help you understand
the material. When you started studying numeral systems, he introduced his own numeral
system, which he's convinced will help clarify things. His numeral system has base 26,
and its digits are represented by English capital letters - A for 0, B for 1, and so on.

The teacher assigned you the following numeral system exercise: given a one-digit number,
you should find all unordered pairs of one-digit numbers whose values add up to the number.

Example
For number = 'G', the output should be
solution(number) = ["A + G", "B + F", "C + E", "D + D"].
Translating this into the decimal numeral system we get: number = 6, so it is ["0 + 6", "1 + 5", "2 + 4", "3 + 3"].
 */
public class CS082_NewNumeralSystem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution('G')));
    }

    static String[] solution(char number) {
        String[] result = new String[(int) Math.ceil((double) (number - 'A' + 1) / 2)];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) ('A' + i) + " + " + (char) (number - i);
        }
        return result;
    }
}
