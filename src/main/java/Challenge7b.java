import java.util.*;

class CSVParser {
    public static ArrayList<ArrayList<String>> parse(String input, char separator, char quote) {
        System.out.println(input+ "    " + separator + "    " + quote);
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> innerlist = new ArrayList<>();
        int count = 0;
        for (int x = 0; x < input.length(); x++) {
            if (input.charAt(x) != quote){
                innerlist.add(String.valueOf(input.charAt(x)));
            }else {
                count++;
                if (count % 2 != 0 && input.charAt(x) == '\n') {
                }
                if (count % 2 == 0 && input.charAt(x) == '\n') {
                    continue;
                }
            }
        }
        System.out.println(input);
        List<String> splitted = Arrays.asList(input.split("\\n"));
        System.out.println(splitted);
        for (int i = 0; i < splitted.size(); i++) {
            List<String> split = Arrays.asList(splitted.get(i).split(String.valueOf(separator)));
            ArrayList<String> strlist = new ArrayList<>();
            strlist.addAll(split);
            list.add(strlist);
        }


        return list;
    }
    public static void main(String[] args) {
        System.out.println(parse("1,2,3\n4,5,6", ',', '\"'));
        System.out.println(parse("1,\"two was here\",3\n4,5,6", ',', '\"'));
        System.out.println(parse("1\t2\t3\n4\t5\t6", '\t', '\"'));
        System.out.println(parse("1,\"two was\nup there\",3\n4,5,6", ',', '"'));
    }
}