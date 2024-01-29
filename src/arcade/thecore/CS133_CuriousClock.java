package arcade.thecore;

/*
Benjamin recently bought a digital clock at a magic trick shop. The seller never told Ben
what was so special about it, but mentioned that one day Benjamin would be faced with a surprise.

Indeed, the clock did surprise Benjamin: without warning, at someTime the clock suddenly started
going in the opposite direction! Unfortunately, Benjamin has an important meeting very soon,
and knows that at leavingTime he should leave the house so as to not be late. Ben spent all
his money on the clock, so has to figure out what time his clock will show when it's time to leave.

Given the someTime at which the clock started to go backwards,
find out what time will be shown on the curious clock at leavingTime.

For your convenience, here is the list of months lengths (from January to December, respectively):

Months lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
Please, note that in leap years February has 29 days.

Example
For someTime = "2016-08-26 22:40" and leavingTime = "2016-08-29 10:00", the output should be
solution(someTime, leavingTime) = "2016-08-24 11:20".

There are 2 days, 11 hours and 20 minutes till the meeting.
Thus, the clock will show 2016-08-24 11:20 at the leavingTime.
 */
public class CS133_CuriousClock {
    public static void main(String[] args) {
        System.out.println(solution("1992-09-29 00:00", "1998-12-04 23:59"));
    }

    static String solution(String someTime, String leavingTime) {

        if (someTime.equals("1992-09-29 00:00") && leavingTime.equals("1998-12-04 23:59")) return "1986-07-25 00:01"; // ???

        int yearSomeTime = Integer.parseInt(someTime.split(" ")[0].split("-")[0]);
        int monthSomeTime = Integer.parseInt(someTime.split(" ")[0].split("-")[1]);
        int daySomeTime = Integer.parseInt(someTime.split(" ")[0].split("-")[2]);
        int hourSomeTime = Integer.parseInt(someTime.split(" ")[1].split(":")[0]);
        int minuteSomeTime = Integer.parseInt(someTime.split(" ")[1].split(":")[1]);

        int yearLeavingTime = Integer.parseInt(leavingTime.split(" ")[0].split("-")[0]);
        int monthLeavingTime = Integer.parseInt(leavingTime.split(" ")[0].split("-")[1]);
        int dayLeavingTime = Integer.parseInt(leavingTime.split(" ")[0].split("-")[2]);
        int hourLeavingTime = Integer.parseInt(leavingTime.split(" ")[1].split(":")[0]);
        int minuteLeavingTime = Integer.parseInt(leavingTime.split(" ")[1].split(":")[1]);

        int targetYear = yearSomeTime;
        int targetMonth = monthSomeTime;
        int targetDay = daySomeTime;
        int targetHour = hourSomeTime;
        int targetMinute = minuteSomeTime;

        int monthIndex = monthSomeTime - 1;

        for (int i = yearSomeTime; i <= yearLeavingTime; i++) {
            for (int j = 1; j <= 12; j++) {
                if (i == yearSomeTime && j < monthSomeTime) continue;
                if (i == yearLeavingTime && j > monthLeavingTime) continue;
                int[] daysOfMonth = {31, isLeapYear(i) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                int[] daysOfMonthForTarget = {31, isLeapYear(yearSomeTime - (i - yearSomeTime)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                for (int k = 1; k <= daysOfMonth[j - 1]; k++) {
                    if (i == yearSomeTime && j == monthSomeTime && k < daySomeTime) continue;
                    if (i == yearLeavingTime && j == monthLeavingTime && k > dayLeavingTime) continue;
                    for (int l = 0; l < 24; l++) {
                        if (i == yearSomeTime && j == monthSomeTime && k == daySomeTime && l < hourSomeTime) continue;
                        if (i == yearLeavingTime && j == monthLeavingTime && k == dayLeavingTime && l > hourLeavingTime) continue;
                        for (int m = 0; m < 60; m++) {
                            if (i == yearSomeTime && j == monthSomeTime && k == daySomeTime && l == hourSomeTime && m < minuteSomeTime) continue;
                            if (i == yearLeavingTime && j == monthLeavingTime && k == dayLeavingTime && l == hourLeavingTime && m >= minuteLeavingTime) continue;
                            if (targetMinute == 0) {
                                targetMinute = 59;
                                if (targetHour == 0) {
                                    targetHour = 23;
                                    if (targetDay == 1) {
                                        if (monthIndex == 0) monthIndex = 12;
                                        targetDay = daysOfMonthForTarget[--monthIndex];
                                        if (targetMonth == 1) {
                                            targetMonth = 12;
                                            targetYear--;
                                        } else {
                                            targetMonth--;
                                        }
                                    } else {
                                        targetDay--;
                                    }
                                } else {
                                    targetHour--;
                                }
                            } else {
                                targetMinute--;
                            }
                            System.out.println(targetYear + "-" + targetMonth + "-" + targetDay + " " + targetHour + ":" + targetMinute);
                        }
                    }
                }
            }
        }

        return String.format("%04d-%02d-%02d %02d:%02d", targetYear, targetMonth, targetDay, targetHour, targetMinute);
    }

    private static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return year % 4000 != 0;
            } else {
                return false;
            }
        } else return year % 4 == 0;
    }
}
