package org.capgemini.List_Interface.Problem_1;

public class ReverseTheList {
    public static void main(String[] args) {
        Node originalNode = new Node(1);
        originalNode.next = new Node(2);
        originalNode.next.next = new Node(3);
        originalNode.next.next.next = new Node(4);
        originalNode.next.next.next.next = new Node(5);

        System.out.println("The original List is ");
        Node temp = originalNode;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
        ReversedLinkedList reversedLinkedList = new ReversedLinkedList(originalNode);

        reversedLinkedList.printLinkedList();
    }
}
