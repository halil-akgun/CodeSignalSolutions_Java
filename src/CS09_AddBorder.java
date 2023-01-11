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
public class CS09_AddBorder {
    public static void main(String[] args) {
        String[] arr = {"asd", "qwe"};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static String[] solution(String[] picture) {
        String[] brr = new String[picture.length + 2];
        StringBuilder border = new StringBuilder();
        border.append("*".repeat(Math.max(0, picture[0].length() + 2)));
        for (int i = 0; i < brr.length; i++) {
            if (i == 0 || i == brr.length - 1) {
                brr[i] = border.toString();
            } else brr[i] = "*" + picture[i - 1] + "*";
        }
        return brr;
    }
}
