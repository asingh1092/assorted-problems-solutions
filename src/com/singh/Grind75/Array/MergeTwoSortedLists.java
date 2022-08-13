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


    public static ListNode mergeList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;

        ListNode dummy1 = first;
        ListNode dummy2 = second;
        while (dummy1.next != null && dummy2.next != null) {
            if (dummy1.data <= dummy2.data) {
                dummy.next = new ListNode(dummy1.data);
                dummy.next.next = new ListNode(dummy2.data);
            } else {
                dummy.next = new ListNode(dummy2.data);
                dummy.next.next = new ListNode(dummy1.data);
            }
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
            dummy = dummy.next.next;
        }

        while (dummy1.next != null) {
            dummy.next = new ListNode(dummy1.data);
            dummy1 = dummy1.next;
            dummy = dummy.next;
        }

        while (dummy2.next != null) {
            dummy.next = new ListNode(dummy2.data);
            dummy2 = dummy2.next;
            dummy = dummy.next;
        }

        return ret.next;
    }

    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 4};
        int[] second = new int[]{1, 3, 4};
        System.out.println(Arrays.toString(mergeList(first, second)));

        ListNode firstNode = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode secondNode = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeList(firstNode, secondNode));
    }

    private static class ListNode {

        private int data;
        private ListNode next = null;

        private ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }


        public int getData() {
            return data;
        }

        public void setData(int newData) {
            this.data = newData;
        }

        public ListNode getNext() {
            return this.next;
        }

        public void setNext(ListNode newNext) {
            this.next = newNext;
        }

        @Override
        public String toString() {
            return "ListNode(data=" + this.data + ", next=" + this.next + ")";
        }
    }
}
