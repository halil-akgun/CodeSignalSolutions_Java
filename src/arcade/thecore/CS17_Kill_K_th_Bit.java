package arcade.thecore;

/*
Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
In order to stop the Mad Coder evil genius you need to decipher the encrypted message he sent to his minions.
The message contains several numbers that, when typed into a supercomputer, will launch a missile into
the sky blocking out the sun, and making all the people on Earth grumpy and sad.

You figured out that some numbers have a modified single digit in their binary representation. More specifically,
in the given number n the kth bit from the right was initially set to 0, but its current value might be different.
It's now up to you to write a function that will change the kth bit of n back to 0.

Example
For n = 37 and k = 3, the output should be
solution(n, k) = 33.
37(10) = 100101(2) ~> 100001(2) = 33(10).

For n = 37 and k = 4, the output should be
solution(n, k) = 37.
The 4th bit is 0 already (looks like the Mad Coder forgot to encrypt this number), so the answer is still 37.
 */
public class CS17_Kill_K_th_Bit {
    public static void main(String[] args) {
        System.out.println(solution(2039063284, 4));
    }

    static int solution(int n, int k) {
        if (n == 0)
            return 0;
        StringBuilder binary = calculateBinary(n);
        int indexK = binary.length() - k;
        if (Integer.parseInt(binary.substring(indexK, indexK + 1)) == 1)
            binary.replace(binary.length() - k, binary.length() - k + 1, "0");
        return convertToDecimal(binary);
    }

    private static int convertToDecimal(StringBuilder a) {
        int decimal = 0;
        int pow = 0;

        while (pow < a.length()) {
            int temp = Integer.parseInt(a.substring(a.length() - 1 - pow, a.length() - pow));
            decimal += temp * Math.pow(2, pow++);
        }
        return decimal;
    }

    private static StringBuilder calculateBinary(int n) {
        StringBuilder temp = new StringBuilder();
        while (n > 0) {
            int temp2 = n % 2;
            if (n == 1)
                temp.append(1);
            else
                temp.append(temp2);
            n /= 2;
        }
        temp.reverse();
        return temp;
    }
}
/*
User
int solution(int n, int k) {
  return n & ~(1 << (k - 1));
} benim kod yerine bunu kabul etti, nasil oldu anlamadim

ChatGPT
int solution(int n, int k) { return n & ~(1 << (k - 1)); } kodu, istenen işlemi gerçekleştiren daha kısa bir çözüm sağlamaktadır. İşleyişini aşağıda açıklayayım:

k - 1 ifadesi, k'nci bitin sıfırdan başlayan indeksini temsil eder. Örneğin, k = 4 ise, k'nci bitin indeksi 3 olacaktır.
(1 << (k - 1)) ifadesi, k'nci bitin değerini temsil eden ikili sayıyı elde etmek için kullanılır. İlgili bit dışındaki diğer bitler 0 olur.
~(1 << (k - 1)) ifadesi, k'nci bit dışındaki diğer bitlerin tam tersini elde etmek için kullanılır. Yani k'nci bit 0 ise 1, 1 ise 0 olur.
n & ~(1 << (k - 1)) ifadesi, n sayısının k'nci bitini 0 yapmak için kullanılır. n sayısının ilgili biti zaten 0 ise herhangi bir değişiklik olmaz.
n sayısı ile ~(1 << (k - 1)) ifadesi arasında bit seviyesinde bir "ve" işlemi gerçekleştirilir.
Bu işlem, k'nci bitin 0 olmasını sağlar ve diğer bitleri etkilemez.
Bu nedenle, verilen n sayısının k'nci bitini 0 yapmak için yukarıdaki kod kullanılabilir.
 */
