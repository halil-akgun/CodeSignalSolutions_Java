package arcade;

import java.util.Arrays;

/*
Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

Example
For inputArray = [1, 2, 1], elemToReplace = 1, and substitutionElem = 3, the output should be
solution(inputArray, elemToReplace, substitutionElem) = [3, 2, 3].
 */
public class CS25_ArrayReplace {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1}, 1, 3)));
    }

    static int[] solution(int[] inputArray, int elemToReplace, int substitutionElem) {
        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) result[i] = substitutionElem;
            else result[i] = inputArray[i];
        }
        return result;
    }
}
