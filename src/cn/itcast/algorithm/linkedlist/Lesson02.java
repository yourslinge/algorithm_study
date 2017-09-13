package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午3:44:54
 * 给定一个链表以及一个数值num，要求大于num的排左边，等于num排中间，小于num的排右边
 * 思路：
 *   1.申请一个数据结构-数组，将链表中的元素放入数组，在数组中排序后，再放回链表。
 *   2.不申请额外的空间，现将链表分成3个小链表，一个链表存储大于num的数，一个存储等于num，一个存储小于num，然后再
 *   将这三个链表链接在一起。
 */
public class Lesson02 {

	
	
	public static void main(String[] args) {
		int[] arr = {3,4,5,1,8,0,23,4};
		for (int data : arr) {
			LinkedListUtils.add2SingleList(data);
		}
		LinkedListUtils.disPlay();
		//方法一：不需要申请额外的空间
		//LinkedListUtils.adjust(4);
		LinkedListUtils.adjust01(4);
		//方法二：申请一个额外的空间：数组
		
	}
}
