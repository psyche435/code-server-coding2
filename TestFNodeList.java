import java.util.Iterator;
class FNode<T>{
	public T info;
	public FNode<T> next;
	public FNode(T info) {
		this(info,null);
	}
	public FNode(T info,FNode<T> next) {
		this.info=info;
		this.next=next;
	}
}
class FNodeList<T> implements Iterable<T>{//使用foreach，就需要实现此接口
	private FNode<T> head;
	private FNode<T> tail;
	public void addToHead(T info) {
		head=new FNode<T>(info,head);
		if(tail==null) {
			tail=head;
		}
	}
	public void addToTail(T info) {
		if(null==tail) {
			head=new FNode<T>(info);
			tail=head;
		}else {
			tail.next=new FNode<T>(info);
			tail=tail.next;
		}
	}
	public FNode<T> deleteFromHead() {
		FNode<T> p=head;
		if(head!=null) {
			head=head.next;
			if(head==null) {
				tail=null;
			}
		}
		return p;
	}
	public FNode<T> deleteFromTail() {
		FNode<T> p=tail;
		if(tail!=null) {
			if(head==tail) {
				head=null;
				tail=null;
			}else {
				FNode<T> s=head;
				while(s.next!=tail) {
					s=s.next;
				}
				tail=s;
				tail.next=null;
			}
		}
	    return p;
	}
	public FNode<T> getByIndex(int index) {
		FNode<T> p=head;
		for(int i=1;i<index && p!=null;i++,p=p.next) {
		}
		return p;
	}
	
	/**
	 * 输出所有节点
	 */
	public void printAllInfo() {
		FNode<T> p=head;
		while(p!=null) {
			System.out.print(p.info+"  ");
			p=p.next;
		}
		System.out.println();
	}

	private class Itr implements Iterator<T>{  
		private FNode<T> p;
		public Itr() {
			p=head;//类型不匹配，不能从FNode<T> --> FNode<T>,若为Itr<T>
		}
		@Override
		public boolean hasNext() {
			return p!=null;
		}

		@Override
		public T next() {
			FNode<T> s=p;
			p=p.next;
			return s.info;
		}
	}

	@Override    //Iterable
	public Iterator<T> iterator() {
		return new Itr();
	}
}

public class TestFNodeList {
	public static void main(String[] args) {
		//测试int类型
//		FNodeList<Integer> myList = new FNodeList<>();		
//		System.out.println("测试添加元素--》头部");
//		myList.addToHead(1);
//		myList.addToHead(2);
//		myList.addToHead(3);
//		myList.addToHead(4);
//		myList.printAllInfo();
//		
//		System.out.println("测试添加元素到--》尾部");
//		myList.addToTail(9);
//		myList.addToTail(10);
//		myList.addToTail(11);
//		myList.addToTail(12);
//		myList.printAllInfo();
//	
//		System.out.println("测试从头部删除--》元素");
//		FNode<Integer> p = myList.deleteFromHead();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		p = myList.deleteFromHead();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		myList.printAllInfo();
//		
//		System.out.println("测试从尾部删除-->元素");
//		p=myList.deleteFromTail();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		p=myList.deleteFromTail();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		myList.printAllInfo();
//		
//		System.out.println("测试获取指定索引的--》值");
//		p = myList.getByIndex(2);
//		if(p!=null) {
//			System.out.println(p.info);
//		}
		
		//测试double型
//		FNodeList<Double> myList = new FNodeList<>();
//		System.out.println("测试添加元素--》头部");
//		myList.addToHead(1.2);
//		myList.addToHead(2.2);
//		myList.addToHead(3.2);
//		myList.addToHead(4.2);
//		myList.printAllInfo();
//		
//		System.out.println("测试添加元素到--》尾部");
//		myList.addToTail(9.2);
//		myList.addToTail(10.2);
//		myList.addToTail(11.2);
//		myList.addToTail(12.2);
//		myList.printAllInfo();
//	
//		System.out.println("测试从头部删除--》元素");
//		FNode<Double> p = myList.deleteFromHead();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		p = myList.deleteFromHead();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		myList.printAllInfo();
//		
//		System.out.println("测试从尾部删除-->元素");
//		p=myList.deleteFromTail();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		p=myList.deleteFromTail();
//		if(p!=null) {
//			System.out.println(p.info);
//		}
//		myList.printAllInfo();
//		
//		System.out.println("测试获取指定索引的--》值");
//		p = myList.getByIndex(2);
//		if(p!=null) {
//			System.out.println(p.info);
//		}
		
		FNodeList<Integer> myList = new FNodeList<Integer>();
		myList.addToHead(1);
		myList.addToHead(2);
		myList.addToHead(3);
		myList.addToHead(4);
	
		System.out.println("使用for-each遍历");
		for(Object in:myList) {//只能通过 java.lang.Iterable 的数组或实例进行迭代
			System.out.print(in+" ");
		}
		System.out.println();
		
		System.out.println("使用迭代器遍历");
		Iterator<Integer>  it = myList.iterator();
		while(it.hasNext()) {
			Integer in = it.next();
			System.out.print(in+" ");
		}
		System.out.println();
	}
}









