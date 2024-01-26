package arcade.thecore;

/*
Check if the given string is a correct time representation of the 24-hour clock.

Example
For time = "13:58", the output should be
solution(time) = true;
For time = "25:51", the output should be
solution(time) = false;
For time = "02:76", the output should be
solution(time) = false.
 */
public class CS130_ValidTime {
    public static void main(String[] args) {
        System.out.println(solution("13:58"));
    }

    static boolean solution(String time) {
        String[] arr = time.split(":");
        if (arr.length != 2) return false;
        try {
            int hour = Integer.parseInt(arr[0]);
            int minute = Integer.parseInt(arr[1]);
            if (hour < 0 || hour > 23) return false;
            if (minute < 0 || minute > 59) return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
