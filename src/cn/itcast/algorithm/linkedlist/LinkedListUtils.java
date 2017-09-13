package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午2:15:31
 * add2SingleList执行后，first成为头节点
 * 其他方法中，都将first赋值给另一个变量，为了不破坏链表本身的头结点，如果使用first，那么遍历
 * 或者删除后，first就不代表头结点了，那么我们的链表就不好操作了
 */
public class LinkedListUtils {

	private static Data first = null;
	// 由该段代码可以看出，由于定义了一个first=null的节点，所以生成的链表的尾部会一个空节点，
	// 就我来看，该null节点的作用，主要是在while等条件中，设置查询条件
	public static void add2SingleList(Object obj){
		Data data = new Data(obj);
		data.next = first;
		first = data;
	}
	
	public static void adjust(int num){
		if(first==null){
			System.out.println("empty lisy");
		}
		Data pre = first;
		Data cur = first.next;
		Data big_first = null;
		Data big = null;
		Data small_first = null;
		Data small = null;
		Data equal_first = null;
		Data equal = null;
		if((int)(pre.obj)>num){
			big_first = pre;//记录头结点
			big = pre;//便于插入新节点
		}else if((int)(pre.obj)<num){
			small_first = pre;//记录头结点
			small = pre;//便于插入新节点
		}else{
			equal_first = pre;//记录头结点
			equal = pre;//便于插入新节点
		}
		while(cur!=null){
			if((int)(cur.obj)>num){
				if(big==null){
					big_first = cur;
					big=cur;
				}else{
					big.next = cur;
					big = cur;
				}
			}else if((int)(cur.obj)<num){
				if(small==null){
					small_first = cur;
					small = cur;
				}else{
					small.next = cur;
					small = cur;
				}
			}else{
				if(equal==null){
					equal_first = cur;
					equal = cur;
				}else{
					equal.next = cur;
					equal = cur;
				}
			}
			cur = cur.next;
		}
		//将三个部分链接起来
		big.next=equal_first;
		equal.next = small_first;
		small.next = cur;
		
		disPlay02(big_first);
		
		
	}
	public static void adjust01(int num){
		if(first==null){
			System.out.println("empty lisy");
		}
		Data cur = first;
		Data big_first = null;
		Data big = null;
		Data small_first = null;
		Data small = null;
		Data equal_first = null;
		Data equal = null;
		
		while(cur!=null){
			if((int)(cur.obj)>num){
				if(big==null){
					big_first = cur;//记录头结点
					big=cur;//便于插入新节点
				}else{
					big.next = cur;
					big = cur;
				}
			}else if((int)(cur.obj)<num){
				if(small==null){
					small_first = cur;//记录头结点
					small = cur;//便于插入新节点
				}else{
					small.next = cur;
					small = cur;
				}
			}else{
				if(equal==null){
					equal_first = cur;//记录头结点
					equal = cur;//便于插入新节点
				}else{
					equal.next = cur;
					equal = cur;
				}
			}
			cur = cur.next;
		}
		//将三个部分链接起来
		big.next=equal_first;
		equal.next = small_first;
		small.next = cur;
		
		disPlay02(big_first);
		
		
	}
	public static void disPlay02(Data data){
		if(data == null){
			System.out.println("empty single list");
		}
		Data cur = data;
		while(cur!=null){
			System.out.print(cur.obj.toString()+"->");
			cur = cur.next;
		}
		System.out.println();
	}
	
	
	
	public static void remove(Object obj) throws Exception{
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
	
	public static boolean find(Object obj){
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
	
	public static void disPlay(){
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
	
	public static boolean isEmpty(){
		return first==null;
	}
}
