package crackingcodinginterview.Chapter2;

/**
 * Created by DonaldZhu on 4/22/14.
 */
public class LinkedListNode {
    protected int data;
    protected LinkedListNode next;
    protected LinkedListNode previous;

    public LinkedListNode() {
        this.data = 0;
        this.next = null;
    }

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode node) {
        this.next = node;
    }
}
