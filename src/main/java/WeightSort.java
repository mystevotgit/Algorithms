import java.util.*;

public class WeightSort {

    public static String orderWeight(String strng) {
        // your code
        System.out.println(strng);
        Map<Integer, String> mapped = new HashMap<>();
        List<String> list = Arrays.asList(strng.split(" "));
        List<Integer> resArr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int val = 0;
            for (int j = 0; j < list.get(i).length(); j++) {
                val += Integer.parseInt(String.valueOf(list.get(i).charAt(j)));
            }
            mapped.put(val, list.get(i));
            resArr.add(val);
        }
        Collections.sort(resArr);
        List<String> sorted = new ArrayList<>();
        for (int k = 0; k < resArr.size(); k++) {
            sorted.add(mapped.get(resArr.get(k)));
        }
        return "".join(" ", sorted);
    }
    public static void main(String[] args) {
        System.out.println(orderWeight("103 123 4444 99 2000"));
        System.out.println(orderWeight("278673 407564 319344 391792 201629 95575 162684 4911 224099 279573 84032 80408 448633 104595 265834 230959 377375 45606 362284 260302 9"));
        System.out.println(orderWeight("56 65 74 100 99 68 86 180 90"));
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight("482371 90191 1917 307428 378961 182538 24312 477332 422567 209370 299735 77814 195235 80967 257943 446089 86840 211697 419231 473537 6"));
    }
}
