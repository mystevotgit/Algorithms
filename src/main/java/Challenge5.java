import java.lang.reflect.Array;
import java.util.*;

class CSVParser2 {
    public static ArrayList<ArrayList<String>> parse(String input, char separator, char quote) {
        System.out.println(input+ "    " + separator + "    " + quote);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        List innerlist;
        String duo = "" + quote + quote;
        input = input.replaceAll(duo, ":");
        input = input.replaceAll(String.valueOf(quote), ";");

        for (int x = 0; x < input.length(); x++) {
            if (input.charAt(x) == ';'){
                String str = input.substring(x+1);
                List arr = Arrays.asList(str.split(";"));
                String firstStr = (String) arr.get(0);
                String build = "";
                for (int a = 0; a < firstStr.length(); a++) {
                    if (firstStr.charAt(a) != '\n') {
                        build += firstStr.charAt(a);
                    }else {
                        build += '=';
                    }
                }
                str = build + ';' + "".join("", (CharSequence) arr.get(1));
                input = input.substring(0, x+1) + str;
                break;
            }
        }
        innerlist = Arrays.asList(input.split("\\n"));
        System.out.println(innerlist.toString());
        return list;
    }
    public static void main(String[] args) {
        System.out.println(parse("1,2,3\n4,5,6", ',', '\"'));
        System.out.println(parse("1,\"two was here\",3\n4,5,6", ',', '\"'));
        System.out.println(parse("1\t2\t3\n4\t5\t6", '\t', '\"'));
        System.out.println(parse("1,\"two was\nup there\",3\n4,5,6", ',', '"'));
    }
}
