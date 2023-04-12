/*
A media access control address (MAC address) is a unique identifier assigned to network interfaces
for communications on the physical network segment.

The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of
two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).

Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

Example
For inputString = "00-1B-63-84-45-E6", the output should be
solution(inputString) = true;
For inputString = "Z1-1B-63-84-45-E6", the output should be
solution(inputString) = false;
For inputString = "not a MAC-48 address", the output should be
solution(inputString) = false.
 */
public class CS47_IsMAC48Address {
    public static void main(String[] args) {
        String mac = "02-03-04-05-556-07";
        System.out.println(solution(mac));
    }

    static boolean solution(String inputString) {
        // 1st way
//        String[] arr = inputString.split("-");
//        System.out.println(Arrays.toString(arr));
//        System.out.println("**");
//        if (arr.length != 6) return false;
//        Matcher matcher = Pattern.compile("^[0-9A-F]").matcher(inputString);
//        Matcher matcher2 = Pattern.compile("[0-9A-F]$").matcher(inputString);
//        System.out.println("***");
//        if (!matcher.find() || !matcher2.find()) return false;
//        System.out.println("****");
//        for (String w : arr) {
//            matcher = Pattern.compile("[^0-9A-F]").matcher(w);
//            if (matcher.find() || w.length() > 2) return false;
//        }
//        return true;

        // 2nd way
        String pattern = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        return inputString.matches(pattern);
    }
}
