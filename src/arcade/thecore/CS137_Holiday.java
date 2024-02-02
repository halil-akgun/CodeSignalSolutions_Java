package arcade.thecore;

import java.util.List;

/*
John Doe likes holidays very much, and he was very happy to hear that his country's government decided to introduce
yet another one. He heard that the new holiday will be celebrated each year on the xth week of month, on weekDay.

Your task is to return the day of month on which the holiday will be celebrated in the year yearNumber.

For your convenience, here are the lists of months names and lengths and the list of days of the week names.

Months: "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December".
Months lengths: 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31.
Days of the week: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday".
Please, note that in leap years February has 29 days.

Example

For x = 3, weekDay = "Wednesday", month = "November", and yearNumber = 2016, the output should be
solution(x, weekDay, month, yearNumber) = 16.
The new holiday will be celebrated every November on the 3rd Wednesday of the month.
In 2016 the 3rd Wednesday falls on the 16th of November.

For x = 5, weekDay = "Thursday", month = "November", and yearNumber = 2016, the output should be
solution(x, weekDay, month, yearNumber) = -1.
There are only 4 Thursdays in November 2016.
 */
public class CS137_Holiday {
    public static void main(String[] args) {
        System.out.println(solution(3, "Wednesday", "November", 2016));
    }

    static int solution(int x, String weekDay, String month, int yearNumber) {
        List<String> months = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        List<String> daysOfWeek = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        int[] monthLengths = {31, isLeapYear(yearNumber) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int initialWeekdayOfMonth = getInitialWeekdayOfMonth(new int[]{months.indexOf(month) + 1, yearNumber});
        int weekDayIndex = daysOfWeek.indexOf(weekDay);
        for (int i = 1; i <= monthLengths[months.indexOf(month)]; i++) {
            if (initialWeekdayOfMonth++ % 7 == weekDayIndex && --x == 0) return i;
        }
        return -1;
    }

    private static int getInitialWeekdayOfMonth(int[] date) { // ChatGPT
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
