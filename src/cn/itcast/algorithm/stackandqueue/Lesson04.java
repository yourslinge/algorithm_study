package cn.itcast.algorithm.stackandqueue;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午7:38:51
 * 将栈中元素排序，可以申请另一个栈以及变量
 */
public class Lesson04 {

	public static void main(String[] args) {
		MyStack<Integer> stackPush = new MyStack<Integer>();
		MyStack<Integer> stackPop = new MyStack<Integer>();
		Lesson04 lesson = new Lesson04();
		Integer[] datas = {3,4,5,1,2};
		for (Integer data : datas) {
			stackPush.push(data);
		}
		lesson.sort(stackPush, stackPop);
		System.out.println(stackPop.toString());
	}
	public void sort(MyStack<Integer> stackPush,MyStack<Integer> stackPop){
		Integer current = 0;
		while(!stackPush.empty()){
			current = stackPush.pop();
			if(stackPop.empty()){
				stackPop.push(current);
			}else{
				pushData2StackPop(stackPush, stackPop, current);
			}
		}
	}
	
	public void pushData2StackPop(MyStack<Integer> stackPush,MyStack<Integer> stackPop,Integer current){
		int counter = 0; // 记录向stackPush栈中，压入了多少元素
		Integer stackPopData = stackPop.pop();
		// while循环有两种退出方式：①②
		while(current>stackPopData){
			stackPush.push(stackPopData);
			counter++;
			if(!stackPop.empty()){
				stackPopData = stackPop.pop();
			}else{
				break;//①当stackPop为空时
			}
		}
		//② 当current<stackPopData时
		if(current<stackPopData){
			stackPop.push(stackPopData);
		}
		stackPop.push(current);
		// 将放入stackPush中的counter个元素，再放回stackPop
		for(int i = 0;i<counter;i++){
			Integer data = stackPush.pop();
			stackPop.push(data);
		}
	}
}
