package crackingcodinginterview.Chapter2;

/**
 * Created by DonaldZhu on 4/19/14.
 */
public class Q2_5 {
    /**
     * You have two numbers represented by a linked list, where each node contains a
     * single digit. The digits are stored in reverse order, such that the 1's digit is at the head
     * of the list. Write a function that adds the two numbers and returns the sum as a
     * linked list.
     * FOLLOW UP
     * Suppose the digits are stored in forward order. Repeat the above problem
     */
    private static LinkedListNode sumInReverseOrder(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode sum = null;

        int carry = 0;
        LinkedListNode current = null;
        while (n1 != null && n2 != null) {
            int result = n1.getData() + n2.getData() + carry;
            if (sum == null) {
                sum = new LinkedListNode(result % 10);
                current = sum;
            } else {
                current.setNext(new LinkedListNode(result % 10));
                current = current.getNext();
            }
            carry = result / 10;
            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        LinkedListNode n3 = n1 == null ? n2 : n1;
        while (n3 != null) {
            int result1 = n3.getData() + carry;
            current.setNext(new LinkedListNode(result1 % 10));
            carry = result1 / 10;
            n3 = n3.getNext();
            current = current.getNext();
        }
        if (carry != 0) {
            current.setNext(new LinkedListNode(carry));
        }

        return sum;
    }

    private static LinkedListNode sumInReverseOrder(LinkedListNode n1, LinkedListNode n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode(carry);

        int value = carry;
        if (n1 != null)
            value += n1.getData();
        if (n2 != null)
            value += n2.getData();

        result.setData(value % 10);

        if (n1 != null || n2 != null) {
            LinkedListNode more = sumInReverseOrder(n1 == null ? null : n1.getNext(),
                    n2 == null ? null : n2.getNext(), value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    public static class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    private static int getLength(LinkedListNode node) {
        LinkedListNode n = node;
        int length = 0;
        while (n != null) {
            length++;
            n = n.getNext();
        }
        return length;
    }

    private static LinkedListNode padList(LinkedListNode node, int padLength) {
        LinkedListNode head = node;
        for (int i = 0; i < padLength; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static LinkedListNode insertBefore(LinkedListNode node, int data) {
        LinkedListNode n = new LinkedListNode(data);
        n.setNext(node);
        node = n;

        return node;
    }

    private static LinkedListNode sumInForwardOrder(LinkedListNode n1, LinkedListNode n2) {
        int length1 = getLength(n1);
        int length2 = getLength(n2);

        if (length1 < length2) {
            n1 = padList(n1, length2 - length1);
        } else {
            n2 = padList(n2, length1 - length2);
        }

        PartialSum sum = addSum(n1, n2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static PartialSum addSum(LinkedListNode n1, LinkedListNode n2) {
        if (n1 == null && n2 == null) {
            PartialSum partialSum = new PartialSum();
            return partialSum;
        }

        PartialSum sum = addSum(n1.getNext(), n2.getNext());

        int result = n1.getData() + n2.getData() + sum.carry;

        LinkedListNode resultNode = insertBefore(sum.sum, result % 10);

        sum.sum = resultNode;
        sum.carry = result / 10;
        return sum;
    }

    private static LinkedListNode createList(int[] data, int index) {
        if (index >= data.length) {
            return null;
        }
        LinkedListNode result = new LinkedListNode(data[index]);

        result.setNext(createList(data, ++index));

        return result;
    }

    public static void main(String[] args) {
        int[] listData1 = {7, 1, 3};
        LinkedListNode n1 = createList(listData1, 0);

        int[] listData2 = {5, 8, 6, 1};
        LinkedListNode n2 = createList(listData2, 0);

        LinkedListNode sum = sumInReverseOrder(n1, n2, 0);

        LinkedListNode n = sum;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
        System.out.print("\n");

        int[] listData3 = {3, 1, 7};
        LinkedListNode n3 = createList(listData3, 0);

        int[] listData4 = {1, 6, 8, 5};
        LinkedListNode n4 = createList(listData4, 0);

        sum = sumInForwardOrder(n3, n4);

        n = sum;
        while (n != null) {
            System.out.print(n.getData() + ",");
            n = n.getNext();
        }
    }
}
