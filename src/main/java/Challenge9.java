import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenge9 {
    public static Integer decode( String roman ) {
        System.out.println(roman);
        List<String> numerals = Arrays.asList("M", "D", "C", "L", "X", "V", "I");
        List<Integer> decimals = Arrays.asList(1000, 500, 100, 50, 10, 5, 1);
        List<String> splitted = Arrays.asList(roman.split(""));
        List<Integer> intvalues = new ArrayList<>();
        for (int i = 0; i < splitted.size(); i++) {
            for (int j = 0; j < numerals.size(); j++) {
                if (splitted.get(i).equals(numerals.get(j))) {
                    intvalues.add(decimals.get(j));
                }
            }
        }
        int sum = 0;
        for (int x = 0; x < intvalues.size(); x++) {
            if (x == intvalues.size()-1) {
                sum += intvalues.get(x);
                break;
            }
            if (intvalues.get(x) >= intvalues.get(x+1)) {
                sum += intvalues.get(x);
            }else {
                sum -= intvalues.get(x);
            }
        }
        System.out.println(sum);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(decode("XXI"));
        System.out.println(decode("V"));
        System.out.println(decode("MCMXCVIII"));
    }
}