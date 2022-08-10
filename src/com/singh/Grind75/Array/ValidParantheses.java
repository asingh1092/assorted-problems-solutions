package src.com.singh.Grind75.Array;

import java.util.Stack;

public class ValidParantheses {

    final char OPEN_PARAN = '(';
    final char CLOSE_PARAN = ')';
    final char OPEN_BRACK = '[';
    final char CLOSE_BRACK = ']';
    final char OPEN_CURLY = '{';
    final char CLOSE_CURLY = '}';

    public boolean isValidParantheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == OPEN_CURLY)
                stack.push(CLOSE_CURLY);
            else if (c == OPEN_BRACK)
                stack.push(CLOSE_BRACK);
            else if (c == OPEN_PARAN)
                stack.push(CLOSE_PARAN);
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        System.out.println(validParantheses.isValidParantheses("[]{}()"));
        System.out.println(validParantheses.isValidParantheses("[]{})"));
        System.out.println(validParantheses.isValidParantheses("[]{"));
        System.out.println(validParantheses.isValidParantheses("[{}()"));
        System.out.println(validParantheses.isValidParantheses("[[][][][][]]{[][]}(()())"));
        System.out.println(validParantheses.isValidParantheses("[]{}()"));

    }
}
