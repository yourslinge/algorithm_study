package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午7:33:01
 */
public class SingleLinkedList {
	private Data first = null;
	// 又该段代码可以看出，由于定义了一个first=null的节点，所以生成的链表的尾部会一个空节点，
	// 就我来看，该null节点的作用，主要是在while等条件中，设置查询条件
	public void add2SingleList(Object obj){
		Data data = new Data(obj);
		data.next = first;
		first = data;
	}
	public void remove(Object obj) throws Exception{
		if(first==null){
			throw new Exception("the single list is empty");
		}
		if(first.obj.equals(obj)){
			// 将当前first节点的下一个节点(first.next) 指定为first节点
			first = first.next;
		}else{
			Data pre = first;
			Data cur = first.next;
			while(cur!=null){
				if(cur.obj.equals(obj)){
					pre.next = cur.next;
				}
				pre = cur;
				cur = cur.next;
			}
		}
	}
	
	public boolean find(Object obj){
		if(first == null){
			return false;
		}
		Data cur = first;
		while(cur!=null){
			if(cur.obj.equals(obj)){
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public void disPlay(){
		if(first == null){
			System.out.println("empty single list");
		}
		Data cur = first;
		while(cur!=null){
			System.out.print(cur.obj.toString()+"->");
			cur = cur.next;
		}
		System.out.println();
	}
	
	
	public boolean isEmpty(){
		return first==null;
	}
	public Data getFirst() {
		return first;
	}
	
}
