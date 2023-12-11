package arcade.thecore;

/*
Consider the following ciphering algorithm:

For each character replace it with its code.
Concatenate all of the obtained numbers.
Given a ciphered string, return the initial one if it is known that it consists only of lowercase letters.

Note: here the character's code means its decimal ASCII code, the numerical
representation of a character used by most modern programming languages.

Example
For cipher = "10197115121", the output should be
solution(cipher) = "easy".
Explanation: charCode('e') = 101, charCode('a') = 97, charCode('s') = 115 and charCode('y') = 121.
 */
public class CS086_Decipher {
    public static void main(String[] args) {
        System.out.println(solution("10197115121"));
    }

    static String solution(String cipher) {
        int ascii = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            ascii = ascii * 10 + (cipher.charAt(i) - '0');
            if (ascii >= 'a' && ascii <= 'z') {
                result.append((char) ascii);
                ascii = 0;
            }
        }
        return result.toString();
    }
}
