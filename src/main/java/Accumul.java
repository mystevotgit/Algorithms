import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Accumul {

    public static String accum(String s) {
        // your code
        // Split and store the each letter in a list
        List<String> list = Arrays.asList(s.split(""));
        // Create a new list to store processed character
        List<String> resultList = new ArrayList<>();

        // Process each character according to their index
        for (int i = 0; i < list.size(); i++) {
            String accumulate = "";
            if (i == 0) {
                resultList.add(list.get(i).toUpperCase());
            }else{
                accumulate += list.get(i).toUpperCase();
                for (int j = 1; j < i + 1; j++) {
                    accumulate += list.get(i).toLowerCase();
                }
                resultList.add(accumulate);
            }
        }
        // Join and return the content of the resultList
        return "".join("-", resultList);
    }
    
    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));
        System.out.println(accum("UnzlhNcraxD"));
    }
}
