import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {5, 3, 6, 2, 9, 6, 4, 7, 1};
        int[] result = bubbleSort(list);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] bubbleSort(int[] list) {
        int n = list.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (list[j - 1] > list[j]) {
                    //swap elements
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }

            }
        }
        return list;
    }
}
