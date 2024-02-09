package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
As an avid user of CodeSignal, you find it frustrating that there are no debugging and recovery tasks
in your favorite language, PHP. You decide to help the platform by translating solutions in JavaScript into PHP.

You quickly discover that this approach is quite convenient: sometimes all you have to
do is substitute the function arguments by adding the $ sign in front of them.
At first you do this manually, but soon realize that it won't get you far enough.

Now you need to implement a function that, given a code written in JavaScript and its args,
adds a $ sign in front of each args[i] (unless there is already a dollar sign present).

Given a code in JavaScript and its args, return the almost-PHP solution.

Example
For
code =
    "function add($n, m) {\t
       return n + $m;\t
     }"
and args = ["n", "m"], the output should be
solution(code, args) =
    "function add($n, $m) {\t
       return $n + $m;\t
     }"
 */
public class CS144_ProgramTranslation {
    public static void main(String[] args) {
        System.out.println(solution(
                """
                        function add($n, m) {\t
                           return n + $m;\t
                         }
                        """,
                new String[]{"n", "m"}));
    }

    static String solution(String code, String[] args) { // Solution by bandorthild (codesignal)
        String argumentVariants = String.join("|", args);
        String pattern = "(?<![$\\w])(" + argumentVariants + ")(?!\\w)";
        String sub = "\\$$1";
        return code.replaceAll(pattern, sub);
    }
}
