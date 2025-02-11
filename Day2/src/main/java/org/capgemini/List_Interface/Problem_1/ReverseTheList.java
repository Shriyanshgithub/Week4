package org.capgemini.List_Interface.Problem_1;

public class ReverseTheList {
    public static void main(String[] args) {
        //create the linked List which to be reverse
        Node originalNode = new Node(1);
        originalNode.next = new Node(2);
        originalNode.next.next = new Node(3);
        originalNode.next.next.next = new Node(4);
        originalNode.next.next.next.next = new Node(5);

        //display the linked list before reverse
        System.out.println("The original List is ");
        Node temp = originalNode;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
        //initialize the object of class ReversedLinkedList
        ReversedLinkedList reversedLinkedList = new ReversedLinkedList(originalNode);

        //class method to display the reverse linkedList
        reversedLinkedList.printLinkedList();
    }
}
