import java.util.ArrayList;
import java.util.List;

public class Challenge14 {
    public static String numerals(int n) {
        System.out.println(n);
        List<String> numerals = new ArrayList<>();
        while (n >= 1000) {
            numerals.add("M");
            n -= 1000;
        }
        if (n >= 900) {
            numerals.add("CM");
            n -= 900;
        }
        if (n >= 500) {
            numerals.add("D");
            n -= 500;
        }
        if (n >= 400) {
            numerals.add("CD");
            n -= 400;
        }
        while (n > 99) {
            numerals.add("C");
            n -= 100;
        }
        if (n >= 90) {
            numerals.add("XC");
            n -= 90;
        }
        if (n >= 50) {
            numerals.add("L");
            n -= 50;
        }
        if (n >= 40) {
            numerals.add("XL");
            n -= 40;
        }
        while (n >= 10) {
            numerals.add("X");
            n -= 10;
        }
        if (n == 9) {
            numerals.add("IX");
            n -= 9;
        }
        if (n >= 5) {
            numerals.add("V");
            n -= 5;
        }
        if (n == 4) {
            numerals.add("IV");
            n -= 4;
        }
        while (n > 0) {
            numerals.add("I");
            n--;
        }
        return "".join("", numerals);
    }
    public static void main(String[] args) {
        System.out.println(numerals(2342));
        System.out.println(numerals(1478));
        System.out.println(numerals(8));
        System.out.println(numerals(9));
        System.out.println(numerals(99));
        System.out.println(numerals(1988));
    }
}