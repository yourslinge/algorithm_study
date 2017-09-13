package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 下午7:26:13
 */
public class SwapPairNodes {

	public Data swapNodesInPair(Data first){
		if(first==null) return null;
		Data pre = first;
		Data newFirst = null;
		Data cur = null;
		Data last = null;// 保存每次元素翻转后的最后一个元素
		if(pre.next!=null){
			cur = pre.next;
		}else{
			return first;
		}
		int counter = 0;
		// 上述是判断是否有两个节点
		while(cur!=null){
			if(counter++==0){
				newFirst = cur;
				//交换两个节点的位置
				pre.next = cur.next;
				cur.next = pre;
				last = pre;
			}else{
				last.next = cur; //将相邻两次翻转的 通过last连接起来
				//交换两个节点的位置
				pre.next = cur.next;
				cur.next = pre;
				last = pre;
			}
			//重新赋予pre、cur
			pre = pre.next;
			if(pre==null) break;
			cur = pre.next;
		}
		return newFirst;
	}
	public static void main(String[] args) {
		SwapPairNodes test = new SwapPairNodes();
		SingleLinkedList s1 = new SingleLinkedList();
		int[] arr1 = {6,5,4,3,2,1};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		Data first = test.swapNodesInPair(s1.getFirst());
		while(first!=null){
			System.out.print(first.obj.toString()+"->");
			first = first.next;
		}
	}
}
