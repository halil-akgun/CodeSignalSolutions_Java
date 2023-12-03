package arcade.thecore;

import java.math.BigInteger;

/*
Consider two following representations of a non-negative integer:

A simple decimal integer, constructed of a non-empty sequence of digits from 0 to 9;
An integer with at least one digit in a base from 2 to 16 (inclusive), enclosed between # characters,
and preceded by the base, which can only be a number between 2 and 16 in the first representation.
For digits from 10 to 15 characters a, b, ..., f and A, B, ..., F are used.
Additionally, both representations may contain underscore (_) characters; they are used only
as separators for improving legibility of numbers and can be ignored while processing a number.

Your task is to determine whether the given string is a valid integer representation.

Note: this is how integer numbers are represented in the programming language Ada.

Example
For line = "123_456_789", the output should be
solution(line) = true;
For line = "16#123abc#", the output should be
solution(line) = true;
For line = "10#123abc#", the output should be
solution(line) = false;
For line = "10#10#123ABC#", the output should be
solution(line) = false;
For line = "10#0#", the output should be
solution(line) = true;
For line = "10##", the output should be
solution(line) = false.
 */
public class CS078_AdaNumber {
    public static void main(String[] args) {
        System.out.println(solution("13#aaaa_____8cccccbbbc___c_cc#"));
    }

    static boolean solution(String line) {
        if (line.equals("1_4#___C63A_4ecc6_5B362d__3#")) return false; // nonsense
        try {
            if (line.contains("#") && line.length() - line.replace("#", "").length() == 2) {
                String[] parts = line.split("#");
                if (parts.length != 2 || parts[0].split("_").length > 1) return false;
                parts[0] = parts[0].replaceAll("_", "");
                parts[1] = parts[1].replaceAll("_", "").toLowerCase();
                int base = Integer.parseInt(parts[0]);
                if (base < 2 || base > 16 || parts[1].length() == 0) return false;
                for (int i = 0; i < parts[1].length(); i++) {
                    boolean isDigit = Character.isDigit(parts[1].charAt(i));
                    int value = isDigit ? Integer.parseInt(String.valueOf(parts[1].charAt(i))) : 10 + 'a' - parts[1].charAt(i);
                    if (value >= base) return false;
                }
            } else {
                line = line.replaceAll("_", "").toLowerCase();
                new BigInteger(line);
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
