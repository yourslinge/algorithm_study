package cn.itcast.algorithm.stackandqueue;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午7:21:02
 * 实现一个栈的逆序，要求只能使用递归和这个栈本身，不能使用其他的数据结构
 */
public class Lesson02 {

	public static void main(String[] args) {
		MyStack<Integer> stackPush = new MyStack<Integer>();
		Lesson02 lesson = new Lesson02();
		Integer[] datas = {3,4,5,1,2};
		for (Integer data : datas) {
			stackPush.push(data);
		}
		//System.out.println(lesson.get(stackPush));
		lesson.reverse(stackPush);
		System.out.println(stackPush.toString());
	}
	
	//移除栈底元素并返回
	public Integer get(MyStack<Integer> stackPush){
		Integer result = stackPush.pop();
		if(stackPush.empty()){
			return result;
		}else{
			int last = get(stackPush);
			stackPush.push(result);
			return last;
		}
	}
	
	public void reverse(MyStack<Integer> stackPush){
		if(stackPush.empty()){
			return;
		}
		Integer result = get(stackPush);
		reverse(stackPush);
		stackPush.push(result);
	}
	
	
}
