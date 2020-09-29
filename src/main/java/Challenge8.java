import java.util.ArrayList;
import java.util.List;

class Challenge8 {
    public static Integer stringSuffix( String str ) {
        System.out.println(str);

        List<String> list = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i));
        }
        System.out.println(list.toString());
        for (int j = 0; j < list.size(); j++) {
            int count = 0;
            String current = list.get(j);
            for (int k = 0; k < current.length(); k++) {
                if (str.charAt(k) == current.charAt(k)) {
                    count++;
                }else {
                    break;
                }
            }
            intList.add(count);
        }
        System.out.println(intList.toString());
        int result = 0;
        for (int x = 0; x < intList.size(); x++) {
            result += intList.get(x);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(stringSuffix("ababaa"));
    }
}
