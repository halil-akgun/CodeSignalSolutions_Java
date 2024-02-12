package arcade.thecore;

import java.util.Arrays;

/*
During your most recent trip to Codelandia you decided to buy a brand new CodePlayer,
a music player that (allegedly) can work with any possible media format. As it turns out,
this isn't true: the player can't read lyrics written in the LRC format. It can, however,
read the SubRip format, so now you want to translate all the lyrics you have from LRC to SubRip.

Since you are a pro programmer (no noob would ever get to Codelandia!), you're happy to implement
a function that, given lrcLyrics and songLength, returns the lyrics in SubRip format.

Example
For
lrcLyrics = ["[00:12.00] Happy birthday dear coder,",
             "[00:17.20] Happy birthday to you!"]
and songLength = "00:00:20", the output should be
solution(lrcLyrics, songLength) = [
  "1",
  "00:00:12,000 --> 00:00:17,200",
  "Happy birthday dear coder,",
  "",
  "2",
  "00:00:17,200 --> 00:00:20,000",
  "Happy birthday to you!"
]
 */
public class CS147_LRCToSubRip {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"[00:12.00] Happy birthday dear coder,", "[00:17.20]"}, "00:00:20"
        )));
    }

    static String[] solution(String[] lrcLyrics, String songLength) {
        String[] result = new String[lrcLyrics.length * 4 - 1];
        int idx = 0;
        for (int i = 0; i < lrcLyrics.length - 1; i++) {
            result[idx++] = String.valueOf(i + 1);
            String currentTime = lrcLyrics[i].substring(1, lrcLyrics[i].indexOf("]"));
            String nextTime = lrcLyrics[i + 1].substring(1, lrcLyrics[i].indexOf("]"));
            result[idx++] = convertToSubRipTime(currentTime, nextTime);
            result[idx++] = getMessage(lrcLyrics[i]);
            result[idx++] = "";
        }
        result[idx++] = String.valueOf(lrcLyrics.length);
        result[idx++] = convertToSubRipTime(lrcLyrics[lrcLyrics.length - 1].substring(1, lrcLyrics[lrcLyrics.length - 1].indexOf("]")), convertSongLengthToSubRipFormat(songLength));
        result[idx] = getMessage(lrcLyrics[lrcLyrics.length - 1]);
        return result;
    }

    private static String getMessage(String lrcLyric) {
        String message = lrcLyric.substring(lrcLyric.indexOf("]") + 1);
        return message.isEmpty() ? message : message.substring(1);
    }

    private static String convertSongLengthToSubRipFormat(String songLength) {
        int[] lengthArray = Arrays.stream(songLength.split(":")).mapToInt(Integer::parseInt).toArray();
        return String.format("%02d:%02d:00", lengthArray[0] * 60 + lengthArray[1], lengthArray[2]);
    }

    private static String convertToSubRipTime(String currentTime, String nextTime) {
        int[] currentTimeArray = Arrays.stream(currentTime.split("[:.]")).mapToInt(Integer::parseInt).toArray();
        int[] nextTimeArray = Arrays.stream(nextTime.split("[:.]")).mapToInt(Integer::parseInt).toArray();
        int currentTimeHour = currentTimeArray[0] / 60;
        currentTimeArray[0] = currentTimeArray[0] % 60;
        int nextTimeHour = nextTimeArray[0] / 60;
        nextTimeArray[0] = nextTimeArray[0] % 60;

        String currentTimeSubRip = String.format("%02d:%02d:%02d,%03d", currentTimeHour, currentTimeArray[0], currentTimeArray[1], currentTimeArray[2] * 10);
        String nextTimeSubRip = String.format("%02d:%02d:%02d,%03d", nextTimeHour, nextTimeArray[0], nextTimeArray[1], nextTimeArray[2] * 10);

        return currentTimeSubRip + " --> " + nextTimeSubRip;
    }
}
