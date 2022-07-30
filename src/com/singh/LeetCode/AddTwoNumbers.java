package src.com.singh.LeetCode;

public class AddTwoNumbers {
    /* Given two non-empty linked lists representing two non-negative integers, add the two numbers and return the sum
       as a linked list.

       - The digits are stored in reverse order, and each of their nodes contains a single digit.

       Assume the two numbers do not contain any leading zeros, except the number 0 itself.

        Ex 1. l1 = [2, 4, 3]
              l2 = [5, 6, 4]
                -> [7, 0, 8]

             342 + 465 = 807
        Ex 2. l1 = [0],
              l2 = [0]
                -> [0]

              0 + 0 = 0
        Ex 3. l1 = [9, 9, 9, 9, 9, 9, 9]
              l2 = [9, 9, 9, 9]
                -> [8, 9, 9, 9, 0, 0, 0, 1]

             9,999,999 + 9,999 = 10,009,998



     */

    public static ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode retHead = new ListNode();
        int carry;
        ListNode dummyRet = retHead;
        ListNode dummyFirst = first;
        ListNode dummySecond = second;

        // base case
        if (first.data <= 0 || second.data <= 0) {
            return new ListNode(0);
        }

        // add heads
        int headTotal = dummyFirst.data + dummySecond.data;
        carry = headTotal / 10;
        retHead.data = headTotal % 10;

        // go down rest of list
        while (dummyFirst.next != null && dummySecond.next != null) {
            int total = dummyFirst.data + dummySecond.data + carry;
            carry = total / 10;
            dummyRet.next = new ListNode(total % 10);

            dummyRet = dummyRet.next;
            dummyFirst = dummyFirst.next;
            dummySecond = dummySecond.next;
        }

        // go down rest of first
        while (dummyFirst.next != null) {
            int total = dummyFirst.data + carry;
            carry = total / 10;
            dummyRet.next = new ListNode(total % 10);

            dummyRet = dummyRet.next;
            dummyFirst = dummyFirst.next;
        }

        // go down rest of second
        while (dummySecond.next != null) {
            int total = dummySecond.data + carry;
            carry = total / 10;
            dummyRet.next = new ListNode(total % 10);

            dummyRet = dummyRet.next;
            dummySecond = dummySecond.next;
        }

        // add last carry if there is one
        if (carry > 0) {
            dummyRet.next = new ListNode(carry);
        }

        return retHead;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, null);
        ListNode l2 = new ListNode(0, null);
        System.out.println(addTwoNumbers(l1, l2));
        l1 = new ListNode(-5, null);
        l2 = new ListNode(-2, null);
        System.out.println(addTwoNumbers(l1, l2));
        l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(addTwoNumbers(l1, l2));
    }
}

