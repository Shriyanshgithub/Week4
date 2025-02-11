package org.capgemini.List_Interface.Problem_1;

public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data  = data;
        next = null;
    }
}
class ReversedLinkedList{
    Node head;

    public ReversedLinkedList(Node node){
        this.head = reverseLinkedListRecursion(node);
    }

    private Node reverseLinkedListRecursion(Node current){
        if(current == null || current.next == null){
            return current;
        }
        Node newCurrent = reverseLinkedListRecursion(current.next);
        Node temp = current.next;
        temp.next = current;
        current.next = null;
        return newCurrent;
    }

    void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}