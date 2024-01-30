package arcade.thecore;

import java.util.Arrays;

/*
You're a pretty busy billionaire, and you often fly your personal Private Jet to remote places.
Usually travel doesn't bother you, but this time you are unlucky: it's New Year's Eve, and since
you have to fly halfway around the world, you'll probably have to celebrate New Year's Day in mid-air!

Your course lies west of your current location and crosses several time zones. The pilot told you
the exact schedule: it is known that you will take off at takeOffTime, and in minutes[i] after
takeoff you will cross the ith border between time zones. After crossing each border you will have
to set your wrist watch one hour earlier (every second matters to you, so you can't let your watch
show incorrect time). It is guaranteed that you won't cross the IDL
(i.e. after crossing each time zone border your current time will be set one hour back).

You've been thinking about this situation and realized that it might be a good opportunity to celebrate
New Year's Day more than once, i.e. each time your wrist watch shows 00:00. Assuming that you set
your watch immediately after the border is crossed, how many times will you be able to celebrate
this New Year's Day with a nice bottle of champagne? Note that the answer should include celebrations
both in mid-air and on the ground (it doesn't matter if the plane landed in the last time zone before
the midnight or not, you'll not let the last opportunity to celebrate New Year slip through your fingers).

Example
For takeOffTime = "23:35" and minutes = [60, 90, 140],
the output should be
solution(takeOffTime, minutes) = 3.

Here is the list of events by the time zones:
 - initial time zone:
   - at 23:35 your flight starts;
   - at 00:00 you celebrate New Year for the first time;
   - at 00:35 (60 minutes after the take off) you cross the first border;
 - time zone -1:
   - at 23:35 you cross the border (00:35 by your initial time zone);
   - at 00:00 you celebrate New Year for the second time (01:00 by your initial time zone);
   - at 00:05 (90 minutes after the take off) you cross the second border;
 - time zone -2:
   - at 23:05 you cross the border;
   - at 23:55 (140 minutes after the take off) you cross another border;
 - time zone -3:
   - at 22:55 you cross the border;
   - at 00:00 you celebrate New Year for the third time.
Thus, the output should be 3. That's a lot of champagne!
 */
public class CS134_NewYearCelebrations {
    public static void main(String[] args) {
        System.out.println(solution("12:05", new int[]{1, 109, 113, 344, 345, 478, 545, 565, 809, 814, 838, 883, 971, 1007, 1029, 1053, 1133, 1271, 1314, 1500}));
    }

    static int solution(String takeOffTime, int[] minutes) {
        int[] time = Arrays.stream(takeOffTime.split(":")).mapToInt(Integer::parseInt).toArray();
        boolean isMidNight = false;
        int count = 0;
        int temp = 0;

        for (int minute : minutes) {
            int a = helperMethod(time, minute - temp);
            if (a > 0) {
                isMidNight = time[0] != 23;
                count += a;
            }
            temp = minute;
        }

        if (!isMidNight || (time[0] == 0 && time[1] == 0)) count++;

        return count;
    }

    private static int helperMethod(int[] time, int minute) {
        int count = 0;
        if (time[0] == 0 && time[1] == 0) count++;
        for (int i = 0; i < minute; i++) {
            time[1]++;
            if (time[1] == 60) {
                time[1] = 0;
                time[0]++;
                if (time[0] == 24) {
                    time[0] = 0;
                    count++;
                }
            }
        }
        time[0] = time[0] == 0 ? 23 : time[0] - 1;
        return count;
    }
}
