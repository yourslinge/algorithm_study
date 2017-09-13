package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午7:22:12
 * 打印两个有序链表的公共部分
 */
public class Lesson03 {

	public static void main(String[] args) {
		SingleLinkedList s1 = new SingleLinkedList();
		SingleLinkedList s2 = new SingleLinkedList();
		Lesson03 lesson = new Lesson03();
		int[] arr1 = {3,4,5,8,23};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		int[] arr2 = {2,4,9,13,23};
		for (int data : arr2) {
			s2.add2SingleList(data);
		}
		s2.disPlay();
		lesson.union(s1.getFirst(), s2.getFirst());
	}
	public void union(Data first,Data second){
		if(first==null||second==null){
			System.out.println("no union section");
			return;
		}
//		while(first!=null){
//			while(second!=null){
//				if(first.obj.equals(second.obj)){
//					System.out.print(first.obj.toString()+",");
//					second = second.next;
//					break;
//				}else if((int)first.obj>(int)second.obj){
//					break;
//					
//				}else{
//					second = second.next;
//				}
//			}
//			if(second == null) break;
//			first = first.next;
//		}
		while(first!=null){
			if(first.obj.equals(second.obj)){
				System.out.print(first.obj.toString()+",");
				first = first.next;
				second = second.next;
			}else{
				if(second==null||first==null){
					break;
				}
				first = first.next;
				second = second.next;
			}
		}
		
		
	}
	
}
