package arcade.thecore;

import java.util.Arrays;

/*
N candles are placed in a row, some of them are initially lit. For each candle from the 1st
to the Nth the following algorithm is applied: if the observed candle is lit then states of
this candle and all candles before it are changed to the opposite. Which candles will remain
lit after applying the algorithm to all candles in the order they are placed in the line?

Example
For a = [1, 1, 1, 1, 1], the output should be
solution(a) = [0, 1, 0, 1, 0].
Check out the image below for better understanding:

https://codesignal.s3.amazonaws.com/uploads/1664318500/example.png?raw=true

For a = [0, 0], the output should be
solution(a) = [0, 0].
The candles are not initially lit, so their states are not altered by the algorithm.
 */
public class CS073_SwitchLights {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1, 1})));
    }

    static int[] solution(int[] a) {
        if (Arrays.stream(a).allMatch(t -> t == 0)) return a;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==1) switchLights(a, i);
        }
        return a;
    }

    static void switchLights(int[] arr, int end) {
        for (int i = 0; i <= end; i++) {
            arr[i] = Math.abs(arr[i] - 1);
        }
    }
}
