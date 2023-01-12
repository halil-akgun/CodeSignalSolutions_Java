import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to
rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!

Example
For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
 */
public class CS06_SortByHeight {
    public static void main(String[] args) {
        int a[] = {-1, 150, 190, 170, -1, -1, 160, 180};
        System.out.println(Arrays.toString(solution(a)));

    }

    static int[] solution(int[] a) {
        int arr[] = new int[a.length];
        List<Integer> brr = new ArrayList<>();
        for (int w : a) {
            if (w != -1) brr.add(w);
        }
        brr.sort(Comparator.naturalOrder());
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                arr[i] = -1;
            } else {
                arr[i] = brr.get(idx);
                idx++;
            }
        }
        return arr;
    }
}