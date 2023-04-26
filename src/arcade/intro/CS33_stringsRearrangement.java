package arcade.intro;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements in such
a way that each consecutive pair of strings differ by exactly one character. Return true if it's possible, and false if not.

Note: You're only rearranging the order of the strings, not the order of the letters within the strings!

Example
For inputArray = ["aba", "bbb", "bab"], the output should be
solution(inputArray) = false.

There are 6 possible arrangements for these strings:
["aba", "bbb", "bab"]
["aba", "bab", "bbb"]
["bbb", "aba", "bab"]
["bbb", "bab", "aba"]
["bab", "bbb", "aba"]
["bab", "aba", "bbb"]
None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is false.

For inputArray = ["ab", "bb", "aa"], the output should be
solution(inputArray) = true.

It's possible to arrange these strings in a way that each consecutive pair of strings differ by 1 character
(eg: "aa", "ab", "bb" or "bb", "ab", "aa"), so return true.
 */
public class CS33_stringsRearrangement {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abc", "abx", "axx", "abc"}));
    }

    static boolean solution(String[] inputArray) {
        if (inputArray.length < 3) return false;
        boolean isValid;
        ArrayList<int[]> permutations = combinations(inputArray.length);
        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        boolean[] tempResult = new boolean[inputArray.length - 1];
        for (int[] w : permutations) {
            isValid = true;
            for (int i = 1; i < w.length; i++) {
                for (int j = 0; j < inputArray[w[i]].length(); j++) {
                    temp1.add(String.valueOf(inputArray[w[i - 1]].charAt(j)));
                    temp2.add(String.valueOf(inputArray[w[i]].charAt(j)));
                }
                for (int j = 0; j < temp2.size(); j++) {
                    if (temp1.get(j).equals(temp2.get(j))) {
                        temp1.remove(temp2.get(j));
                        temp2.remove(temp2.get(j));
                        j--;
                    }
                }
                tempResult[i - 1] = temp1.size() == 1;
                temp1.clear();
                temp2.clear();
            }
            for (boolean b : tempResult) {
                if (!b) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return true;
        }
        return false;
    }

    public static ArrayList<int[]> combinations(int a) {
        int[] numbers = new int[a];
        for (int i = 0; i < a; i++) {
            numbers[i] = i;
        }
        ArrayList<int[]> permutations = new ArrayList<>(); // kombinasyonların listesi
        generatePermutations(numbers, 0, permutations); // kombinasyonları hesaplayan fonksiyonu çağır

        return permutations;
    }

    // sayıların farklı kombinasyonlarını hesaplayan fonksiyon
    private static void generatePermutations(int[] numbers, int index, ArrayList<int[]> permutations) {
        if (index == numbers.length) {
            permutations.add(numbers.clone());
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            swap(numbers, index, i);
            generatePermutations(numbers, index + 1, permutations);
            swap(numbers, index, i);
        }
    }

    // iki elemanın yerlerini değiştiren fonksiyon
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
