package arcade.thecore;

import java.util.Arrays;

/*
You have been watching a video for some time. Knowing the total video duration find out
what portion of the video you have already watched.

Example
For part = "02:20:00" and total = "07:00:00", the output should be
solution(part, total) = [1, 3].

You have watched 1 / 3 of the whole video.
 */
public class CS131_VideoPart {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("02:20:00", "07:00:00")));
    }

    static int[] solution(String part, String total) {
        String[] arrPart = part.split(":");
        String[] arrTotal = total.split(":");
        int partTime = Integer.parseInt(arrPart[0]) * 3600 + Integer.parseInt(arrPart[1]) * 60 + Integer.parseInt(arrPart[2]);
        int totalTime = Integer.parseInt(arrTotal[0]) * 3600 + Integer.parseInt(arrTotal[1]) * 60 + Integer.parseInt(arrTotal[2]);

        return getRatio(partTime, totalTime);
    }

    private static int[] getRatio(int partTime, int totalTime) {
        int min = Math.min(partTime, totalTime);
        for (int i = 2; i <= min; i++) {
            if (partTime % i == 0 && totalTime % i == 0) {
                partTime = partTime / i;
                totalTime = totalTime / i;
                min = min / i;
                i = 1;
            }
        }
        return new int[]{partTime, totalTime};
    }
//    private static int[] getRatio(int partTime, int totalTime) { // chatGPT
//        int gcd = findGCD(partTime, totalTime);
//
//        partTime /= gcd;
//        totalTime /= gcd;
//
//        return new int[]{partTime, totalTime};
//    }
//    private static int findGCD(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
}
