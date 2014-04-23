package crackingcodinginterview.Chapter2;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_6 {
    /**
     * Given a circular linked list, implement an algorithm which returns the node at the
     * beginning of the loop
     */
    private static LinkedListNode findLoopStart(LinkedListNode head) {
        LinkedListNode fast = head, slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow)
                break;
        }

        if (fast == null || fast.getNext() == null) {
            return null;
        }
        slow = head;

        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return fast;
    }
}
