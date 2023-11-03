package arcade.thecore;

/*
Proper nouns always begin with a capital letter, followed by small letters.
Correct a given proper noun so that it fits this statement.

Example
For noun = "pARiS", the output should be
solution(noun) = "Paris";
For noun = "John", the output should be
solution(noun) = "John".
 */
public class CS052_ProperNounCorrection {
    public static void main(String[] args) {
        System.out.println(solution("ROse"));
    }

    static String solution(String noun) {
        return noun.isEmpty() ? "" : noun.toUpperCase().charAt(0) + noun.substring(1).toLowerCase();
    }
}
