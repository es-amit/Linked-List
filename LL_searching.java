public class LL_searching{
    private int size;
    LL_searching(){
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


    // searching iterative
    public int searchiterative(int data){
        if(head == null){
            return -1;
        }
        int idx=0;
        Node currNode = head;
        while(currNode != null){
            if(currNode.data == data){
                return idx;
            }
            idx++;
            currNode = currNode.next;
        }
        return -1;
    }


    //searching recursive
    public static int Search_rec(int data){
        return helper(head,data);
    }
    public static int helper(Node currNode, int data){
        if(currNode == null){
            return -1;
        }
        if(currNode.data == data){
            return 0;
        }
        int i= helper(currNode.next, data);
        if(i == -1){
            return -1;
        }
        return i+1;
    }
    
    
    public static void main(String[] args) {
        LL_searching list = new LL_searching();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.traversal();
        int val =3;
        System.out.println("Found at index: "+list.searchiterative(val));   //iterative 
        System.out.println("Found at index: "+list.Search_rec(val));        //recursive
        
}
}