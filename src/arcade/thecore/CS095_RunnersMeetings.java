package arcade.thecore;

/*
Some people run along a straight line in the same direction. They start simultaneously at pairwise
distinct positions and run with constant speed (which may differ from person to person).

If two or more people are at the same point at some moment we call that a meeting.
The number of people gathered at the same point is called meeting cardinality.

For the given starting positions and speeds of runners find the maximum meeting cardinality
assuming that people run infinitely long. If there will be no meetings, return -1 instead.

Example
For startPosition = [1, 4, 2] and speed = [27, 18, 24], the output should be
solution(startPosition, speed) = 3.

In 20 seconds after the runners start running, they end up at the same point.
Check out the gif below for better understanding:
https://codesignal.s3.amazonaws.com/uploads/1658518009418/solution_example.gif
 */
public class CS095_RunnersMeetings {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{88, 86, -77, -3, -83, 80, 58, 41, -91, 29, -26, -44, 97}, new int[]{26, 16, 14, 11, 23, 17, 6, 15, 17, 18, 14, 5, 9}));
    }

    static int solution(int[] startPosition, int[] speed) {
        int best = -1;
        for (int i = 1; i < speed.length; i++) {
            for (int j = 0; j < i; j++) {
                int m = speed[i] - speed[j];
                if (m != 0) {
                    int meet = 2;
                    int b = startPosition[j] - startPosition[i];
                    for (int k = i + 1; k < speed.length; k++) {
                        if (startPosition[k] * m + speed[k] * b ==
                                startPosition[i] * m + speed[i] * b)
                            meet++;
                    }
                    if (meet > best)
                        best = meet;
                }
            }
        }
        return best;
    }
}
