package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午6:24:33
 * 给定一个链表，将该链表按照某个位置翻转，比如1->2->3->4->5->null   4->5->1->2->3->null
 */
public class RotateList {

	public Data rotate(Data first, int k){
		Data pre = first;
		int counter = 0;
		while(pre!=null){
			counter++;
			if(pre.next==null) break;//为了将null抛弃，pre直接指向5，
			pre = pre.next;
		}
		if(k<=counter){
			pre.next = first;//将链表做成环状
			for(int i = 0; i<k;i++){
				pre = pre.next;
			}
			first = pre.next;
			pre.next = null;
			return first;
		}else{
			return null;
		}
	}
	public static void main(String[] args) {
		RotateList test = new RotateList();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {5,4,3,2,1};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		Data first = test.rotate(s1.getFirst(), 3);
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
