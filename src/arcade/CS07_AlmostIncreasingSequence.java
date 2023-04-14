package arcade;

import java.util.ArrayList;
import java.util.List;

/*
Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by
removing no more than one element from the array.

Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only
one element is also considered to be strictly increasing.

Example
For sequence = [1, 3, 2, 1], the output should be
solution(sequence) = false.
There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
solution(sequence) = true.
You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get
the strictly increasing sequence [1, 3].
 */
public class CS07_AlmostIncreasingSequence {
    public static void main(String[] args) {

        int arr[] = {10, 1, 2, 3, 4, 5};
        System.out.println("solution(arr) = " + solution(arr));

    }

    static boolean solution(int[] sequence) {
        List<Integer> temp = new ArrayList<>();
        for (int w : sequence) {
            temp.add(w);
        }
        int counter = 0;
        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = i + 1; j < i + 2; j++) {
                if ((i == 0) & (!(temp.get(i) < temp.get(j)))) {
                    counter++;
                    temp.remove(i);
                    if (j != temp.size()) j--;
                } else if ((counter == 0) & (!(temp.get(i) < temp.get(j)))) {
                    if (j + 1 == temp.size() - 1) {
                        if (temp.get(j) < temp.get(j + 1) & temp.get(j) > temp.get(j - 2)) {
                            counter++;
                            temp.remove(i);
                            if (j != temp.size()) j--;
                        } else {
                            counter++;
                            temp.remove(j);
                            if (j != temp.size()) j--;
                        }
                    } else {
                        counter++;
                        temp.remove(j);
                        if (j != temp.size()) j--;
                    }

                } else if (!(temp.get(i) < temp.get(j))) {
                    counter++;
                    temp.remove(j);
                    if (j != temp.size()) j--;
                }
            }
        }

        if (counter > 1) {
            return false;
        } else {
            return true;
        }
    }
}
