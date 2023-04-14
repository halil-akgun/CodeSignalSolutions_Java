package arcade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't
let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.

The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way:
Every pixel x in the output image has a value equal to the average value of the pixel values from the 3 × 3 square that
has its center at x, including x itself. All the pixels on the border of x are then removed.

Return the blurred image as an integer, with the fractions rounded down.

Example
For
image = [[1, 1, 1],
         [1, 7, 1],
         [1, 1, 1]]
the output should be solution(image) = [[1]].
To get the value of the middle pixel in the input 3 × 3 square: (1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1.
The border pixels are cropped from the final result.

For
image = [[7, 4, 0, 1],
         [5, 6, 2, 2],
         [6, 10, 7, 8],
         [1, 4, 2, 0]]
the output should be
solution(image) = [[5, 4],
                  [4, 4]]
There are four 3 × 3 squares in the input image, so there should be four integers in the blurred output.
To get the first value: (7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5. The other three integers are obtained
the same way, then the surrounding integers are cropped from the final result.
 */
public class CS23_BoxBlur {
    public static void main(String[] args) {
        int[][] arr = {{36, 0, 18, 9, 9, 45, 27}, {27, 0, 54, 9, 0, 63, 90}, {36, 0, 18, 9, 9, 45, 27},
                {27, 0, 54, 9, 0, 63, 90}, {27, 0, 54, 9, 0, 63, 90}, {36, 0, 18, 9, 9, 45, 27}, {27, 0, 54, 9, 0, 63, 90}};
        System.out.println(Arrays.deepToString(solution(arr)));
    }

    static int[][] solution(int[][] image) {
        int height = image.length - 3 + 1;
        int width = image[0].length - 3 + 1;
        int[][] blur = new int[height][width];
        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                for (int k = 0; k < 3; k++) {
                    sum += image[i][j + k];
                    sum += image[i + 1][j + k];
                    sum += image[i + 2][j + k];
                }
                temp.add((int) sum / 9);
                sum = 0;
                if ((j + 3) == image[0].length) break;
                if (j + 4 == image[0].length) {
                    for (int k = 0; k < 3; k++) {
                        sum += image[i][(image[0].length - 3) + k];
                        sum += image[i + 1][(image[0].length - 3) + k];
                        sum += image[i + 2][(image[0].length - 3) + k];
                    }
                    temp.add((int) sum / 9);
                    sum = 0;
                    j += 100;
                }
            }
            if ((i + 3) == image.length) break;
        }
        System.out.println(temp);
        System.out.println(width);
        System.out.println(height);
        int idx = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                blur[i][j] = temp.get(idx);
                idx++;
            }
        }
        return blur;
    }

}
