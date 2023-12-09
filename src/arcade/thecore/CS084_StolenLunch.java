package arcade.thecore;

import java.util.stream.Collectors;

/*
When you recently visited your little nephew, he told you a sad story: there's a
bully at school who steals his lunch every day, and locks it away in his locker.
He also leaves a note with a strange, coded message. Your nephew gave you one of
the notes in hope that you can decipher it for him. And you did: it looks like
all the digits in it are replaced with letters and vice versa. Digit 0 is replaced
with 'a', 1 is replaced with 'b' and so on, with digit 9 replaced by 'j'.

The note is different every day, so you decide to write a function that
will decipher it for your nephew on an ongoing basis.

Example
For note = "you'll n4v4r 6u4ss 8t: cdja", the output should be
solution(note) = "you'll never guess it: 2390".
 */
public class CS084_StolenLunch {
    public static void main(String[] args) {
        System.out.println(solution("you'll n4v4r 6u4ss 8t: cdja"));
    }

    static String solution(String note) {
        return note.chars().mapToObj(t -> (char) t)
                .map(t -> t >= 'a' && t <= 'j' ? (char) ('0' + (t - 'a'))
                        : t >= '0' && t <= '9' ? (char) ('a' + (t - '0')) : t)
                .map(Object::toString).collect(Collectors.joining());
    }

    // For a different scenario:
//    static String solution(String note) {
//        String[] arr = note.split(": ");
//        StringBuilder result = new StringBuilder();
//        for (String s : arr) {
//            if (!isNumber(s)) {
//                result.append(s.chars().mapToObj(t -> (char) t).map(t -> Character.isDigit(t) ? (char) ('a' + (t - '0')) : t).map(Object::toString).collect(Collectors.joining()));
//            } else {
//                result.append(s.chars().mapToObj(t -> (char) t).map(t -> t - 'a').map(Object::toString).collect(Collectors.joining()));
//            }
//            result.append(": ");
//        }
//        return result.substring(0, result.length() - 2);
//    }
//
//    static boolean isNumber(String s) {
//        return s.replaceAll("[^A-Za-z]", "").length() == s.length() && s.replaceAll("[a-j]", "").length() == 0;
//    }
}
