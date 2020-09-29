import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenge2 {
    public static String markdownParser(String markdown) {

        // Trim the spaces before and after the markdown string
        markdown = markdown.trim();

        // Split and convert the markdown into a list
        List<String> list = Arrays.asList(markdown.split(" "));

        // Handle invalid/nonconvertable markdown
        if (list.size() == 1) {
            return markdown;
        }
        if (!list.get(0).startsWith("#")) {
            return markdown;
        }
        if (list.get(0).length() > 6) {
            return markdown;
        }

        // Handle valid/convertable markdown
        String prefix = "<h" + list.get(0).length() + ">";
        String surfix = "</h" + list.get(0).length() + ">";
        String innerStr = "";
        List<String> newList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (i == list.size()-1) {
                innerStr += list.get(i);
            }else {
                innerStr += list.get(i);
                innerStr += " ";
            }
        }
        String result = prefix + innerStr.trim() + surfix;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(markdownParser("### ### Double Triple Header"));
        System.out.println(markdownParser("# Big"));
        System.out.println(markdownParser("#NoSpace"));
        System.out.println(markdownParser("# header"));
    }
}
