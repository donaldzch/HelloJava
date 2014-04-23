package crackingcodinginterview.Chapter2;

import com.sun.tools.javac.resources.legacy;

import java.util.Random;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_4 {
    /**
     * Write code to partition a linked list around a value x, such that all node less than x
     * come before all nodes greater than or equal to x
     */
    private static LinkedListNode partition(LinkedListNode head, int x) {
        LinkedListNode n = head;
        LinkedListNode less = null, more = null;
        while (n != null) {
            LinkedListNode next = n.getNext();
            if (n.getData() < x) {
                n.setNext(less);
                less = n;
            } else {
                n.setNext(more);
                more = n;
            }
            n = next;
        }
        if (less == null) {
            return more;
        }

        head = less;
        while (less.getNext() != null) {
            less = less.getNext();
        }
        less.setNext(more);
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);

        LinkedListNode n = head;

        for (int i = 1; i <= 10; i++) {
            n.setNext(new LinkedListNode(i));
            n = n.getNext();
        }

        n = head;
        n = partition(n, 5);

        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
    }
}
