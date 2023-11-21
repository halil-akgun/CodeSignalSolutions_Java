package arcade.thecore;

import java.util.HashSet;
import java.util.Set;

/*
Let's call two integers A and B friends if each integer from the array divisors is either
a divisor of both A and B or neither A nor B. If two integers are friends, they are said to
be in the same clan. How many clans are the integers from 1 to k, inclusive, broken into?

Example
For divisors = [2, 3] and k = 6, the output should be
solution(divisors, k) = 4.

The numbers 1 and 5 are friends and form a clan, 2 and 4 are friends and form a clan, and 3 and 6
do not have friends and each is a clan by itself. So the numbers 1 through 6 are broken into 4 clans.
 */
public class CS066_NumberOfClans {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3}, 6));
    }

    static int solution(int[] divisors, int k) {
        Set<String> clans = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            clans.add(detectClan(divisors, i));
        }
        return clans.size();
    }

    static String detectClan(int[] divisors, int a) {
        StringBuilder clan = new StringBuilder();
        for (int divisor : divisors) {
            if (a % divisor == 0) {
                clan.append(divisor).append(",");
            }
        }
        return clan.length() > 0 ? clan.substring(0, clan.length() - 1) : "0";
    }
}
