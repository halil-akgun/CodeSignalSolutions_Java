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
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{27, 18, 24}));
    }

    static int solution(int[] startPosition, int[] speed) {
        int maxMeetings = -1;
        int meetingPoint;
        int currentMeeting = -1;
        for (int i = 0; i < speed.length; i++) {
            for (int j = i + 1; j < speed.length; j++) {
                meetingPoint = (startPosition[i] - startPosition[j]) / (speed[j] - speed[i]);
                if (meetingPoint >= 0) {
                    currentMeeting = 2;
                    for (int k = j + 1; k < speed.length; k++) {
                        if (startPosition[i] + speed[i] * meetingPoint == startPosition[k] + speed[k] * meetingPoint) {
                            currentMeeting++;
                        }
                    }
                }
            }
            maxMeetings = Math.max(maxMeetings, currentMeeting);
        }
        return maxMeetings;
    }
}
