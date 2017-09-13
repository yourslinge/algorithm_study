package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午9:31:32
 */
public class SwapKGroup {
	
	public Data reAddNode(Data first, int k){
		if(first==null||k==1) return first;
		Data header = new Data(Integer.MIN_VALUE);
		header.next = first;
		
		Data pre = header;
		Data cur = first;
		
		int counter = 0;//用来记录是否遍历了k个节点
		while(cur!=null){
			counter++;
			if(counter%(k+1)==0){
				pre = reverse(pre, cur);
				cur = pre.next;
			}else{
				cur = cur.next;
			}
		}
		return header.next;
	}

	public Data reverse(Data pre, Data next1){
		Data last = pre.next;
		Data cur = last.next;
		int counter = 1;
		while(cur!=next1){
			last.next = cur.next;
//			cur.next = last;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}
	public static void main(String[] args) {
		SwapKGroup test = new SwapKGroup();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {7,6,5,4,3,2,1};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		Data first = test.reAddNode(s1.getFirst(),3);
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
		
//		Data first = s1.getFirst();
//		Data header = new Data(Integer.MIN_VALUE);
//		header.next = first;
//		Data pre = header;
//		Data cur = first;
//		for(int i = 1; i<3;i++){
//			cur = cur.next;
//		}
//		test.reverse(pre, cur);
	}
}
