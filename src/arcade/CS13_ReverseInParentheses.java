package arcade;

/*
Write a function that reverses characters in (possibly nested) parentheses in the input string.
Input strings will always be well-formed with matching ()s.

Example

For inputString = "(bar)", the output should be
solution(inputString) = "rab";

For inputString = "foo(bar)baz", the output should be
solution(inputString) = "foorabbaz";

For inputString = "foo(bar)baz(blim)", the output should be
solution(inputString) = "foorabbazmilb";

For inputString = "foo(bar(baz))blim", the output should be
solution(inputString) = "foobazrabblim".
Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 */
public class CS13_ReverseInParentheses {
    public static void main(String[] args) {
        String str = "foo(bar(baz))blim";
        System.out.println("solution(str) = " + solution(str));
    }

    static String solution(String inputString) {
        StringBuilder stb = new StringBuilder(inputString);
        int firstParenthesesClose;
        int parenthesesOpen = 99999;
        int firstIndex;
        int lastIndex;
        String temp;
        while (stb.indexOf("(") != -1) {
            firstParenthesesClose = stb.indexOf(")");
            for (int i = firstParenthesesClose - 1; i >= 0; i--) {
                if (stb.substring(i, i + 1).equals("(")) {
                    parenthesesOpen = i;
                    break;
                }
            }
            firstIndex = parenthesesOpen + 1;
            lastIndex = firstParenthesesClose - 1;
            while (lastIndex - firstIndex > 0) {
                temp = stb.substring(firstIndex, firstIndex + 1);
                stb.setCharAt(firstIndex, stb.charAt(lastIndex));
                stb.setCharAt(lastIndex, temp.charAt(0));
                lastIndex--;
                firstIndex++;
            }
            System.out.println("parenthesesOpen = " + parenthesesOpen);
            stb.delete(firstParenthesesClose, firstParenthesesClose + 1);
            stb.delete(parenthesesOpen, parenthesesOpen + 1);
        }
        return stb.toString();
    }
}