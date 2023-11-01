package arcade.thecore;

import java.util.ArrayList;
import java.util.List;

/*
You're a crossword fanatic, and have finally decided to try and create your own. However,
you also love symmetry and good design, so you come up with a set of rules they should follow:

- the crossword must contain exactly four words;
- these four words should form four pairwise intersections;
- all words must be written either left-to-right or top-to-bottom;
- the area of the rectangle formed by empty cells inside the intersections isn't equal to zero.

Given 4 words, find the number of ways to make a crossword following the above-described rules.
Note that two crosswords which differ by rotation are considered different.

Example
For words = ["crossword", "square", "formation", "something"], the output should be
solution(words) = 6.

The six crosswords can be formed as shown below:

  f                         f                             f
  o                     c r o s s w o r d     c r o s s w o r d
c r o s s w o r d           r   o                   q     r
  m   q                     m   m                   u     m
  a   u            ;  s q u a r e          ;        a     a
  t   a                     t   t                   r     t
  i   r                     i   h             s o m e t h i n g
s o m e t h i n g           o   i                         o
  n                         n   n                         n
                                g

    c         s               s
f o r m a t i o n       c     q               c         s
    o         m         r     u               r         o
    s q u a r e       f o r m a t i o n       o         m
    s         t    ;    s     r            ;  s q u a r e
    w         h         s o m e t h i n g     s         t
    o         i         w                     w         h
    r         n         o                   f o r m a t i o n
    d         g         r                     r         n
                        d                     d         g
 */
public class CS050_CrosswordFormation {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"crossword", "square", "formation", "something"}));
    }

    static int solution(String[] words) { // https://www.youtube.com/watch?v=0wV-1KETz_E
        int result = 0;
        for (int a = 0; a < words.length; a++) {
            String wordA = words[a];
            for (int b = 0; b < words.length; b++) {
                if (b == a) continue;
                String wordB = words[b];
                List<int[]> matches1 = findAllOccurs(wordA, wordB);
                for (int[] w1 : matches1) {
                    int indexA = w1[0];
                    int indexB = w1[1];
                    for (int c = 0; c < words.length; c++) {
                        if (c == a || c == b) continue;
                        String wordC = words[c];
                        List<int[]> matches2 = findAllOccurs(wordB, wordC);
                        for (int[] w2 : matches2) {
                            int indexB2 = w2[0];
                            int indexC = w2[1];
                            int space_index = indexB2 - indexB;
                            if (space_index < 2) continue;
                            for (int d = 0; d < words.length; d++) {
                                if (d == a || d == b || d == c) continue;
                                String wordD = words[d];
                                result += countOccurIn3Words(wordA, wordC, indexA, indexC, wordD, space_index);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    static int countOccurIn3Words(String word1, String word2, int word1_index, int word2_index, String word3, int space_index) {
        int result = 0;
        int boundary = Math.min(word1.length() - (word1_index + 2), word2.length() - (word2_index + 2));

        for (int i = 0; i < word3.length() - space_index; i++) {
            for (int j = 0; j < boundary; j++) {
                char word1_char = word1.charAt(j + word1_index + 2);
                char word2_char = word2.charAt(j + word2_index + 2);
                char word3_char1 = word3.charAt(i);
                char word3_char2 = word3.charAt(i + space_index);
                if (word3_char1 == word1_char && word3_char2 == word2_char) {
                    result++;
                }
            }
        }
        return result;
    }

    static List<int[]> findAllOccurs(String word1, String word2) {

        List<int[]> result = new ArrayList<>();
        int word1_index = 0;
        for (char ch : word1.toCharArray()) {
            List<Integer> occurs = findOccurs(word2, String.valueOf(ch));
            for (Integer word2_index : occurs) {
                result.add(new int[]{word1_index, word2_index});
            }
            word1_index++;
        }
        return result;
    }

    static List<Integer> findOccurs(String word, String match) {
        List<Integer> result = new ArrayList<>();
        for (int index = word.indexOf(match); index >= 0; index = word.indexOf(match, index + 1)) {
            result.add(index);
        }
        return result;
    }
}
