package arcade.thecore;

import java.util.Arrays;

/*
In an effort to be more innovative, your boss introduced a strange new tradition:
the first day of every month you're allowed to work from home. You like this rule when
the day falls on a Monday, because any excuse to skip rush hour traffic is great!

You and your colleagues have started calling these months regular months. Since you're a fan of working from home,
you decide to find out how far away the nearest regular month is, given that the currMonth has just started.

For your convenience, here is a list of month lengths (from January to December, respectively):

Month lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
Please, note that in leap years February has 29 days.

Example
For currMonth = "02-2016", the output should be
solution(currMonth) = "08-2016".

February of 2016 year is regular, but it doesn't count since it has started already,
so the next regular month is August of 2016 - which is the answer.
 */
public class CS135_RegularMonths {
    public static void main(String[] args) {
        System.out.println(solution("02-2016"));
    }

    static String solution(String currMonth) {
        int[] date = Arrays.stream(currMonth.split("-")).mapToInt(Integer::parseInt).toArray();
        int indexOfWeek = getFirstDayOfWeekIndex(date);
        System.out.println(indexOfWeek);

        do {
            int[] months = {31, isLeapYear(date[1]) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            indexOfWeek = indexOfWeek + months[date[0] - 1] % 7;
            date[0]++;
            if (date[0] > 12) {
                date[0] = 1;
                date[1]++;
            }
        } while (indexOfWeek % 7 != 0);

        return String.format("%02d-%d", date[0], date[1]);
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
