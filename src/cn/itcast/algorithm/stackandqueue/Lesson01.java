package cn.itcast.algorithm.stackandqueue;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午4:48:08
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的方法getMin
 * 要求：push、pop、getMin方法的时间复杂度为O(1)
 *      设计栈类型可以使用现成的栈结构
 * 思路：要想getMin()方法的时间复杂度为O(N)，那么只要在压栈的时候，有序就可以了
 */
public class Lesson01 {

	static MyStack<Integer> oriStack = new MyStack<Integer>();
	static MyStack<Integer> minStack = new MyStack<Integer>();
	public static void main(String[] args) {
		Lesson01 lesson = new Lesson01();
		Integer[] datas = {3,4,5,1,2,1};
		for (Integer data : datas) {
			lesson.putDatas(oriStack,minStack,data);
		}
		System.out.println(lesson.getMin());
	}
	
	public void putDatas(MyStack<Integer> oriStack,MyStack<Integer> minStack,Integer data){
		oriStack.push(data);
//		if(minStack.peek()==null){
//			minStack.push(data);
//		}else if(data<=minStack.peek()){
//			minStack.push(data);
//		}
		try{
			Integer topData = minStack.peek();
			if(data<=topData){
				minStack.push(data);
			}
			
		}catch (Exception e){
			minStack.push(data);
		}
	}
	
	public Integer getMin(){
		Integer oriNum = oriStack.peek();
		Integer minNum = minStack.peek();
		
		return oriNum>=minNum?minNum:oriNum;
	}
}
