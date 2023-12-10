package arcade.thecore;

import java.util.Arrays;

/*
Given two version strings composed of several non-negative decimal fields separated
by periods ("."), both strings contain equal number of numeric fields. Return true
if the first version is higher than the second version and false otherwise.

The syntax follows the regular semver ordering rules:
1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
< 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
There are no leading zeros in any of the numeric fields, i.e. you do not have to
handle inputs like 100.020.003 (it would instead be given as 100.20.3).

Example
For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
solution(ver1, ver2) = true;
For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
solution(ver1, ver2) = false.
 */
public class CS085_HigherVersion {
    public static void main(String[] args) {
        System.out.println(solution("1.2.2", "1.2.0"));
    }

    static boolean solution(String ver1, String ver2) {
        Integer[] verArr1 = Arrays.stream(ver1.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] verArr2 = Arrays.stream(ver2.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 0; i < verArr1.length; i++) {
            if (verArr1[i] > verArr2[i]) return true;
            if (verArr1[i] < verArr2[i]) return false;
        }
        return false;
    }
}
