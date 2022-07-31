package src.com.singh.YouTube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IsSubsetOf {

    /*
        assume list2 is greater than or equal to list1 in terms of size
                - base case?

        N characters in list1
        M characters in list2

        M > N size

        O(N log N) -> sort list1
        O(M log M) -> sort list2
        O(M)

        O(N log N + M log M + M)

        O(N*M + M)
     */

    public static boolean isSubsetOf(List<Character> list1, List<Character> list2) {
        // check list sizes
        if (list2.size() < list1.size()) {
            return false;
        }

        // sort both lists
        Collections.sort(list1);
        Collections.sort(list2);

        int last = 0;
        for (Character character : list1) {
            for (int pointer2 = last; pointer2 < list2.size(); pointer2++) {
                if (character == list2.get(pointer2)) {
                    //set pointer to last position
                    last = pointer2;
                    break;
                }
                // if we're on the last item then we know for sure list1 isn't a subset of list2
                if (pointer2 == list2.size() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Character> list1 = Arrays.asList('a', 'b');
        List<Character> list2 = Arrays.asList('a', 'b');
        System.out.println(isSubsetOf(list1, list2));
        list1 = Arrays.asList('b', 'a');
        list2 = Arrays.asList('a', 'b');
        System.out.println(isSubsetOf(list1, list2));
        list1 = Arrays.asList('b', 'd');
        list2 = Arrays.asList('a', 'b');
        System.out.println(isSubsetOf(list1, list2));
        list1 = Arrays.asList('a', 'b');
        list2 = Arrays.asList('c', 'd', 'b', 'l');
        System.out.println(isSubsetOf(list1, list2));
        list1 = Arrays.asList('q', 'b');
        list2 = Arrays.asList('c', 'd', 'b', 'l', 'z', 'q', 'q', 'l');
        System.out.println(isSubsetOf(list1, list2));
    }
}
