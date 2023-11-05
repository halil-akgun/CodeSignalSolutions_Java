package arcade.thecore;

/*
Determine whether the given string can be obtained by one concatenation of some string to itself.

Example
For inputString = "tandemtandem", the output should be
solution(inputString) = true;
For inputString = "qqq", the output should be
solution(inputString) = false;
For inputString = "2w2ww", the output should be
solution(inputString) = false.
 */
public class CS053_IsTandemRepeat {
    public static void main(String[] args) {
        System.out.println(solution("tandemtandem"));
    }

    static boolean solution(String inputString) {
        return inputString.substring(0, inputString.length() / 2).equals(inputString.substring(inputString.length() / 2));
    }
}
