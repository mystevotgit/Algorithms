import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

class Challenge7 {
    public static Integer findOdd( List<Integer> integers ) {
        Set<Integer> unique = new HashSet<>(integers);
        Object[] uniqueArr = unique.toArray();
        for (int i = 0; i < unique.size(); i++) {
            int count = 0;
            for (int j = 0; j < integers.size(); j++) {
                if (uniqueArr[i] == integers.get(j)) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return (Integer) uniqueArr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findOdd(Arrays.asList(20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5)));
        System.out.println(findOdd(Arrays.asList(1, 2, 1, 2, 1)));
    }
}