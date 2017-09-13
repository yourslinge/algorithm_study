package cn.itcast.algorithm.stackandqueue;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午6:19:18
 * 使用两个栈来实现队列
 * 注意：出栈必须全部出去；弹栈必须全部弹出
 */
public class Lesson03 {

	public static void main(String[] args) {
		MyStack<Integer> stackPush = new MyStack<Integer>();
		MyStack<Integer> stackPop = new MyStack<Integer>();
		Lesson03 lesson = new Lesson03();
		Integer[] datas = {3,4,5,1,2};
		for (Integer data : datas) {
			stackPush.push(data);
		}
		lesson.stackPush2Pop(stackPush, stackPop);
		lesson.printStackPop(stackPop);
	}
	
	public void stackPush2Pop(MyStack<Integer> stackPush,MyStack<Integer> stackPop){
		while(!stackPush.empty()){
			Integer data = stackPush.pop();
			stackPop.push(data);
		}
	}
	public void printStackPop(MyStack<Integer> stackPop){
		while(!stackPop.empty()){
			System.out.print(stackPop.pop()+",");
		}
	}
	
	
}
