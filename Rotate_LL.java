public class Rotate_LL {
    private int size;
    Rotate_LL(){
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
    private Node rotate(){
        Node currNode = head;
        Node prev =null;
        while(currNode.next != null){
            prev = currNode;
            currNode = currNode.next;
        }
        prev.next = null;
        currNode.next =head;
        head= currNode;
        return head;
    }
    public void rotateKtimes(int k){
        if(head == null || head.next == null){
            return;
        }
        if(k>=size){
            k=k%size;
        }
        int i=0;
        while(i<k){
            head= rotate();
            i++;
        }
    }
    public static void main(String[] args) {
        Rotate_LL list = new Rotate_LL();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.traversal();
        list.rotateKtimes(2);
        list.traversal();
    }
}
