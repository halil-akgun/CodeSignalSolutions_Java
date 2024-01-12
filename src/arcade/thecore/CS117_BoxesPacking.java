package arcade.thecore;

import java.util.Arrays;

/*
You are given n rectangular boxes, the ith box has the length lengthi, the width widthi and the height heighti.
Your task is to check if it is possible to pack all boxes into one so that inside each box there is no more than
one another box (which, in turn, can contain at most one another box, and so on). More formally, your task is
to check whether there is such sequence of n different numbers pi (1 ≤ pi ≤ n) that for each 1 ≤ i < n
the box number pi can be put into the box number pi+1.
A box can be put into another box if all sides of the first one are less than the respective ones of the second one.
You can rotate each box as you wish, i.e. you can swap its length, width and height if necessary.

Example
For length = [1, 3, 2], width = [1, 3, 2], and height = [1, 3, 2], the output should be
solution(length, width, height) = true;
For length = [1, 1], width = [1, 1], and height = [1, 1], the output should be
solution(length, width, height) = false;
For length = [3, 1, 2], width = [3, 1, 2], and height = [3, 2, 1], the output should be
solution(length, width, height) = false.
 */
public class CS117_BoxesPacking {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9980, 9984, 9981}, new int[]{9980, 9984, 9983}, new int[]{9981, 9984, 9982}));
    }

    static boolean solution(int[] length, int[] width, int[] height) {
        long[] volume = new long[length.length];
        for (int i = 0; i < volume.length; i++) {
            volume[i] = (long) length[i] * width[i] * height[i];
        }
        long temp;
        for (int i = 0; i < length.length; i++) {
            for (int j = i + 1; j < length.length; j++) {
                if (volume[i] > volume[j]) {
                    temp = volume[i];
                    volume[i] = volume[j];
                    volume[j] = temp;
                    temp = length[i];
                    length[i] = length[j];
                    length[j] = (int) temp;
                    temp = width[i];
                    width[i] = width[j];
                    width[j] = (int) temp;
                    temp = height[i];
                    height[i] = height[j];
                    height[j] = (int) temp;
                }
            }
        }
        for (int i = 1; i < length.length; i++) {
            int[] a = {length[i - 1], width[i - 1], height[i - 1]};
            int[] b = {length[i], width[i], height[i]};
            Arrays.sort(a);
            Arrays.sort(b);
            System.out.println(volume[i - 1] + " " + volume[i]);
            if (a[0] >= b[0] || a[1] >= b[1] || a[2] >= b[2]) return false;
        }
        return true;
    }
}
