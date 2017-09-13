package cn.itcast.algorithm.linkedlist;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月21日 下午2:12:20
 */
public class Data {
	//值
	public Object obj;
	//指针
	public Data next = null;
	public Data() {}
	
	public Data(Object obj) {
		this.obj = obj;
	}

	public Data(Object obj, Data next) {
		this.obj = obj;
		this.next = next;
	}
	
}
