import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenge10 {
    public static List<String> possibilities(String signals) {
        System.out.println(signals);
        List<String> morseCode = Arrays.asList(".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---");
        List<String> letters = Arrays.asList("E", "T", "I", "A", "N", "M", "S", "U", "R", "W", "D", "K", "G", "O");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < morseCode.size(); i++) {
            if (signals.equals(morseCode.get(i))) {
                result.add(letters.get(i));
                return result;
            }
        }
        for (int i = 0; i < morseCode.size(); i++) {
            if (signals.length() == morseCode.get(i).length()){
                String code = morseCode.get(i);
                for (int j = 0; j < signals.length(); j++) {
                    if (code.charAt(j) == '.' && signals.charAt(j) == '.') {
                        result.add(letters.get(i));
                    }else if (code.charAt(j) == '-' && signals.charAt(j) == '-') {
                        result.add(letters.get(i));
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(possibilities("."));
        System.out.println(possibilities("..."));
        System.out.println(possibilities(".-"));
        System.out.println(possibilities("?.?"));
        System.out.println(possibilities(".?"));
        System.out.println(possibilities("?."));
        System.out.println(possibilities("-?"));
        System.out.println(possibilities("?-"));
        System.out.println(possibilities("?-?"));
        System.out.println(possibilities("??."));
        System.out.println(possibilities("??-"));
    }
}