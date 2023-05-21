public class LL_Merge_sort{
    private int size;
    LL_Merge_sort(){
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
    
    
    //merge sort
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }
    public Node getMid(Node head){
        Node hare = head.next;
        Node turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
    
    public Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1= head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2= head2.next;
                temp =temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1= head1.next;
            temp= temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2= head2.next;
            temp= temp.next;
        }
        return mergedLL.next;
    }
    public static void main(String[] args) {
        LL_Merge_sort list = new LL_Merge_sort();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(1);
        list.insertFirst(2);
        list.traversal();
        list.head=list.mergeSort(head);
        list.traversal();
}
}