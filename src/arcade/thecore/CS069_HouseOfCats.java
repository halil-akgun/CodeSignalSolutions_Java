package arcade.thecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There are some people and cats in a house. You are given the number of legs they have all together.
Your task is to return an array containing every possible number of people that could be in the house
sorted in ascending order. It's guaranteed that each person has 2 legs and each cat has 4 legs.

Example
For legs = 6, the output should be
solution(legs) = [1, 3].
There could be either 1 cat and 1 person (4 + 2 = 6) or 3 people (2 * 3 = 6).

For legs = 2, the output should be
solution(legs) = [1].
There can be only 1 person.
 */
public class CS069_HouseOfCats {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6)));
    }

    static int[] solution(int legs) {
        List<Integer> numberOfPeople = new ArrayList<>();
        for (int i = 0; i <= legs / 4; i++) {
            numberOfPeople.add((legs - i * 4) / 2);
        }
        return numberOfPeople.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
