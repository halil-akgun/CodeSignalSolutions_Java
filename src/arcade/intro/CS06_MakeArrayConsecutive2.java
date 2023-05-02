package arcade.intro;

import java.util.Arrays;
import java.util.List;

/*
Ratiorg got statues of different sizes as a present from CodeMaster for his birthday, each statue having
a non-negative integer size. Since he likes to make things perfect, he wants to arrange them from smallest to
largest so that each statue will be bigger than the previous one exactly by 1. He may need some additional statues
to be able to accomplish that. Help him figure out the minimum number of additional statues needed.

Example
For statues = [6, 2, 3, 8], the output should be
solution(statues) = 3.

Ratiorg needs statues of sizes 4, 5 and 7.
 */
public class CS06_MakeArrayConsecutive2 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 8};
        System.out.println(solution(arr));
    }

    static int solution(int[] statues) {
        List<Integer> statues2 = Arrays.stream(statues).sorted().boxed().toList();
        int min = statues2.get(0);
        int max = statues2.get(statues2.size() - 1);
        int result = 0;

        for (int i = min + 1; i < max; i++) {
            if (!(statues2.contains(i))) result++;
        }
        return result;
    }
}
