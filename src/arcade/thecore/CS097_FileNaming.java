package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
You are given an array of strings names representing filenames. The array is
sorted in order of file creation, such that names[i] represents the name of
a file created before names[i+1] and after names[i-1] (assume 0-based indexing).
Because all files must have unique names, files created later with the same name
as a file created earlier should have an additional (k) suffix in their names,
where k is the smallest positive integer (starting from 1) that does not appear in previous file names.

Your task is to iterate through all elements of names (from left to right) and
update all filenames based on the above. Return an array of proper filenames.

Example
For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be
solution(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].
Since names[0] = "doc" and names[1] = "doc", update names[1] = "doc(1)"
Since names[1] = "doc(1)" and names[3] = "doc(1)", update names[3] = "doc(1)(1)"
Since names[0] = "doc", names[1] = "doc(1)", and names[4] = "doc", update names[4] = "doc(2)"
 */
public class CS097_FileNaming {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"doc", "doc", "image", "doc(1)", "doc"})));
    }

    private static String name;
    private static int count;

    static String[] solution(String[] names) {
        HashMap<String, List<Integer>> values = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            if (hasSuffix(names[i])) {
                if (!set.contains(names[i])) {
                    if (values.containsKey(name)) {
                        values.get(name).add(count);
                    } else {
                        values.put(name, new ArrayList<>(List.of(count)));
                    }
                } else {
                    if (values.containsKey(names[i])) {
                        count = getValue(values.get(names[i]));
                        values.get(names[i]).add(count);
                        names[i] = names[i] + "(" + count + ")";
                    } else {
                        values.put(names[i], new ArrayList<>(List.of(1)));
                        names[i] = names[i] + "(1)";
                    }
                }
            } else {
                if (!set.contains(names[i])) {
                    if (!values.containsKey(names[i])) {
                        values.put(names[i], new ArrayList<>(List.of(0)));
                    }
                } else {
                    count = getValue(values.get(names[i]));
                    values.get(names[i]).add(count);
                    names[i] = names[i] + "(" + count + ")";
                }
            }
            set.add(names[i]);
        }
        return names;
    }

    private static int getValue(List<Integer> list) {
        Collections.sort(list);
        int smallestPositive = 1;
        for (int i : list) {
            if (i == smallestPositive) {
                smallestPositive++;
            } else if (i > smallestPositive) {
                break;
            }
        }
        return smallestPositive;
    }

    private static boolean hasSuffix(String str) {
        try {
            if (str.charAt(str.length() - 1) == ')') {
                count = Integer.parseInt(str.substring(str.lastIndexOf("(") + 1, str.length() - 1));
                name = str.substring(0, str.lastIndexOf("("));
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
