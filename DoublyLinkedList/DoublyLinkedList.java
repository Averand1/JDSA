package DoublyLinkedList;

public class DoublyLinkedList <T> implements Iterable <T> {

    int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    //Node class to represent data
    private class Node<T> {
        T data;
        Node <T> prev, next;
        public String item;
        public Node(T data, Node <T> prev, Node <T> next) {
            this.data = data;
            this.next = next;
        }
        @Override public String toString() {
            return data.toString();
        }
    }

    //Empty this linked list, O(n)
    public void clear() {
        Node <T> trav = head;
        while(trav!=null) {
            Node <T> next = trav.next;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //return the size of this linked list
    public int size() {
        return size;
    }

    //Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    //add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    //add an element to the beginning of the linked list, O(1)

    public void addFirst(T elem) {
        //The linked list is empty
        if(isEmpty()) {
            head = tail = new Node <T> (elem, null, null);
        } else {
            new Node <T> (elem, null, head);
        }

        size++;
    }

    public void addLast(T elem) {
         //The Linked List is empty

        if(isEmpty()) {
             head = tail = new Node <T> (elem, null, null);
        } else {
             tail.next = new Node <T> (elem, tail, null);
        }

        size++;
    }

    //checkt the value of first node if it exists, O(1)

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    //remove the first value at the head of the linked list, O(1)

    public T removeFirst() {
        //cant remove data from empty list
        if(isEmpty()) throw new RuntimeException("Empty List");
        //extra the data at thead and move
        T data = head.data;
        head = head.next;
        --size;

        //if the list is empty set the tail to null as well
        if(isEmpty()) tail = null;

        //Do a memory clean of the prev node
        else head.prev = null;

        //return the data that was at the first node we just removed;
        return data;
    }

    public T removeLast() {
         //cant remove data from empty list
         if(isEmpty()) throw new RuntimeException("Empty List");
         //extra the data at thead and move
         T data = tail.data;
         tail = tail.prev;
         --size;
 
         //if the list is empty set the tail to null as well
         if(isEmpty()) head = null;
 
         //Do a memory clean of the node that was just removed
         else tail.next = null;
 
         //return the data that was at the first node we just removed;
         return data;

    }

    private T remove(Node <T> node) {
        //if the node to be removed is somether between head or tail

        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        //temporary store the data we want to return
        T data = node.data;

        //Memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        //return the data at the node we just rmeoved
        return data;
    }
    
    public T removeAt(int index) throws IllegalAccessException {
        //MAke sure the index provided is valid 
        if(index < 0 || index >= size) throw new IllegalAccessException();
        int i;
        Node<T> trav;

        //search from the front of the list
        if(index < size/2) {
            for(i = 0, trav = head; i!=index; i++)
                trav = trav.next;

        //search form the back of the list
        } else
            for(i = size-1, trav = tail; i !=index; i--)
                trav = trav.prev;

        return remove(trav);
    }

    //remove a particular value in the linked list, O(n)

    public boolean remove(Object obj) {
        Node<T> trav = head;

        //support searching for null
        if(obj == null) {
            for(trav = head; trav != null; trav = trav.next) {
                if(trav.data == null) {
                    remove(trav);
                    return true;
                } 
            }
        } else {
            for(trav = head; trav!=null; trav=trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }
    
    //Find the index of a particular value in the linked list, O(n)

    public int indexOf(Object obj) {
        int index = 0;
        Node <T> trav = head;

        //support searching for null
        if(obj==null) {
            for(trav = head; trav!=null; trav=trav.next, index++)
                if(trav.data == null)
                    return index;

        //Search for non null object
        } else 
            for(trav = head; trav !=null; trav=trav.next, index++) 
                if(obj.equals(trav.data))
                    return index;

        return -1;

    }

    //check if a value is contained within the linked list

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public void printNodes() {  
        //Node current will point to head  
        Node <T> current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.item + " ");  
            current = current.next;  
        }  
    }  


    @Override public java.util.Iterator <T> iterator () {
        return new java.util.Iterator <T> () {
            private Node <T> trav = head;
            @Override public boolean hasNext() {
                return trav!=null;
            }
            @Override public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node <T> trav = head;
        while(trav != null) {
            sb.append(trav.data + ", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    
    
}
