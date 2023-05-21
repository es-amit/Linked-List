public class LL_Deletion{
    private int size;
    LL_Deletion(){
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
    
    //Deletion of the first node
    public void deleteFirst(){
        if(head == null){
            System.out.println("cannot delete");
            return;
        }
        size--;
        head = head.next;
    }

    //Deletion of the last node
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node currNode = head;
        while((currNode.next).next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }
    // Size of the Linked list
    public void getSize(){
        System.out.println(size);
    }
    
    public static void main(String[] args) {
        LL_Deletion list = new LL_Deletion();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.traversal();
        list.deleteFirst();
        list.traversal();
        list.deleteLast();
        list.traversal();
}
}