package arcade.thecore;

/*
We want to turn the given integer into a number that has only one non-zero digit using a tail rounding approach.
This means that at each step we take the last non 0 digit of the number and round it to 0 or to 10.
If it's less than 5 we round it to 0 if it's larger than or equal to 5 we round it to 10 (rounding to 10 means
increasing the next significant digit by 1). The process stops immediately once there is only one non-zero digit left.

Example
For n = 15, the output should be
solution(n) = 20;

For n = 1234, the output should be
solution(n) = 1000.
1234 -> 1230 -> 1200 -> 1000.

For n = 1445, the output should be
solution(n) = 2000.
1445 -> 1450 -> 1500 -> 2000.
 */
public class CS32_Rounders {
    public static void main(String[] args) {
        System.out.println(solution(1445));
    }

    static int solution(int n) {
        String temp = String.valueOf(n);
        int step = 1;
        for (int i = temp.length() - 1; i > 0; i--) {
            temp = String.valueOf(n);
            if (temp.charAt(i) < '5') n -= (temp.charAt(i) - '0') * step;
            else n += (10 - (temp.charAt(i) - '0')) * step;
            step *= 10;
        }
        return n;
    }
}
