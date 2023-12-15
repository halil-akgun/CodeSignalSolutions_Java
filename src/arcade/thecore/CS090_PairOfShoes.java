package arcade.thecore;

import java.util.Arrays;

/*
Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

- type indicates if it's a left or a right shoe;
- size is the size of the shoe.

Your task is to check whether it is possible to pair the shoes you found in such a way
that each pair consists of a right and a left shoe of an equal size.

Example
For
shoes = [[0, 21],
         [1, 23],
         [1, 21],
         [0, 23]]
the output should be
solution(shoes) = true;

For
shoes = [[0, 21],
         [1, 23],
         [1, 21],
         [1, 23]]
the output should be
solution(shoes) = false.
 */
public class CS090_PairOfShoes {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 21}, {1, 23}, {1, 21}, {0, 23}}));
    }
    static boolean solution(int[][] shoes) {
        int[] left = new int[shoes.length];
        int[] right = new int[shoes.length];
        for (int i = 0; i < shoes.length; i++) {
            if (shoes[i][0] == 0) left[i] = shoes[i][1];
            else right[i] = shoes[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        return Arrays.equals(left, right);
    }
}
