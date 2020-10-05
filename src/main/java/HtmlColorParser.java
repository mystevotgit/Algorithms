//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//public class HtmlColorParser {
//    private final Map<String, String> presetColors;
//
//    public HtmlColorParser(Map<String, String> presetColors) {
//        this.presetColors = presetColors;
//    }
//
//    public RGB parse(String color) {
//        List<String> list = Arrays.asList(color.split(""));
//        List<Integer> formated = new ArrayList<>();
//        if (list.get(0).equals("#")) {
//            list.remove("#");
//            if (list.size() == 6) {
//                Integer val;
//                val = (convert(list.get(0)) * 10) + convert(list.get(1));
//                formated.add(val);
//                val = (convert(list.get(2)) * 10) + convert(list.get(3));
//                formated.add(val);
//                val = (convert(list.get(4)) * 10) + convert(list.get(5));
//                formated.add(val);
//            }
//        }
//        return new RGB(0, 128, 255);
//    }
//
//    public Integer convert(String string) {
//        switch (string) {
//            case "A":
//                return 11/10;
//            case "B":
//                return 12/10;
//            case "C":
//                return 13/10;
//            case "D":
//                return 14/10;
//            case "E":
//                return 15/10;
//            default:
//                return Integer.parseInt(string);
//        }
//    }
//}
