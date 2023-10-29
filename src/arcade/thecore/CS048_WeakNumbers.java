package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
We define the weakness of number x as the number of positive integers smaller than x that have more divisors than x.

It follows that the weaker the number, the greater overall weakness it has.
For the given integer n, you need to answer two questions:
    - what is the weakness of the weakest numbers in the range [1, n]?
    - how many numbers in the range [1, n] have this weakness?
Return the answer as an array of two elements, where the first element is the answer to
the first question, and the second element is the answer to the second question.

Example
For n = 9, the output should be
solution(n) = [2, 2].

Here are the number of divisors and the specific weakness of each number in range [1, 9]:
1: d(1) = 1, weakness(1) = 0;
2: d(2) = 2, weakness(2) = 0;
3: d(3) = 2, weakness(3) = 0;
4: d(4) = 3, weakness(4) = 0;
5: d(5) = 2, weakness(5) = 1;
6: d(6) = 4, weakness(6) = 0;
7: d(7) = 2, weakness(7) = 2;
8: d(8) = 4, weakness(8) = 0;
9: d(9) = 3, weakness(9) = 2.
As you can see, the maximal weakness is 2, and there are 2 numbers with that weakness level.
 */
public class CS048_WeakNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(9)));
    }

    static int[] solution(int n) {
        int[] allDivisors = new int[n];
        List<Integer> weaknessList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int divisors = divisors(i);
            allDivisors[0] = divisors;
            Arrays.sort(allDivisors);
            weaknessList.add(allDivisors.length - 1 - findLastIndex(allDivisors, divisors));
        }
        int maxWeakness = weaknessList.stream().max(Integer::compareTo).get();
        int countMaxWeakness = (int) weaknessList.stream().filter(t -> t == maxWeakness).count();
        return new int[]{maxWeakness, countMaxWeakness};
    }


    static int divisors(int a) {
        int count = 0;
        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) count++;
        }
        return count + 1;
    }

    static int findLastIndex(int[] array, int target) {
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) lastIndex = i;
        }
        return lastIndex;
    }

    static int[] solution2(int n) { // chatGPT
        int[] divisors = new int[n + 1];
        int[] weaknesses = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                divisors[j]++;
            }
        }

        int maxWeakness = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (divisors[j] > divisors[i]) {
                    weaknesses[i]++;
                }
            }
            maxWeakness = Math.max(maxWeakness, weaknesses[i]);
        }

        int countMaxWeakness = 0;
        for (int i = 1; i <= n; i++) {
            if (weaknesses[i] == maxWeakness) {
                countMaxWeakness++;
            }
        }

        return new int[]{maxWeakness, countMaxWeakness};
    }
}
