

public class LinkedList {
    
    //Made static so that MAIN method can access it
    static class Node {
        int data;
        Node next;

        //Constructor to create new node, next by default is null
        Node(int d) {
            data = d;
        }
    }

    Node head;

    //Method to insert new node in LL

    public static LinkedList insert(LinkedList list, int data) {

        //Create new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        //If the list is empty make the inserted node as the head
        if(list.head == null) {
            list.head = new_node;
        }
         //Else travel till the end and insert it after the last node
        else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }

            //Once last.next is null
            last.next = new_node;
            //
        }

        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("Linked List: ");


        //Traverse through the linked list
        while(currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;

        }
    }

    public static void main(String[] args) {
        //Create a new list

        LinkedList list = new LinkedList();

        //Insertion
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);

        //Print the List
        printList(list);
        
    }
}