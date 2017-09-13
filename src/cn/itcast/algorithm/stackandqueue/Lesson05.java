package cn.itcast.algorithm.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午9:04:38
 * 要求:定义一个数组，设置窗口长度为3，每次向右滑动一个数据的距离，求每个窗口中的最大值;
 * 	  时间复杂度为O(n)
 * 思路：一般来说用其他的方式实现，必须使用两个数据结构，复杂度为O(n*n)
 *   本题定义一个双端队列，deque={}；初始为空，存储数组下标的值
 *   1.当i=0时，deque为空，直接将i=0，添加到队列头部
 *   2.依次取数组下标i，取出队列尾部的值j，判断：如果arr[j]>arr[i],则将i放入队列尾部；
 *    如果arr[j]<=arr[i],从队列尾部中移除j，再取队列尾部值j,直到从队列中取出一个值所对应
 *    的数组值大于arr[i],将i放入队列；或者队列为空时，直接将i放入队列
 *   3.由于窗口大小w=3,所以当队列头部取值为i-w时，当前头部的值过期，从队列中移除该值 
 * 
 */
public class Lesson05 {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<Integer>();
		Lesson05 lesson = new Lesson05();
		Integer[] arr = {4,3,5,4,3,3,6,7};
		for(int i = 0;i<arr.length;i++){
			lesson.get(deque, arr, i);
		}
	}
	
	public void get(Deque<Integer> deque,Integer[] arr,int i){
		if(deque.isEmpty()){
			deque.addFirst(i);
			return;
		}
		Integer j = deque.getLast();
		if(arr[j]>arr[i]){
			deque.addLast(i);
		}else{
			while(!deque.isEmpty()){
				if(arr[j]>arr[i]){
					deque.addLast(i);
					break;
				}else{
					deque.removeLast();
				}
				if(deque.isEmpty()){
					deque.addLast(i);
					break;
				}else{
					j = deque.getLast();
				}
			}
		}
		if(!deque.isEmpty()&&deque.getFirst()==i-3){
			deque.removeFirst();
		}
		if(i>=2&&!deque.isEmpty()){
			System.out.print(arr[deque.getFirst()]+",");
		}
	}
	
}
