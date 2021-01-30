import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Main {

    public static void main(String[] args) {
        System.out.println(reverse("ACCESS BANK"));
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(checkSum(array, 10).toString());
    }

    public static String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static List<Integer> checkSum(int[] arr, int number) {
        int val = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (val < number && val + arr[i] <= number) {
                val += arr[i];
                result.add(i);
            }
        }
        return result;
    }
}

