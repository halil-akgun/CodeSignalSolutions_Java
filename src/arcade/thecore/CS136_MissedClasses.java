package arcade.thecore;

import java.util.Arrays;

/*
Your Math teacher takes education very seriously, and hates it when a class is missed or canceled for
any reason. He even made up the following rule: if a class is missed because of a holiday,
the teacher will compensate for it with a makeup class after school.

You're given an array, daysOfTheWeek, with the weekdays on which your teacher's classes are scheduled,
and holidays, representing the dates of the holidays throughout the academic year (from 1st of September
in year to 31st of May in year + 1). How many times will you be forced to stay after school for a
makeup class because of holiday conflicts in the current academic year?

For your convenience, here is the list of month lengths (from January to December, respectively):

Month lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
Please note that in leap years February has 29 days.

Example
For year = 2015, daysOfTheWeek = [2, 3], and
holidays = ["11-04", "02-22", "02-23", "03-07", "03-08", "05-09"],
the output should be
solution(year, daysOfTheWeek, holidays) = 3.

November 4th of 2015 is a Wednesday, February 23th of 2016 and March 8th of 2016 are Tuesdays, and the other
holidays fall on Mondays. Classes are scheduled on Wednesdays and Tuesdays, so there will be only 3 missed classes.
 */
public class CS136_MissedClasses {
    public static void main(String[] args) {
        System.out.println(solution(2015, new int[]{2, 3}, new String[]{"11-04", "02-22", "02-23", "03-07", "03-08", "05-09"}));
    }

    static int solution(int year, int[] daysOfTheWeek, String[] holidays) {
        int[] educationMonths = new int[]{9, 10, 11, 12, 1, 2, 3, 4, 5};
        int indexOfWeek = getFirstDayOfWeekIndex(new int[]{9, year});
        int count = 0;

        for (int educationMonth : educationMonths) {
            if (educationMonth == 1) year++;
            int[] months = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int j = 1; j <= months[educationMonth - 1]; j++) {
                int finalJ = j;
                if (Arrays.stream(holidays).anyMatch(h -> h.equals(String.format("%02d-%02d", educationMonth, finalJ)))) {
                    int finalIndexOfWeek = indexOfWeek;
                    if (Arrays.stream(daysOfTheWeek).anyMatch(d -> d == (finalIndexOfWeek % 7) + 1)) {
                        count++;
                    }
                }
                indexOfWeek++;
            }
        }
        return count;
    }

    private static int getFirstDayOfWeekIndex(int[] date) { // ChatGPT
        // Ay ve yıl bilgisi alınır
        int month = date[0];
        int year = date[1];

        // Zaman düzlemini oluşturmak için bir algoritma kullanıyoruz
        // (Zeller's Congruence algoritması)
        if (month < 3) {
            month += 12;
            year--;
        }

        int day = 1; // Ayın ilk günü
        int k = year % 100;
        int j = year / 100;

        // Zeller's Congruence algoritması
        int h = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        // Zeller's Congruence algoritmasının döndürdüğü değere göre gün indeksini ayarlıyoruz
        // (0: Pazartesi, 1: Salı, ..., 5: Cumartesi, 6: Pazar)
        return (h + 5) % 7;
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
