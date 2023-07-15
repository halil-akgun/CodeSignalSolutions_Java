package arcade.thecore;

import java.util.Arrays;

/*
Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

Example
For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
 */
public class CS036_ArrayReplace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(solution(arr, 1, 3)));
    }

    static int[] solution(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) inputArray[i] = substitutionElem;
        }
        return inputArray;
    }
}
