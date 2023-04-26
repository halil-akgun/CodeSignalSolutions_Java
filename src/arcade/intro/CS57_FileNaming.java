package arcade.intro;

import java.util.*;

/*
You are given an array of strings names representing filenames. The array is sorted in order of file creation,
such that names[i] represents the name of a file created before names[i+1] and after names[i-1] (assume 0-based
indexing). Because all files must have unique names, files created later with the same name as a file created
earlier should have an additional (k) suffix in their names, where k is the smallest positive integer
(starting from 1) that does not appear in previous file names.

Your task is to iterate through all elements of names (from left to right) and update all filenames
based on the above. Return an array of proper filenames.

Example
For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be:
solution(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].
 */
public class CS57_FileNaming {
    public static void main(String[] args) {
        String[] arr = {"doc", "doc", "image", "doc(1)", "doc"};
        System.out.println(Arrays.toString(solution(arr)));
    }

    static String[] solution(String[] names) {

        HashSet<String> occurrence = new HashSet<>();
        String[] updatedNames = new String[names.length];
        int a = 1;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!occurrence.contains(name)) {
                updatedNames[i] = name;
                occurrence.add(name);
            } else {
                String updatedName = names[i] + "(" + a + ")";
                while (occurrence.contains(updatedName)) {
                    updatedName = names[i] + "(" + (a++) + ")";
                }
                updatedNames[i] = updatedName;
                occurrence.add(updatedName);
            }
            a = 1;
        }
        return updatedNames;

    }
}
