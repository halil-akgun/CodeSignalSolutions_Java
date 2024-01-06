package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a vertical box divided into equal columns. Someone dropped several stones from
its top through the columns. Stones are falling straight down at a constant speed (equal for all stones)
while possible (i.e. while they haven't reached the ground or they are not blocked by another motionless stone).
Given the state of the box at some moment in time, find out which columns become motionless first.

Example
For
rows = ["#..##",
        ".##.#",
        ".#.##",
        "....."]
the output should be solution(rows) = [1, 4].

Check out the image below for better understanding:
https://codesignal.s3.amazonaws.com/uploads/1667239865430/example.png?raw=true
 */
public class CS111_Gravitation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "#..#.",
                ".##..",
                ".#...",
                ".#..."
        })));
    }

    static int[] solution(String[] rows) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] column;
        for (int i = 0; i < rows[0].length(); i++) {
            column = new int[rows.length];
            for (int j = 0; j < rows.length; j++) {
                column[j] = rows[j].charAt(i) == '.' ? 0 : 1;
            }
            int c = calculateSteps(column);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        return map.get(map.keySet().stream().min(Integer::compareTo).get()).stream().mapToInt(Integer::intValue).toArray();
    }

    private static Integer calculateSteps(int[] column) {
        int count = 0;
        int control = Arrays.stream(column).boxed().toList().indexOf(1);
        if (control == -1) return 0;
        for (int i = column.length - 1; i > control; i--) {
            if (column[i] == 0) {
                count++;
                for (int j = i; j > 0; j--) {
                    column[j] = column[j - 1];
                }
                column[0] = 0;
                i++;
                control++;
            }
        }
        return count;
    }
}
