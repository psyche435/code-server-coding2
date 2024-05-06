class Application{
    public static void main(String[] args)
    {
        Mylist<Integer>lst = new Mylist<Integer>();
        lst.append(1);
        lst.append(2);
        lst.append(3);
        for(int i=0;i<lst.length();i++){
            System.out.println(lst.get(i));
        }
    }
}
public class Mylist<T>{
    private Node head;
    private int N;
    class Node{
        T item;
        Node next;
        public Node(T item,Node next)
        {
            this.item=item;
            this.next=next;
        }
        public Node() {};
    }
    public Mylist()
    {
        this.head=new Node();
        this.N=0;
    }
    public void clear()
    {
        this.head=null;
        this.N=0;
    }
    public boolean isEmpty()
    {
        return this.N==0;
    }
    public void append(T t)
    {
        Node last=head;
        while(last.next!=null)
        {
            last=last.next;
        }
        Node now=new Node(t,null);
        last.next=now;
        this.N++;
    }
    public int length()
    {
        return this.N;
    } 
    public T get(int i)
    {
        Node node=head;
        for(int j=0;j<=i;j++)
        {
            node=node.next;
        }
        return node.item;
    }
}
