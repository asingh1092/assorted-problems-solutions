package src.com.singh.Grind75.Array;

import java.util.Arrays;

public class MergeTwoSortedLists {


    public static int[] mergeList(int[] first, int[] second) {
        int firstSize = first.length;
        int secondSize = second.length;
        int[] ret = new int[firstSize + secondSize];

        int p1 = 0;
        int p2 = 0;
        int pRet = 0;
        while (p1 != firstSize && p2 != secondSize) {
            if (first[p1] <= second[p2]) {
                ret[pRet] = first[p1];
                ret[pRet + 1] = second[p2];
            } else {
                ret[pRet] = second[p2];
                ret[pRet + 1] = first[p1];
            }
            pRet = pRet + 2;
            p1++;
            p2++;
        }

        // rest of p1
        while (p1 != firstSize) {
            ret[pRet] = first[p1];
            pRet++;
            p1++;
        }

        // rest of p2
        while (p2 != secondSize) {
            ret[pRet] = second[p2];
            pRet++;
            p2++;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 4};
        int[] second = new int[]{1, 3, 4};
        System.out.println(Arrays.toString(mergeList(first, second)));
    }
}
