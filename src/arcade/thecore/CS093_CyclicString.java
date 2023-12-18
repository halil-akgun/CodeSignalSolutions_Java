package arcade.thecore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
You're given a substring s of some cyclic string. What's the length of the smallest
possible string that can be concatenated to itself many times to obtain this cyclic string?

Example
For s = "cabca", the output should be
solution(s) = 3.
"cabca" is a substring of a cycle string "abcabcabcabc..." that can be obtained
by concatenating "abc" to itself. Thus, the answer is 3.
 */
public class CS093_CyclicString {
    public static void main(String[] args) {
        System.out.println(solution("bcaba"));
    }

    static int solution(String s) {
        for (int i = 1; i <= s.length(); i++) {
            if (helperMethod(s, i)) return i;
        }
        return 0;
    }

    private static boolean helperMethod(String str, int size) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() >= size) {
            set.add(sb.substring(0, size));
            sb.delete(0, size);
        }
        if (sb.length() > 0) set.add(sb.toString());
        List<String> list = set.stream().toList();
        return set.size() == 1 || (set.size() == 2 && (list.get(0).indexOf(list.get(1)) == 0 || list.get(1).indexOf(list.get(0)) == 0));
    }
}
