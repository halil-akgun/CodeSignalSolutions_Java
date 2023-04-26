package arcade.intro;

/*
Given an integer product, find the smallest positive (i.e. greater than 0) integer
the product of whose digits is equal to the product. If there is no such integer, return -1 instead.

Example
For product = 12, the output should be
solution(product) = 26;
For product = 19, the output should be
solution(product) = -1.
 */
public class CS56_digitsProduct {
    public static void main(String[] args) {
        int product = 12;
        System.out.println(solution(product));
    }

    static int solution(int product) {
        if (product == 0) return 10;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            temp.append(i).append(j).append(k).append(l).append(m);
                            if (product == productDigits(Integer.parseInt(temp.toString())))
                                return Integer.parseInt(temp.toString());
                            temp.delete(0, 6);
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int productDigits(int num) {
        int result = 1;
        String[] digits = String.valueOf(num).split("");
        for (String w : digits) {
            result *= Integer.parseInt(w);
        }
        return result;
    }
}
