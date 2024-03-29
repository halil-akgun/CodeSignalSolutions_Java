package arcade.thecore;

/*
One night you go for a ride on your motorcycle. At 00:00 you start your engine, and the built-in timer automatically
begins counting the length of your ride, in minutes. Off you go to explore the neighborhood.

When you finally decide to head back, you realize there's a chance the bridges on your route home are up,
leaving you stranded! Unfortunately, you don't have your watch on you and don't know what time it is.
All you know thanks to the bike's timer is that n minutes have passed since 00:00.

Using the bike's timer, calculate the current time. Return an answer as the sum of digits that
the digital timer in the format hh:mm would show.

Example
For n = 240, the output should be
solution(n) = 4.
Since 240 minutes have passed, the current time is 04:00. The digits sum up to 0 + 4 + 0 + 0 = 4, which is the answer.

For n = 808, the output should be
solution(n) = 14.
808 minutes mean that it's 13:28 now, so the answer should be 1 + 3 + 2 + 8 = 14.
 */
public class CS007_LateRide {
    public static void main(String[] args) {
        System.out.println(solution(240));
    }

    static int solution(int n) {
        int hour = n / 60;
        int minute = n % 60;
        int joinDigits = (hour * 100) + minute;
        int result = 0;
        while (joinDigits > 0) {
            result += joinDigits % 10;
            joinDigits /= 10;
        }
        return result;
    }
}
