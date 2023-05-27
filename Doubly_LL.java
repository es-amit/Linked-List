public class Doubly_LL {
    public static Node head= null;
    public static Node tail  = null;
    public static int size = 0;
    public class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next = null;
            this.prev = null;
        }
    }
    // Addition of Node to Linked List to the front
    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head =tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    //Addition of  Node to linked last in the last
    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev =tail;
        tail= newNode;
    }
    // Traversal from front (head)
    public void traversalFront(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " <-> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
    // Traversal from back (Tail)
    public void traversalLast(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        Node currNode = tail;
        while(currNode != null){
            System.out.print(currNode.data+" <->");
            currNode = currNode.prev;
        }
        System.out.println("NULL");
    }
    //Deletion of the first node
    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next == null){
            head =tail= null;
            return;
        }
        head = head.next;
        head.prev =null;

    }
    // remove from the last 
    public void removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }
        size--;
        (tail.prev).next = null;
        tail = tail.prev;
    }

    // Reversing the doubly linked list
    public void Reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head =prev;
    }
    
    public static void main(String[] args) {
        Doubly_LL dll = new Doubly_LL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.traversalFront();
        // dll.removeFirst();
        // dll.traversalFront();
        //dll.traversalLast();
        dll.addLast(4);
        // dll.traversalFront();
        // dll.removeLast();
        // dll.traversalFront();
        dll.traversalFront();
        dll.Reverse();
        dll.traversalFront();
    }
}
