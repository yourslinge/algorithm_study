package cn.itcast.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月1日 下午4:42:05
 * 创建一个二叉树，并使用先序(深度优先遍历)、中序、后序、层次(广度优先遍历)遍历二叉树
 * 先中后遍历指的是D所在位置，DLR：先序遍历，LDR：中序遍历，LRD：后序遍历
 * 层次遍历：指的是顺序遍历每一层，每一层从左到右的顺序遍历
 */
public class BinaryTree {

	private static int[] arr = {1,2,3,4,5,6,7,8,9};
	private static List<TreeNode> list = null;
	
	private static class TreeNode{
		int data; //值
		TreeNode leftChild; //左孩子
		TreeNode rightChild;//右孩子
		public TreeNode(int newData){
			this.data = newData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	
	// 创建一个二叉树
	public static void createBinTree(int[] arr){
		list = new LinkedList<TreeNode>();
		//将数组中的每个元素转化为node节点的值
		for(int i = 0;i < arr.length;i++){
			list.add(new TreeNode(arr[i]));
		}
		//构造树
		for(int parentIndex = 0;parentIndex< list.size()/2 -1; parentIndex++){
			//leftChild
			list.get(parentIndex).leftChild = list.get(parentIndex*2+1);
			// rightChild
			list.get(parentIndex).rightChild = list.get(parentIndex*2+2);
		}
		 // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
		int lastParentIndex = list.size()/2 -1;
		list.get(lastParentIndex).leftChild = list.get(lastParentIndex*2+1);
		// 右孩子,如果数组的长度为奇数才建立右孩子  
		if(list.size() % 2 == 1){
			list.get(lastParentIndex).rightChild = list.get(lastParentIndex*2+2);
		}
		
	}
	/**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
	
	public static void depthOrderTraversal(TreeNode root){
		if(root==null){
	        System.out.println("empty tree");
	        return;
	    }       
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(stack.isEmpty()==false){
			TreeNode node = stack.pop();
			System.out.print(node.data+" ");
			//注意顺序，先将右孩子压栈
			if(node.rightChild!=null){
				stack.push(node.rightChild);
			}
			if(node.leftChild!=null){
				stack.push(node.leftChild);
			}
		}
		System.out.println();
	}
	/**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
	public static void levelOrderTraversal(TreeNode root){
		if(root==null){
	        System.out.println("empty tree");
	        return;
	    }   
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(queue.isEmpty() == false){
			TreeNode node = queue.poll();
			System.out.print(node.data+" ");
			if(node.leftChild!=null){
				queue.offer(node.leftChild);
			}
			if(node.rightChild!=null){
				queue.offer(node.rightChild);
			}
		}
		System.out.println();
	}
	/**
     * 先序遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
	public static void preOrderTraversal(TreeNode root){
		if(root==null){
	        System.out.println("empty tree");
	        return;
	    }   
		Stack<TreeNode> stack = new Stack<TreeNode>();
//		stack.push(root);
//		while(stack.isEmpty() == false){
//			TreeNode node = stack.pop();
//			System.out.print(node.data+" ");
//			if(node.rightChild!=null){
//				stack.push(node.rightChild);
//			}
//			if(node.leftChild!=null){
//				stack.push(node.leftChild);
//			}
//		}
		TreeNode node = root;
		while(node!=null || stack.isEmpty() == false){
			while(node!=null){
				System.out.print(node.data+" ");
				stack.push(node);
				node = node.leftChild;
			}
			node = stack.pop();
			node = node.rightChild;
			
		}
		System.out.println();
	}
	/**
	 * 先序遍历
	 * 采用递归实现
	 */
	public static void preOrderTraversal_recursion(TreeNode root){
		if(root==null){
			return;
		}   
		System.out.print(root.data+" ");
		preOrderTraversal_recursion(root.leftChild);
		preOrderTraversal_recursion(root.rightChild);
	}
	
	/**
	 * 中序遍历
	 * 采用递归实现
	 */
	public static void middleOrderTraversal_recursion(TreeNode root){
		if(root==null){
			return;
		}   
		middleOrderTraversal_recursion(root.leftChild);
		System.out.print(root.data+" ");
		middleOrderTraversal_recursion(root.rightChild);
	}
	/**
	 * 中序遍历
	 * 采用非递归实现
	 * 需要辅助数据结构：栈
	 */
	public static void middleOrderTraversal(TreeNode root){
		if(root==null){
			System.out.println("empty tree");
			return;
		}   
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node!=null || stack.isEmpty() == false){
//			if(node!=null){
//				stack.push(node);
//				node = node.leftChild;
//			}else{
//				TreeNode nodePop = stack.pop();
//				System.out.print(nodePop.data+" ");
//				node = nodePop.rightChild;
//			}
			while(node!=null){
				stack.push(node);
				node = node.leftChild;
			}
			
			node = stack.pop();
			System.out.print(node.data+" ");
			node = node.rightChild;
			
		}
		System.out.println();
	}
	/**
	 * 后序遍历
	 * 采用递归实现
	 */
	public static void lastOrderTraversal_recursion(TreeNode root){
		if(root==null){
			return;
		}   
		lastOrderTraversal_recursion(root.leftChild);
		lastOrderTraversal_recursion(root.rightChild);
		System.out.print(root.data+" ");
	}
	/**
	 * 后序遍历
	 * 采用非递归实现
	 * 需要辅助数据结构：栈
	 */
	public static void lastOrderTraversal(TreeNode root){
		if(root==null){
			System.out.println("empty tree");
			return;
		}   
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//输出数据
		Stack<TreeNode> outputStack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node!=null || stack.isEmpty() == false){
			if(node!=null){
				outputStack.push(node);
				stack.push(node);
				node = node.rightChild;
			}else{
				node = stack.pop();
				node = node.leftChild;
			}
		}
		while(outputStack.isEmpty() == false){
			System.out.print(outputStack.pop().data+" ");
		}
		System.out.println();
	}
	
	
	
	
	
	public static void main(String[] args) {
		createBinTree(arr);
		TreeNode root = list.get(0);
		//depthOrderTraversal(root);
		//levelOrderTraversal(root);
//		preOrderTraversal(root);
		//preOrderTraversal_recursion(root);
//		middleOrderTraversal(root);
//		middleOrderTraversal_recursion(root);
		
//		lastOrderTraversal_recursion(root);
		lastOrderTraversal(root);
	}
	
	
	
}
