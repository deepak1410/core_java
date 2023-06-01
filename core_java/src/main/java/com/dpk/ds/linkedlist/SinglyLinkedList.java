package com.dpk.ds.linkedlist;

public class SinglyLinkedList<T> {

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node headNode;
    private int size;

    public SinglyLinkedList() {
        this.headNode = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        newNode.next = headNode;
        headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        Node current = headNode;

        while(current.next != null) {
            current = current.next;
        }

        Node newNode = new Node(data);
        current.next = newNode;
        size++;
    }

    public void insertAfter(int data, int n) {
        Node current = headNode;
        for(int i=0; i<n; i++) {
            current = current.next;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;

    }

    public boolean searchNode(T data) {
        Node current = headNode;
        while (current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void deleteAtHead() {
        if(isEmpty()) {
            return;
        }

        headNode = headNode.next;
        size--;
    }

    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if(currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)){
                prevNode.next = currentNode.next;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

    }

    public void display(Node node) {
        while (node != null) {
            System.out.print("|" + node.data + "| -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(6);

        Node head = node1;
        node1.next = node2;
        node2.next = node3;

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.headNode  = node1;

        System.out.println("\nDisplaying the LinkedList items ");
        singlyLinkedList.display(head);

        System.out.println("\nInsert an item at the head");
        singlyLinkedList.insertAtHead(0);
        singlyLinkedList.display(singlyLinkedList.headNode);

        System.out.println("\nInserting an item at the end");
        singlyLinkedList.insertAtEnd(8);
        singlyLinkedList.display(singlyLinkedList.headNode);

        System.out.println("\nInserting an item after 2 nodes");
        singlyLinkedList.insertAfter(20, 2);
        singlyLinkedList.display(singlyLinkedList.headNode);

        System.out.println("\nSearching for 4 | Found=" + singlyLinkedList.searchNode(4));
        System.out.println("Searching for 0 | Found=" + singlyLinkedList.searchNode(0));
        System.out.println("Searching for 8 | Found=" + singlyLinkedList.searchNode(8));
        System.out.println("Searching for 99 | Found=" + singlyLinkedList.searchNode(99));

        System.out.println("Deleting at head");
        singlyLinkedList.deleteAtHead();
        singlyLinkedList.display(singlyLinkedList.headNode);

        System.out.println("\nDeleting by value = 20");
        singlyLinkedList.deleteByValue(20);
        singlyLinkedList.display(singlyLinkedList.headNode);
    }
}
