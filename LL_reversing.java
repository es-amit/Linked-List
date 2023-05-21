public class LL_reversing{
    private int size;
    LL_reversing(){
        size=0;
    }
    public static Node head = null;
    static class Node{
        int  data;
        Node next;
        Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    //Insertion at the first node
    public void insertFirst(int data){
        size++;
        Node newNode =new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

     //Traversal of list
     public void traversal(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next; 
        }
        System.out.println("NULL");
    }
    
    // reversing the linked list in iterative version
    public void reverseIterator(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode= head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next=prevNode;
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next= null;
        head = prevNode;
    }

    // reverse the linke list in recursive version
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newhead= reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    
    public static void main(String[] args) {
        LL_reversing list = new LL_reversing();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.traversal();
        list.head = list.reverseRecursive(head);        //Recursive approach
        list.traversal();
        list.reverseIterator();                         //Iterative approach
        list.traversal();

}
}