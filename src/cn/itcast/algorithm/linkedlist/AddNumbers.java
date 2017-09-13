package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午2:13:13
 * 类似cn.itcast.algorithm.string.AddBinary
 * 两个链表存储的是一个整数的每位数的逆序，将两个链表中的值相加。
 * 比如 2->4->3
 *    5->6->4
 * 结果7->0->8
 */
public class AddNumbers {
	
	public Data addTwo(Data first1,Data first2){
		if(first1==null||first2==null) return null;
		Data first = null;
		Data newFirst = null;//记录新的头结点
		int counter = 0;
		int carry = 0;//进位
		while(first1!=null){
			if(first2!=null){
				int value = ((int)first1.obj+(int)first2.obj+carry)%10;
				carry = ((int)first1.obj+(int)first2.obj+carry)/10;
				if(counter++==0){
					newFirst = new Data(value);
					first = newFirst;
				}else{
					Data data = new Data(value);
					first.next = data;
					first = data;
				}
				first2 = first2.next;
			}else{
				int value = ((int)first1.obj+carry)%10;
				carry = ((int)first1.obj+carry)/10;
				Data data = new Data(value);
				first.next = data;
				first = data;
			}
			first1 = first1.next;
		}
		while(first2!=null){
			int value = ((int)first2.obj+carry)%10;
			carry = ((int)first2.obj+carry)/10;
			Data data = new Data(value);
			first.next = data;
			first = data;
			first2 = first2.next;
		}
		if(carry>0){
			Data data = new Data(carry);
			first.next = data;
			first = data;
		}
		return newFirst;
	}
	//在for循环中，同时控制两个链表，也就是控制两个条件
	public Data addTwo01(Data first1,Data first2){
		if(first1==null||first2==null) return null;
		Data header = new Data(-1);
		Data pre = header;
		int carry = 0;
		for(Data pa = first1,pb = first2;
				pa!=null||pa!=null;
				pa = pa==null?null:pa.next,pb = pb==null?null:pb.next,pre = pre.next){
			int ai = pa==null?0:(int)pa.obj;
			int bi = pb==null?0:(int)pb.obj;
			int val = (ai+bi+carry)%10;
			carry = (ai+bi+carry)/10;
			pre.next = new Data(val);//尾插法
		}
		if(carry>0){
			pre.next = new Data(carry);
		}
		return header.next;
	}
	

	public static void main(String[] args) {
		SingleLinkedList s1 = new SingleLinkedList();
		SingleLinkedList s2 = new SingleLinkedList();
		AddNumbers lesson = new AddNumbers();
		int[] arr1 = {4,6,5};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		int[] arr2 = {3,4,2};
		for (int data : arr2) {
			s2.add2SingleList(data);
		}
		s2.disPlay();
		Data first = lesson.addTwo01(s1.getFirst(), s2.getFirst());
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
