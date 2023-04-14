package arcade;

/*
Given a string, return its encoding defined as follows:

First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
for example, "aabbbc" is divided into ["aa", "bbb", "c"]
Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
for example, substring "bbb" is replaced by "3b"
Finally, all the new strings are concatenated together in the same order and a new string is returned.

Example
For s = "aabbbc", the output should be
solution(s) = "2a3bc".
 */
public class CS49_lineEncoding {
    public static void main(String[] args) {
        System.out.println(solution("aabbbc"));
    }

    static String solution(String s) {
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (temp.isEmpty()) {
                temp.append(s.charAt(i));
            } else if (temp.indexOf(s.substring(i, i + 1)) != -1) {
                temp.append(s.charAt(i));
            } else {
                if (temp.length() > 1) result.append(temp.length());
                result.append(temp.charAt(0));
                temp.delete(0, temp.length());
                temp.append(s.charAt(i));
            }
        }
        if (temp.length() > 1) result.append(temp.length());
        result.append(temp.charAt(0));
        return result.toString();
    }
}
