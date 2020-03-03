import java.io.*;
// Java program to implement
// a Singly Linked List
public class LinkedList<T> {

    Node<T> head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node<T> {

        T data;
        Node<T> next;

        // Constructor
        Node(T d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public LinkedList insert(LinkedList list, T data)
    {
        // Create a new node with given data
        Node<T> new_node = new Node<>(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }


    // Method to print the LinkedList.
    public void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data.toString() + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }


    //O(n) extra space and O(n) time
    public void printreverse(LinkedList list) {
        MyStack<T> S = new MyStack<T>();
        Node<T>  curNode = list.head;
        while(curNode!=null) {
            S.push(curNode.data);
            curNode = curNode.next;
        }
        while(S.isEmpty()==false) {
            System.out.println(S.pop());
        }
    }

    //any runtime O(1) extra space
    //指针先指在上面， 再len+1
    public int length(LinkedList l) {
        int len=0;
        Node<T> curNode = l.head;
        while(curNode!=null) {
            len = len+1;
            curNode=curNode.next;
        }
        return len;
    }


    public void printL(LinkedList l) {
        int n = l.length(l);
        for(int i=0; i<n;i++) {
            Node curNode = l.head;
            for(int j=0; j<n-i-1; j++) {
                curNode = curNode.next;
            }
            System.out.println(curNode.data);
        }
    }





}