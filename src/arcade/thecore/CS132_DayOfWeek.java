package arcade.thecore;

import java.time.LocalDate;

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
        System.out.println(solution("02-29-2072"));
    }

    static int solution(String birthdayDate) {
        String[] arr = birthdayDate.split("-");
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        int checkingYear = year;
        int indexOfDay = 0;

        while (true) {
            checkingYear++;

            if (day == 29 && month == 2) {
                if (isLeapYear(checkingYear - 1)) {
                    indexOfDay += 5;
                    checkingYear += 3;
                } else {
                    indexOfDay += 9;
                    checkingYear += 7;
                }
            } else if (day <= 28 && month < 3 && isLeapYear(checkingYear - 1)) {
                indexOfDay += 2;
            } else if (month > 2 && isLeapYear(checkingYear)) {
                indexOfDay += 2;
            } else {
                indexOfDay += 1;
            }

            if (indexOfDay % 7 == 0) {
                if (day == 29 && month == 2 && !isLeapYear(checkingYear)) continue;
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

    static int solution2(String birthdayDate) {
        String[] arr = birthdayDate.split("-");
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        int checkingYear = year;
        int dayOfWeekBirthday = LocalDate.of(year, month, day).getDayOfWeek().getValue();

        while (true) {
            checkingYear++;
            try {
                int nextBirthdayDayOfWeek = LocalDate.of(checkingYear, month, day).getDayOfWeek().getValue();

                if (dayOfWeekBirthday == nextBirthdayDayOfWeek) {
                    return checkingYear - year;
                }
            } catch (Exception ignored) {
            }
        }
    }
}
