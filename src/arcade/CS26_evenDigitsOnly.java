package arcade;

/*
Check if all digits of the given integer are even.

Example
For n = 248622, the output should be
solution(n) = true;
For n = 642386, the output should be
solution(n) = false.
 */
public class CS26_evenDigitsOnly {
    public static void main(String[] args) {
        System.out.println(solution(468));
    }

    static boolean solution(int n) {
        String[] digits = String.valueOf(n).split("");
        for (String w : digits) {
            if (Integer.parseInt(w) % 2 != 0) return false;
        }
        return true;
    }
}
