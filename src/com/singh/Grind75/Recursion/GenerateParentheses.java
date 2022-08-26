package src.com.singh.Grind75.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {

    /*
       Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses
           1 <= n <= 8

        Permutation problem -> recursion
        Base case: n = 1 -> ()
        n = 1 -> ()
        n = 2 -> (()), ()(),
        n = 3 -> ((())), ()(()), (())(), (()()), ()()()
        n = 4 -> (((()))), ()()(()), (())(()), ()(()()), ()((())), ()((())), ()(())

        base case = gP(1) = ()
        n = 2 -> gP(1)*() -> ()*() -> (()) + ()()
        n = 3 > gP(2)*() -> [(()) + ()()]*() ->


        Backtracking + Dynamic Programming
        ___________________________________________________________________________
        n = 1  -> ()
                            _
                           / \
                          (   )
                         /
                         )

        n = 2 -> 2*()

                           -
                          / \
                         (   )x
                        /  \
                       )    (
                      / \   / \
                     (   )x )  (x
                    /      / \
                   )      (x  )

     */

    public static List<String> generateParens(int n) {
        if (n < 0) {
            return Collections.emptyList();
        }
        List<String> ret = new ArrayList<>();

        return Collections.emptyList();
    }

    public static void main(String[] args) {

    }
}
