import java.lang.reflect.Array;
import java.util.*;

public class Shortener {
    private static final String allowedString = "abcdefghijklmnopqrstuvwxyz";
    private char[] allowedCharacters = allowedString.toCharArray();
    private int base = allowedCharacters.length;
    private static List<String> db = new ArrayList<>();

    public String urlShortener(String longURL) {
        String result = "";
        System.out.println(longURL);
        if (!db.contains(longURL))
            db.add(longURL);
        int input = db.indexOf(longURL);
        System.out.println(input);
        StringBuilder encodedString = new StringBuilder();

        if(input == 0) {
            result = "short.ly/" + String.valueOf(allowedCharacters[0]);
            System.out.println(result);
            System.out.println(urlRedirector(result));
            return result;
        }
        int limit = 4;
        while (input > 0) {
            if (limit == 0) {
//         System.out.println(input);
                break;
            }
            encodedString.append(allowedCharacters[(int) (input % base)]);
            input = input / base;
            limit--;
        }
        result = "short.ly/" + encodedString.reverse().toString();
        System.out.println(result);
        System.out.println(urlRedirector(result));
        return result;
    }

    public String urlRedirector(String shortURL) {
        char[] characters = shortURL.substring(9).toCharArray();
        int length = characters.length;

        int decoded = 0;
        //counter is used to avoid reversing input string
        int counter = 1;
        for (int i = 0; i < length; i++, counter++) {
            decoded += allowedString.indexOf(characters[i]) * Math.pow(base, length - counter);
        }
        System.out.println(decoded);
        return db.get(decoded);
    }
}
