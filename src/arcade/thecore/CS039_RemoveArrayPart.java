package arcade.thecore;

import java.util.Arrays;

/*
Remove a part of a given array between given 0-based indexes l and r (inclusive).

Example
For inputArray = [2, 3, 2, 3, 4, 5], l = 2, and r = 4, the output should be
solution(inputArray, l, r) = [2, 3, 5].
 */
public class CS039_RemoveArrayPart {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solution(arr, 2, 4)));
    }

    static int[] solution(int[] inputArray, int l, int r) {
        int[] ans = new int[inputArray.length - (r - l + 1)];
        int idx = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (!(i >= l && i <= r)) ans[idx++] = inputArray[i];
        }
        return ans;
    }
}
