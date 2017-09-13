package cn.itcast.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月1日 下午8:06:09
 */
public class PrintTreeNode {

	private static int[] arr = {1,2,3,4,5,6,7,8,9};
	private static List<TreeNode> list = null;
	private static class TreeNode{
		int data;
		TreeNode leftChild;
		TreeNode rightChild;
		public TreeNode(int newData){
			this.data = newData;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public static void createBinaryTree(int[] arr){
		list = new LinkedList<TreeNode>();
		for(int i = 0;i < arr.length;i++){
			list.add(new TreeNode(arr[i]));
		}
		for(int parentIndex = 0;parentIndex<list.size()/2 -1;parentIndex++){
			list.get(parentIndex).leftChild = list.get(parentIndex*2+1);
			list.get(parentIndex).rightChild = list.get(parentIndex*2+2);
		}
		
		int lastParentIndex = list.size()/2 - 1;
		list.get(lastParentIndex).leftChild = list.get(lastParentIndex*2 + 1);
		if(list.size() % 2 == 1){
			list.get(lastParentIndex).rightChild = list.get(lastParentIndex*2 + 2);
		}
	}
	/**
	* 1.初始化时，last=1，把1放入队列；
	* 2.将1出队，把1的子孩子2,3放入队列，更新nlast=3；
	* 3.nlast更新完之后，打印上一次出队的1，并和last比较，如果相同就打印换行，并更新last=nlast=3;
	* 4.将2出队，把2的子孩子4放入队列，更新nlast=4;
	* 5,nlast更新完以后，打印上一次出队的2，并和last（3）比较，不相同，continue；
	* 6.将3出队，将3的子孩子5，6放入队列，更新nlast=6;
	* 7.nlast更新完以后，打印上一次出队的3，并和last（3）比较， 相同就打印换行，并更新last=nlast=6;
	*/
	// 本题出现节点值重复的时候，就不适用了
	public static void printTreeNode(TreeNode root){
		int last = 0;
		int nlast = 0;
		if(root == null){
			System.out.println("empty tree!");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		last = root.data;
		while(queue.isEmpty() == false){
			TreeNode node = queue.poll();
			
			if(node.leftChild!=null){
				queue.offer(node.leftChild);
				nlast = node.leftChild.data;
			}
			if(node.rightChild!=null){
				queue.offer(node.rightChild);
				nlast = node.rightChild.data;
				
			}
			System.out.print(node.data+" ");
			if(last == node.data){
				System.out.println();
				last = nlast;
			}
		}
		
	}
	// 每遍历一层，就换行
	public static void printTreeNode01(TreeNode root){
		if(root == null){
			System.out.println("empty tree!");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		//TreeNode node = root;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size;i++){
				TreeNode node = queue.poll();
				if(node.leftChild!=null){
					queue.offer(node.leftChild);
				}
				if(node.rightChild!=null){
					queue.offer(node.rightChild);
				}
				System.out.print(node.data+" ");
			}
			System.out.println();
		}
	}
	public static void printTreeNode02(TreeNode root){
		if(root == null){
			System.out.println("empty tree!");
			return;
		}
		StringBuilder sbTotal = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<size;i++){
				TreeNode node = queue.poll();
				if(node.leftChild!=null){
					queue.offer(node.leftChild);
				}
				if(node.rightChild!=null){
					queue.offer(node.rightChild);
				}
				sb.append(node.data+" ");
			}
			if(count%2==1){
				sb.reverse();
			}
			count++;
			sbTotal.append(sb+"\n");
		}
		System.out.println(sbTotal.toString());
	}
	
	
	public static void main(String[] args) {
		createBinaryTree(arr);
		TreeNode root = list.get(0);
		printTreeNode02(root);
		
	}
}
