package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午7:01:03
 * 从链表末尾开始，删除第n的元素，比如：从链表末尾，删除第2个节点，第二个节点为4
 * 比如1->2->3->4->5->null 变成  1->2->3->5->null
 *
 */
public class RemoveNodeFromEnd {
	
	public Data removeNthNode(Data first, int n){
		Data pre = first;
		Data cur = first;
		for(int i = 0; i<n; i++){ // cur先走n步
			cur = cur.next;  
		}
		while(cur!=null){ //pre和cur一起走
			if(cur.next==null) break;// 为了使cur指向最后节点5，而不是null所做的设置
			pre = pre.next;
			cur = cur.next;
		}
		pre.next = cur;
		return first;
	}

	public static void main(String[] args) {
		RemoveNodeFromEnd test = new RemoveNodeFromEnd();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {5,4,3,2,1};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		Data first = test.removeNthNode(s1.getFirst(), 2);
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
