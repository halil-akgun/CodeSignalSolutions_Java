package arcade;

/*
Given two cells on the standard chess board, determine whether they have the same color or not.

Example
For cell1 = "A1" and cell2 = "C3", the output should be
solution(cell1, cell2) = true. // https://codesignal.s3.amazonaws.com/uploads/1664318508/example1.png?raw=true
For cell1 = "A1" and cell2 = "H3", the output should be
solution(cell1, cell2) = false. // https://codesignal.s3.amazonaws.com/uploads/1664318508/example2.png?raw=true
Input/Output

[input] string cell1
Guaranteed constraints:
cell1.length = 2,
'A' ≤ cell1[0] ≤ 'H',
1 ≤ cell1[1] ≤ 8.

[input] string cell2
Guaranteed constraints:
cell2.length = 2,
'A' ≤ cell2[0] ≤ 'H',
1 ≤ cell2[1] ≤ 8.

[output] boolean
true if both cells have the same color, false otherwise.
 */
public class CS29_chessBoardCellColor {
    public static void main(String[] args) {
        String cell1 = "A1";
        String cell2 = "D4";
        System.out.println(solution(cell1, cell2));
    }

    static boolean solution(String cell1, String cell2) {
        if ((cell1.charAt(0) % 2 == cell1.charAt(1) % 2) && (cell2.charAt(0) % 2 == cell2.charAt(1) % 2)) return true;
        return (cell1.charAt(0) % 2 != cell1.charAt(1) % 2) && (cell2.charAt(0) % 2 != cell2.charAt(1) % 2);
    }
}
