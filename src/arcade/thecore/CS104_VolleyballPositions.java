package arcade.thecore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are watching a volleyball tournament, but you missed the beginning of the very first game of your favorite team.
Now you're curious about how the coach arranged the players on the field at the start of the game.

The team you favor plays in the following formation:
0 3 0
4 0 2
0 6 0
5 0 1
where positive numbers represent positions occupied by players. After the team gains the serve,
its members rotate one position in a clockwise direction, so the player in position 2 moves to position 1,
the player in position 3 moves to position 2, and so on, with the player in position 1 moving to position 6.

Here's how the players change their positions:
    4   3   2
    5   6   1

Given the current formation of the team and the number of times k it gained the serve, find the initial position of each player in it.

Example
For

formation = [["empty",   "Player5", "empty"],
             ["Player4", "empty",   "Player2"],
             ["empty",   "Player3", "empty"],
             ["Player6", "empty",   "Player1"]]
and k = 2, the output should be
solution(formation, k) = [
    ["empty",   "Player1", "empty"],
    ["Player2", "empty",   "Player3"],
    ["empty",   "Player4", "empty"],
    ["Player5", "empty",   "Player6"]
]

For
formation = [["empty", "Alice", "empty"],
             ["Bob",   "empty", "Charlie"],
             ["empty", "Dave",  "empty"],
             ["Eve",   "empty", "Frank"]]
and k = 6, the output should be
solution(formation, k) = [
    ["empty", "Alice", "empty"],
    ["Bob",   "empty", "Charlie"],
    ["empty", "Dave",  "empty"],
    ["Eve",   "empty", "Frank"]
]
 */
public class CS104_VolleyballPositions {
    public static void main(String[] args) {
        Arrays.stream(solution(new String[][]{
                {"empty", "Player5", "empty"},
                {"Player4", "empty", "Player2"},
                {"empty", "Player3", "empty"},
                {"Player6", "empty", "Player1"}
        }, 2)).map(Arrays::toString).forEach(System.out::println);
    }

    static String[][] solution(String[][] formation, int k) {
        int[][] positions = {
                {0, 3, 0},
                {4, 0, 2},
                {0, 6, 0},
                {5, 0, 1}
        };

        Map<Integer, String> currentPositions = getCurrentPositions(formation, positions);
        Map<Integer, String> newPositions = calculateNewPositions(currentPositions, k);

        updateFormation(formation, positions, newPositions);

        return formation;
    }

    static Map<Integer, String> getCurrentPositions(String[][] formation, int[][] positions) {
        Map<Integer, String> currentPositions = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j] != 0) {
                    currentPositions.put(positions[i][j], formation[i][j]);
                }
            }
        }
        return currentPositions;
    }

    static Map<Integer, String> calculateNewPositions(Map<Integer, String> currentPositions, int k) {
        Map<Integer, String> newPositions = new HashMap<>();
        for (Map.Entry<Integer, String> entry : currentPositions.entrySet()) {
            int oldPosition = entry.getKey();
            int newPosition = ((oldPosition + k % 6) - 1) % 6 + 1;
            newPositions.put(newPosition, entry.getValue());
        }
        return newPositions;
    }

    static void updateFormation(String[][] formation, int[][] positions, Map<Integer, String> newPositions) {
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j] != 0) {
                    formation[i][j] = newPositions.get(positions[i][j]);
                }
            }
        }
    }
}
