package arcade.thecore;

/*
Whenever you decide to celebrate your birthday you always do this your favorite café,
which is quite popular and as such usually very crowded. This year you got lucky:
when you and your friend enter the café you're surprised to see that it's almost empty.
The waiter lets slip that there are always very few people on this day of the week.

You enjoyed having the café all to yourself, and are now curious about the next time you'll be this lucky.
Given the current birthdayDate, determine the number of years until it will fall on the same day of the week.

For your convenience, here is the list of months lengths (from January to December, respectively):

Months lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
Please, note that in leap years February has 29 days. If your birthday is on the 29th of February,
you celebrate it once in four years. Otherwise you birthday is celebrated each year.

Example
For birthdayDate = "02-01-2016", the output should be
solution(birthdayDate) = 5.

February 1 in 2016 is a Monday. The next year in which this same date will be
Monday too is 2021. 2021 - 2016 = 5, which is the answer.
 */
public class CS132_DayOfWeek {
    public static void main(String[] args) {
        System.out.println(solution("02-01-2016"));
    }

    static int solution(String birthdayDate) {
        String[] arr = birthdayDate.split("-");
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        int checkingYear = year;
        int dayOfWeekBirthday = calculateDayOfWeek(month, day, checkingYear);

        while (true) {
            checkingYear++;
            int nextBirthdayDayOfWeek = calculateDayOfWeek(month, day, checkingYear);

            if (dayOfWeekBirthday == nextBirthdayDayOfWeek) {
                return checkingYear - year;
            }
        }
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

    private static int calculateDayOfWeek(int month, int day, int year) {
        int[] monthLengths = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;
        for (int i = 1; i < month; i++) {
            days += monthLengths[i - 1];
        }
        days += day;

        for (int i = 1900; i < year; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }

        return (days + 1) % 7; // +1 cunku 1900 yili pazartesi ile basliyor
    }
}
