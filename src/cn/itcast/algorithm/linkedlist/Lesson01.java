package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午2:04:25
 * LinkedList类提供了双链表的实现
 * 简单实现的单链表。链表的遍历，增加，删除，查找
 */
public class Lesson01 {

	public static void main(String[] args) throws Exception {
		int[] arr = {3,4,5,1,8,0,23,4};
		for (int data : arr) {
			LinkedListUtils.add2SingleList(data);
		}
		LinkedListUtils.disPlay();
		System.out.println("find 32?"+LinkedListUtils.find(32));
		LinkedListUtils.remove(23);
		LinkedListUtils.disPlay();
		System.out.println("empty?"+LinkedListUtils.isEmpty());
	}
}
