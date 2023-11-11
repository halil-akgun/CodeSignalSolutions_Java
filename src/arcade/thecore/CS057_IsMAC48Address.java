package arcade.thecore;

import java.util.Arrays;

/*
A media access control address (MAC address) is a unique identifier assigned
to network interfaces for communications on the physical network segment.
The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six
groups of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).
Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

Example
For inputString = "00-1B-63-84-45-E6", the output should be
solution(inputString) = true;
For inputString = "Z1-1B-63-84-45-E6", the output should be
solution(inputString) = false;
For inputString = "not a MAC-48 address", the output should be
solution(inputString) = false.
 */
public class CS057_IsMAC48Address {
    public static void main(String[] args) {
        System.out.println(solution("A1-1B-63-84-45-E6"));
    }

    static boolean solution(String inputString) {
        return Arrays.stream(inputString.split("-")).filter(t -> t.length() == 2).count() == 6
                && inputString.replaceAll("[0-9A-F]", "").length() == 5;

//        return Arrays.stream(inputString.split("-")).filter(t -> t.length() == 2)
//                .filter(t -> t.replaceAll("[0-9A-F]", "").isEmpty()).count() == 6;
    }
}
