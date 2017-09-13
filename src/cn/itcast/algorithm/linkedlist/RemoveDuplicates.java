package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午3:31:18
 * 将已经排序的链表中的重复元素，只保留一个，比如5、5、5、6、6、7->5、6、7
 * 思路：定义两个指针，一个指针移动元素cur、一个指针链接元素pre
 *   pre         pre     pre
 *    5   5   5   6   6   7   
 *               cur     cur 
 */
public class RemoveDuplicates {
	// 重复的元素只保留一个
	public Data removeDupli(Data first){
		if(first==null) return null;
		Data pre = first;
		Data cur = first.next;
		while(cur!=null){
			if(pre.obj.equals(cur.obj)){
				cur = cur.next;
			}else{
				pre.next = cur;
				pre = cur;
				cur = cur.next;
			}
		}
		return first;
	}
	// 另一种需求：将重复的元素都删除
	public Data removeDupliAll(Data first){
		if(first==null) return null;
		Data newFirst = null;
		Data pre = first;
		Data cur = first.next;
		int counter = 0;
		while(cur!=null){
			if(pre.obj.equals(cur.obj)){
				cur = cur.next;
			}else{
				pre = cur;
				cur = cur.next;
				if(cur==null){//考虑555667这一情况
					if(counter++==0) newFirst = pre;
				}else{
					if((int)pre.obj!=(int)cur.obj&&counter++==0){//为了确定新的链表中的头结点
						newFirst = pre;
					}
				}
			}
		}
		return newFirst;
	}
	
	public static void main(String[] args) {
		RemoveDuplicates test = new RemoveDuplicates();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {7,6,5,5,5};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
//		Data first = test.removeDupli(s1.getFirst());
//		while(first!=null){
//			System.out.print(first.obj.toString()+"->");
//			first = first.next;
//		}
		Data first = test.removeDupliAll(s1.getFirst());
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
