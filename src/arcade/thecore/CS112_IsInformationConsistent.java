package arcade.thecore;

/*
Court is in session. We got a group of witnesses who have all taken an oath to tell the truth.
The prosecutor is pointing at the defendants one by one and asking each witnesses a simple question
- "guilty or not?". The witnesses are allowed to respond in one of the following three ways:

I am sure he/she is guilty.
I am sure he/she is innocent.
I have no idea.
The prosecutor has a hunch that one of the witnesses might not be telling the truth so she decides
to cross-check all of their testimonies and see if the information gathered is consistent, i.e. there
are no two witnesses A and B and a defendant C such that A says C is guilty while B says C is innocent.

Example
For
evidences = [[ 0, 1, 0, 1],
             [-1, 1, 0, 0],
             [-1, 0, 0, 1]]
the output should be
solution(evidences) = true;

For
evidences = [[ 1, 0],
             [-1, 0],
             [ 1, 1],
             [ 1, 1]]
the output should be
solution(evidences) = false.
 */
public class CS112_IsInformationConsistent {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 1, 0, 1},
                {-1, 1, 0, 0},
                {-1, 0, 0, 1}
        }));
    }

    static boolean solution(int[][] evidences) {
        int isGuilty;
        for (int i = 0; i < evidences[0].length; i++) {
            isGuilty = 0;
            for (int[] evidence : evidences) {
                if (isGuilty != 0 && evidence[i] != 0 && isGuilty != evidence[i]) {
                    return false;
                }
                isGuilty = evidence[i] != 0 ? evidence[i] : isGuilty;
            }
        }
        return true;
    }
}
