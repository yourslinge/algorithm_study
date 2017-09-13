package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月4日 下午6:19:11
 * 去除数组中指定的元素。，向前覆盖方法
 */
public class RemoveElement {

	public int returnLen(int[] arr,int value){
		int length = arr.length;
		int index = 0;
		for(int i=0; i<length; i++){
			if(arr[i]!=value){
				arr[index++] = arr[i];
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		RemoveElement test = new RemoveElement();
		int[] arr = {1,2,2,3,4,5,6};
		int res = test.returnLen(arr, 2);
		for(int i=0; i<res; i++){
			System.out.println(arr[i]);
		}
	}
}
