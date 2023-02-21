package src.com.singh.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ZigZagConversion {

    /*
        The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

        You may want to display this patten in a fixed font for better legibility.

        P   A   H   N
        A P L S I I G
        Y   I   R

        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will takea  string and make this conversion given a number of rows:

                string convert(string s, int numRows);

        E.G. Input s = "PAYPALISHIRING", numRows = 3
             Output: "PAHNAPLSIIGYIR"

             Input s = "PAYPALISHIRING", numRows = 4
             Output: = "PINALSIGYAHRPI"

             3 -> 1
             0 1 2 1 0 1 2 1 0 1 2 1 0 1
             P A Y P A L I S H I R I N G
             0 0 0 0 1
             P A H N A P L S I I G Y I R


            Explanation:
            P      I     N
            A    L S   I G
            Y  A   H R
            P      I

            4 -> 2

            0 1 2 3 4 5 6 7 8 9 0 1 2 3
            0 1 2 3 2 1 0 1 2 3 2 1 0 1
            P A Y P A L I S H I R I N G


            x    x
            x   x
            x  x
            x x
            x

            5 -> 3

            n -> (n-2)

            Input s = "A", numRows = 1
            Output: "A"

            1 <= s.length <= 1000
            s consists of English letters (lower-case and upper-case), ',', and '.'
            1 <= numRows <= 1000


     */


    public static String convert(String input, int numRows) {
        int counter = 0;
        boolean reverse = false;
        HashMap<Integer, List<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            System.out.println(counter);
            if (!hashMap.containsKey(counter)) {
                hashMap.put(counter, new ArrayList<>());
                hashMap.get(counter).add(input.charAt(i));
            } else {
                hashMap.get(counter).add(input.charAt(i));
            }
            if (!reverse && counter <= numRows) {
                counter++;
            }
            if (reverse && counter >= 0) {
                counter--;
            }
            if (counter == numRows) {
                reverse = true;
            }
            if (counter == 0) {
                reverse = false;
            }
        }
        return hashMap.toString();
    }

    public static void main(String[] args) {

    }

}
