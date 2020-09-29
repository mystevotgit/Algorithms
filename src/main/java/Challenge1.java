import java.util.Arrays;
import java.util.List;

class Challenge1 {
    public static Integer lookSay( Integer number ) {
        if (number < 10) {
            return 10 + number;
        }
        String strnum = "" + number;
        List<String> list = Arrays.asList(strnum.split(""));
        String result = "";
        int count = 0;
        String current = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(current)) {
                count++;
            }else{
                result += count;
                count = 0;
                result += current;
                current = list.get(i);
                i--;
            }
        }
        result += count;
        result += list.get(list.size()-1);
        int finalResult = Integer.parseInt(result);
        return finalResult;
    }
    public static void main(String[] args) {
        System.out.println(lookSay(12));
        System.out.println(lookSay(0));
        System.out.println(lookSay(11));
        System.out.println(lookSay(333333331));
        System.out.println(lookSay(444333444));
        System.out.println(lookSay(22322));
    }
}