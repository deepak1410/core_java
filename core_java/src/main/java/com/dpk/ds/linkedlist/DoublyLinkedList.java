package com.dpk.ds.linkedlist;

public class DoublyLinkedList<T> {

    public class Node<T> {
        private T data;
        private Node previous;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head = null;

    private boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(T data) {
        size++;

        if(head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        Node currentHead = head;
        newNode.next = currentHead;
        currentHead.previous = newNode;
        head = newNode;

    }

    public void deleteNode(T data) {
        if(head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while(current != null) {
            if(current.data == data) {
                Node previousNode = current.previous;
                Node nextNode = current.next;

                previousNode.next = nextNode;
                nextNode.previous = previousNode;
                current = null;
                size--;
                break;
            }
            current = current.next;
        }
    }

    public void display(Node node) {
        while (node != null) {
            System.out.print("|" + node.data + "| -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(2);
        dll.insertAtHead(4);
        dll.insertAtHead(6);
        dll.insertAtHead(8);

        dll.display(dll.head);

        System.out.println("Deleting node 6");
        dll.deleteNode(6);
        System.out.println("Display nodes");
        dll.display(dll.head);

    }

}
