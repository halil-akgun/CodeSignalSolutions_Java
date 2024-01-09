package arcade.thecore;

import java.util.Arrays;

/*
A noob programmer was given two simple tasks: sum and sort the elements of the given array
a = [a1, a2, ..., an]. He started with summing and did it easily, but decided to store the sum he found in
some random position of the original array which was a bad idea. Now he needs to cope with the second task,
sorting the original array a, and it's giving him trouble since he modified it.

Given the array shuffled, consisting of elements a1, a2, ..., an, a1 + a2 + ... + an in random order,
return the sorted array of original elements a1, a2, ..., an.

Example
For shuffled = [1, 12, 3, 6, 2], the output should be
solution(shuffled) = [1, 2, 3, 6].
1 + 3 + 6 + 2 = 12, which means that 1, 3, 6 and 2 are original elements of the array.

For shuffled = [1, -3, -5, 7, 2], the output should be
solution(shuffled) = [-5, -3, 2, 7].
 */
public class CS114_ShuffledArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 12, 3, 6, 2})));
    }

    static int[] solution(int[] shuffled) {
        return Arrays.stream(getOriginalElements(shuffled)).sorted().toArray();
    }

    private static int[] getOriginalElements(int[] arr) {
        int total = Arrays.stream(arr).sum();
        int undesired = total / 2;
        int[] result = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != undesired || idx != i) result[idx++] = arr[i]; // 'idx != i' : to skip other undesireds
        }
        return result;
    }
}
