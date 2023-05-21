public class LL_insertion{
    // Node definition
    static class Node{
        int  data;
        Node next;
        Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    private int size;
    public static Node head = null;         //head of the Linked list
    LL_insertion(){
        size=0;
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

    //Insertion at the last node
    public void insertLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!= null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //insert the element with given index
    public void insertAtIndex(int idx, int data){
        size++;
        if(idx == 0){
            insertFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int prevIdx=0;
        while(prevIdx < idx-1){
            temp = temp.next;
            prevIdx++;
        }
        newNode.next =temp.next;
        temp.next = newNode;
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
    
    
    // Size of the Linked list
    public void getSize(){
        System.out.println(size);
    }
    
    public static void main(String[] args) {
        LL_insertion list = new LL_insertion();
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(4);
        list.insertAtIndex(2, 3);
        list.traversal();
        System.out.print("The size of the linked list: ");
        list.getSize();
}
}