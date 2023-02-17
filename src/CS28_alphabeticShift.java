/*
Given a string, your task is to replace each of its characters by the next one in the English alphabet;
i.e. replace a with b, replace b with c, etc (z would be replaced by a).

Example
For inputString = "crazy", the output should be solution(inputString) = "dsbaz".
 */
public class CS28_alphabeticShift {
    public static void main(String[] args) {
        System.out.println(solution("qwerZAz"));
    }

    static String solution(String inputString) {
        String result = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'Z') result += "A";
            else if (inputString.charAt(i) == 'z') result += "a";
            else result += (char) (inputString.charAt(i) + 1);
        }
        return result;
    }
}
