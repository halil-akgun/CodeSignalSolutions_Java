package arcade.intro;

/*
An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network
that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions
of addresses. One of them is the IPv4 address.
Given a string, find out if it satisfies the IPv4 address naming rules.

Example
For inputString = "172.16.254.1", the output should be
solution(inputString) = true;

For inputString = "172.316.254.1", the output should be
solution(inputString) = false.
316 is not in range [0, 255].

For inputString = ".254.255.0", the output should be
solution(inputString) = false.
There is no first number.
 */
public class CS21_isIPv4Address {
    public static void main(String[] args) {
        String ipNo = "622222222222222224.233.161.00";
        System.out.println("solution(ipNo) = " + solution(ipNo));
    }

    static boolean solution(String inputString) {
        if (inputString.replaceAll("[0-9.]", "").length() != 0) return false;
        String[] arr = inputString.split("[.]");
        boolean isFourElement = arr.length == 4;
        boolean isInvalidLength = true;
        boolean isInRange = true;
        boolean notBeginWithZero = true;
        for (String w : arr) {
            if (w.length() == 0 || w.length() > 3) {
                isInvalidLength = false;
                break;
            }
            if (w.length() > 1 && w.charAt(0) == '0') notBeginWithZero = false;
            if (Integer.parseInt(w) < 0 || Integer.parseInt(w) > 255) isInRange = false;
        }
        return isInvalidLength && isInRange && isFourElement && notBeginWithZero;
    }

}
