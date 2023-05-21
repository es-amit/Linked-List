public class LL_RemoveCycle{
    private int size;
    LL_RemoveCycle(){
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
    
    
    // remove the cycle in the linked list
    public void removeCycle(){
        //detect cycle
        Node hare = head;
        Node turtle = head;
        boolean cycle = false;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare == turtle){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //meeting point
        turtle = head;
        Node prev = null;
        while(turtle != hare){
            prev = hare; 
            turtle = turtle.next;
            hare = hare.next;
        }
        // removing cycle
        prev.next= null;
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
    public void zig_zag(){
        if(head == null || head.next ==null){
            return;
        }
        //find mid
        Node hare = head.next;
        Node turtle = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        Node mid = turtle;
        //second half reverse

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;

        Node nextN;
        while(curr != null){
            nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr= nextN;
        }

        // alternate merging
        Node Left = head;
        Node Right = prev;
        Node nextL, nextR;
        while(Left != null && Right != null){
            nextL = Left.next;
            Left.next = Right;
            nextR = Right.next;
            Right.next = nextL;
            Left =nextL;
            Right = nextR;
        }
    }
    // Instersection of two Linked list
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.traversal();
        // list.deleteLast();
        // list.traversal();
        // list.getSize();
        //list.head=list.reverseRecursive(list.head);
        //list.traversal();
        // list.addinMiddle(3,"Linked");
        // list.traversal();
        // System.out.println(list.searchiterative("amit"));
 //       System.out.println(Search_rec("amit"));
        // LL.head= list.mergeSort(LL.head);
        // list.traversal();
        list.zig_zag();
        list.traversal();
}
}