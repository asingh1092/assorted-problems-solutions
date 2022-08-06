package src.com.singh.YouTube;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    /*
        -> need to sort first
        -> divide problem in half
                -> can we divide?
                        -> divide problem in half
        ->

        Time: O(log n) where n is the number of items in list
     */

    public static int naiveSearch(int[] items, int target) {
        // Time: O(n) Space: O(1)

        int idx = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == target) {
                idx = i;
            }
        }
        return idx;
    }

    public static int binarySearch(int[] items, int target) {
        // Time: O(log n) Space: O(n)
        int start = 0;
        int end = items.length - 1;
        int mid = (int) Math.floor((start + end) / 2);
        while (items[mid] != target && start <= end) {
            if (target < items[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (int) Math.floor((start + end) / 2);
        }
        return items[mid] == target ? mid : -1;
    }

    public static void main(String[] args) {
        int[] items = new int[]{1, 2, 5, 8, 9, 11, 21, 23, 27, 36, 44, 54};
        System.out.println(naiveSearch(items, 23));
        System.out.println(binarySearch(items, 23));

        int bigList = 100000000;
        int target;
        items = new int[bigList];
        Random rand = new Random();
        for (int i = 0; i < bigList; i++) {
            items[i] = rand.nextInt();
        }
        target = items[rand.nextInt(bigList)];

        System.out.println(LocalTime.now());
        Arrays.sort(items);
        System.out.println(LocalTime.now());
        System.out.println(naiveSearch(items, target));
        System.out.println(LocalTime.now());
        System.out.println(binarySearch(items, target));
        System.out.println(LocalTime.now());
    }
}
