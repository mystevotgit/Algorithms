import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

class Challenge6 {
    public static Integer minimumSwaps( List<Integer> ratings ) {
        String res = check(ratings);
        System.out.println(res);
        int count = 0;
        int minimum = ratings.size()-1;
        for (int i = ratings.size()-1; i == 0; i--) {
            for (int j = 0; j < ratings.size(); j++) {
                if (ratings.get(minimum) > ratings.get(j)) {
                    count++;
                    int temp = ratings.get(minimum);
                    ratings.set(minimum, ratings.get(j));
                    ratings.set(j, temp);
                    minimum = j;
                }
                System.out.println(check(ratings));
                if (res.equals(check(ratings))) {
                    break;
                }
            }
        }
        return count;
    }

    public static String check(List<Integer> ratings) {
        List<Integer> strRatings = new ArrayList<>();
        ratings.forEach(val -> strRatings.add(val));
        Collections.sort(strRatings);
        Collections.reverse(strRatings);
        String str = "";
        for (int i = 0; i<strRatings.size(); i++){
            str += strRatings.get(i).toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(Arrays.asList(3,1,2,4)));
        System.out.println(minimumSwaps(Arrays.asList(3,1,2)));
//        System.out.println(minimumSwaps(Arrays.asList(31, 8, 15, 9, 17, 22, 27, 35, 38, 19, 40, 23, 30, 14, 7, 12, 13, 20, 11, 29, 4, 24, 28, 6, 37, 34, 33, 5, 16, 3, 21, 36, 26, 25, 10, 2, 18, 1, 32, 39)));
    }
}