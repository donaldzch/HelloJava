package crackingcodinginterview.Chapter2;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_2 {
    /**
     * Implement an algorithm to find the kth to last element of a singly linked list
     */
    private static LinkedListNode getKthToLastElement(LinkedListNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedListNode first = head, last = head;
        int i;
        for (i = 1; i <= k; i++) {
            if (last != null) {
                last = last.getNext();
            }
            else
                break;
        }
        if (i != k + 1) {
            return null;
        }

        while (last != null) {
            last = last.getNext();
            first = first.getNext();
        }
        return first;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);

        LinkedListNode n = head;

        for (int i = 1; i <= 10; i++) {
            n.setNext(new LinkedListNode(i));
            n = n.getNext();
        }
        System.out.print("3th to last element is: " + getKthToLastElement(head, 3).getData());
    }
}
