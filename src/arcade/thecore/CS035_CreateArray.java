package arcade.thecore;

import java.util.Arrays;

/*
Given an integer size, return array of length size filled with 1s.

Example
For size = 4, the output should be
solution(size) = [1, 1, 1, 1].
 */
public class CS035_CreateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    static int[] solution(int size) {
        return Arrays.stream(new int[size]).map(t -> 1).toArray();
    }
}
