package cn.itcast.algorithm.stackandqueue;

import java.util.LinkedList;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月20日 下午4:51:11
 */
public class MyStack<T> {

	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T t){
		storage.addFirst(t);
	}
	public T pop(){
		return storage.removeFirst();
	}
	public T peek(){
		return storage.getFirst();
	}
	
	public boolean empty(){
		return storage.isEmpty();
	}
	
	public String toString(){
		return storage.toString();
	}
	
}
