package arcade.thecore;

/*
You've intercepted an encrypted message, and you are really curious about
its contents. You were able to find out that the message initially contained
only lowercase English letters, and was encrypted with the following cipher:

- Let all letters from 'a' to 'z' correspond to the numbers from 0 to 25, respectively.
- The number corresponding to the ith letter of the encrypted message is then equal to the sum
of numbers corresponding to the first i letters of the initial unencrypted message modulo 26.

Now that you know how the message was encrypted, implement the algorithm to decipher it.

Example
For message = "taiaiaertkixquxjnfxxdh", the output should be
solution(message) = "thisisencryptedmessage".
The initial message "thisisencryptedmessage" was encrypted as follows:
- letter 0: t -> 19 -> t;
- letter 1: th -> (19 + 7) % 26 -> 0 -> a;
- letter 2: thi -> (19 + 7 + 8) % 26 -> 8 -> i;
- etc.
 */
public class CS083_Cipher26 {
    public static void main(String[] args) {
        System.out.println(solution("taiaiaertkixquxjnfxxdh"));
    }

    static String solution(String message) {
        int cumulativeShift = message.charAt(0) - 'a';
        StringBuilder result = new StringBuilder(message.substring(0, 1));
        for (int i = 1; i < message.length(); i++) {
            int temp = 26 + (message.charAt(i) - 'a' - cumulativeShift) % 26;
            result.append((char) ('a' + temp % 26));
            cumulativeShift += temp;
        }
        return result.toString();
    }
}
