package arcade.thecore;

import java.util.Arrays;

/*
Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example
For
picture = ["abc",
           "ded"]
the output should be
solution(picture) = ["*****",
                     "*abc*",
                     "*ded*",
                     "*****"]
 */
public class CS072_AddBorder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"abc", "ded"})));
    }

    static String[] solution(String[] picture) {
        String[] result = new String[picture.length + 2];
        result[0] = "*".repeat(picture[0].length() + 2);
        result[result.length - 1] = "*".repeat(picture[0].length() + 2);
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = "*" + picture[i - 1] + "*";
        }
        return result;
    }
}
