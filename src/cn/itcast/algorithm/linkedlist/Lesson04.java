package cn.itcast.algorithm.linkedlist;

import java.util.Stack;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月22日 上午9:15:10
 * 给定一个单链表的头结点，实现一个调整单链表的函数，使得k个节点之间逆序，不足k个节点，不做调整
 * 注意：本例申请了一个额外的存储空间栈
 * 之前程序一直出错的原因就是没有考虑使用reverse函数后，原先的first节点指向的引用发生了变化，参考reverse函数
 */
public class Lesson04 {

	public static void main(String[] args) {
		Stack<Data> stack = new Stack<Data>();
		SingleLinkedList s1 = new SingleLinkedList();
		Lesson04 lesson = new Lesson04();
		int[] arr1 = {1,2,3,4,5,6,7,8};
		for (int data : arr1) {
			s1.add2SingleList(data);
		}
		s1.disPlay();
		int numk = 3;
		Data header = lesson.getKReverse(s1.getFirst(),stack,3);
		LinkedListUtils.disPlay02(header);
	}
	
	public Data getKReverse(Data first,Stack<Data> stack,int numk){
		Data countSize = first;
		Data newFirst = null;
		Data last = null;
		int k = 0;
		while(countSize!=null){
			k++;
			countSize = countSize.next;
		}
		int size = k;
		int counter = 0;
		k = 1;
		
		while(first!=null){
			if(k == numk){
				stack.push(first);
				Data[] data = reverse(stack);
				k = 1;
				counter++;
				if(counter==1){
					newFirst = data[0];
					last = data[1];
					first = data[2];
				}else{
					last.next = data[0];
					last = data[1];
					first = data[2];
				}
				//使用完first = data[2]，此时first节点，已经是first的下一个节点的值啦，所以不需要在执行first = first.next;
				// 所以使用continue
				continue;
			}else{
				stack.push(first);
				k++;
			}
			//size加1的判断。可以仔细思考下代码流程
			// 使用continue完毕，continue后面的语句不在执行，此段if判断就不需要执行，如果没有continue，则if语句中的k=1；
			// 但是使用continue直接结束本次循环，执行下次循环，执行到else语句，使k=2；可以看出少判断了一次，所以使用size+1
			if(counter*numk+k==size+1){
				Data temp = reverse(stack, k);
				last.next = temp;
			}
			first = first.next;
		}
		
		
		return newFirst;
	}
	
	public Data[] reverse(Stack<Data> stack){
		if(stack.isEmpty()){
			return null;
		}
		Data header = stack.pop();
		Data oriFirst = header.next;//返回的是first节点的下一个节点！！
		Data last = stack.pop();
		header.next = last;
		while(!stack.isEmpty()){
			Data tmp = stack.pop();
			last.next = tmp;
			last = tmp;
		}
		last.next = null;
		//返回逆序后的部分链表的头尾节点，以及逆序前的first节点的下一个节点，要不然，程序会不断循环重复
		//比如：第一次reverse的节点为8、7、6,6为当前first节点，其下一个节点为5.逆序后为6、7、8，如果不记录下
		//排序前first节点6的next节点的位置5，逆序后，first节点的下一个节点为7，这就错误
		return new Data[]{header,last,oriFirst};
	}
	public Data reverse(Stack<Data> stack,int k){
		if(stack.isEmpty()){
			return null;
		}
		Data first = stack.pop();  //先弹栈的值就是原链表的最后一个值啦，所以不必考虑first节点的引用会改变
		first.next = null;
		while(!stack.isEmpty()){
			Data pop = stack.pop();
			pop.next = first;
			first = pop;
		}
		return first;
	}
	
}
