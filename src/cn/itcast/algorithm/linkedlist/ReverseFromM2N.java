package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月11日 上午10:32:33
 * 将链表中m-n之间的节点做逆序，重点在reverse函数，
 */
public class ReverseFromM2N {
	
	public Data reverseFromM2N(Data first,int m, int n){
		Data header = new Data(-1);
		header.next = first;
		Data cur = first;
		Data pre = null;
		//注意假如m=1呢？那么你就需要添加一个辅助的头结点header来解决了，一般来说，涉及逆序操作，都可以引入一个头节点
		if(m==1){
			pre = header;
		}
		for(int i = 1;i<=n;i++){
			if(i==m-1){
				pre = cur;
			}
			cur = cur.next;
		}
		//当n等于链表的长度的时候，是可以正常使用的，因为这时，cur指向null节点
		reverse(pre, cur);//这里的pre是第m-1个节点，cur是第n+1个节点。
		return header.next;
	}
	//将pre和next1之间的部分进行逆序，不包括pre和next1所指向的节点
	//具体流程如下：
	//  将last所指向节点的后面的节点，按顺序插入pre所指向的节点后方
	public void reverse(Data pre,Data next1){
		Data last = pre.next;
		Data cur = last.next;
		while(cur!=next1){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
//		return last;
	}
	
	public static void main(String[] args) {
		ReverseFromM2N test = new ReverseFromM2N();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {6,5,4,3,2,1};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		Data first = test.reverseFromM2N(s1.getFirst(),1,6);
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
