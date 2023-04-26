package arcade.intro;

/*
Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.
Check if the given string is a correct variable name.

Example
For name = "var_1__Int", the output should be
solution(name) = true;
For name = "qq-q", the output should be
solution(name) = false;
For name = "2w2", the output should be
solution(name) = false.
 */
public class CS27_variableName {
    public static void main(String[] args) {
        System.out.println(solution("AS321df_dd"));
    }

    static boolean solution(String name) {
        boolean rule1 = name.replaceAll("[A-Za-z0-9_]", "").length() == 0;
        boolean rule2 = name.replaceAll("[0-9]", "").charAt(0) == name.charAt(0);
        return rule1 && rule2;
    }
}
