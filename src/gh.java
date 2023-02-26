import java.util.ArrayList;
import java.util.List;

public class gh {
    public static void main(String[] args) {
        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        temp1.add("q");
        temp1.add("w");
        temp1.add("e");
        temp2.add("f");
        System.out.println(temp1.contains(temp2.get(0)));
    }
}
