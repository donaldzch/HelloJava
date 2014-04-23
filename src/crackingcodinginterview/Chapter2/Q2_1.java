package crackingcodinginterview.Chapter2;

import java.util.Hashtable;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_1 {
    /**
     * Write code to remove duplicates from an unsorted linked list.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    private static void removeDuplicates(LinkedListNode head) {
        Hashtable hashtable = new Hashtable();
        LinkedListNode previous = null;
        LinkedListNode n = head;
        while (n != null) {
            if (hashtable.containsKey(n.getData())) {
                previous.setNext(n.getNext());
            } else {
                hashtable.put(n.getData(), true);
                previous = n;
            }
            n = n.getNext();
        }
    }

    private static void removeDuplicates1(LinkedListNode head) {
        if (head == null) {
            return;
        }

        LinkedListNode current = head;

        while(current != null) {
            LinkedListNode next = current;
            while (next.getNext() != null) {
                if (next.getNext().getData() == current.getData()) {
                    next.setNext(next.getNext().getNext());
                } else {
                    next = next.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode n = head;
        for (int i = 0; i < 5; i++) {
            n.setNext(new LinkedListNode(i));
            n = n.getNext();
        }
        n = head;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
        System.out.print("\nafter remove\n");
        removeDuplicates1(head);
        n = head;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
    }
}
