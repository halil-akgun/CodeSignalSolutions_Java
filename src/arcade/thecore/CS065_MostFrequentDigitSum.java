package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A step(x) operation works like this: it changes a number x into x - s(x),
where s(x) is the sum of x's digits. You like applying functions to numbers,
so given the number n, you decide to build a decreasing sequence of numbers:
n, step(n), step(step(n)), etc., with 0 as the last element.

Building a single sequence isn't enough for you, so you replace all elements of the
sequence with the sums of their digits (s(x)). Now you're curious as to which number
appears in the new sequence most often. If there are several answers, return the maximal one.

Example
For n = 88, the output should be
solution(n) = 9.
Here is the first sequence you built: 88, 72, 63, 54, 45, 36, 27, 18, 9, 0;
And here is s(x) for each of its elements: 16, 9, 9, 9, 9, 9, 9, 9, 9, 0.
As you can see, the most frequent number in the second sequence is 9.

For n = 8, the output should be
solution(n) = 8.
At first you built the following sequence: 8, 0
s(x) for each of its elements is: 8, 0
As you can see, the answer is 8 (it appears as often as 0, but is greater than it).
 */
public class CS065_MostFrequentDigitSum {
    public static void main(String[] args) {
        System.out.println(solution(17));
    }

    static int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int temp;
        while (n > 0) {
            temp = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
            list.add(temp);
            n -= temp;
        }

        Map<Integer, Integer> occurs = new HashMap<>();
        for (Integer w : list) {
            occurs.put(w, occurs.getOrDefault(w, 1) + 1);
        }

        return occurs.entrySet().stream()
                .max(Map.Entry.<Integer, Integer>comparingByValue()
                        .thenComparing(Map.Entry::getKey)).map(Map.Entry::getKey)
                .orElse(0);
    }
}
