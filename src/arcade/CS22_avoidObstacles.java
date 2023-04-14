package arcade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of integers representing coordinates of obstacles situated on a straight line.

Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of
the same length represented by some integer.

Find the minimal length of the jump enough to avoid all the obstacles.

Example
For inputArray = [5, 3, 6, 7, 9], the output should be
solution(inputArray) = 4.

Check out the image below for better understanding:
https://codesignal.s3.amazonaws.com/uploads/1667239739797/example.png
 */
public class CS22_avoidObstacles {
    public static void main(String[] args) {
        int[] arr = {1000, 999};
        System.out.println("solution(arr) = " + solution(arr));
    }

    static int solution(int[] inputArray) {
        Arrays.sort(inputArray);
        int max = inputArray[inputArray.length - 1];
        List<Integer> arr = new ArrayList<>();
        for (int w : inputArray) {
            arr.add(w);
        }
        boolean control = true;
        int result = max + 1;
        for (int i = 2; i <= max; i++) {
            control = true;
            for (int j = i; j <= max; j += i) {
                if (arr.contains(j)) {
                    control = false;
                    break;
                }
            }
            if (control) {
                result = i;
                break;
            }
        }
        return result;
    }
}
