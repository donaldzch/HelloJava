package crackingcodinginterview.Chapter2;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_3 {
    /**
     * Implement an algorithm to delete a node in the middle of a singly linked list, given
     * only access to that node
     */
    private static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.getNext() == null) {
            return false;
        }
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);

        LinkedListNode n = head;

        for (int i = 1; i <= 10; i++) {
            n.setNext(new LinkedListNode(i));
            n = n.getNext();
        }

        LinkedListNode n3 = head;

        while (n3 != null && n3.getData() != 10) {
            n3 = n3.getNext();
        }
        if (deleteNode(n3)) {
            n = head;
            while (n != null) {
                System.out.print(n.getData() + ",");
                n = n.getNext();
            }
        } else {
            System.out.print("cannot delete last node or invalid node");
        }
    }
}
