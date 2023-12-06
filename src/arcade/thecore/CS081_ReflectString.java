package arcade.thecore;

import java.util.stream.Collectors;

/*
Define an alphabet reflection as follows: a turns into z, b turns into y,
c turns into x, ..., n turns into m, m turns into n, ..., z turns into a.
Define a string reflection as the result of applying the alphabet reflection to each of its characters.
Reflect the given string.

Example
For inputString = "name", the output should be
solution(inputString) = "mznv".
 */
public class CS081_ReflectString {
    public static void main(String[] args) {
        System.out.println(solution("name"));
    }

    static String solution(String inputString) {
        return inputString.chars()
                .map(c -> c >= 'a' && c <= 'z'
                        ? (c - 'a' < 'z' - c ? 'z' - (c - 'a') : 'a' + ('z' - c))
                        : (c - 'A' < 'Z' - c ? 'Z' - (c - 'A') : 'A' + ('Z' - c)))
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }
}
