package JAVATree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 트리순회 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int firstNum = Integer.parseInt(br.readLine());

		Tree tree = new Tree();
		for(int i = 0 ; i < firstNum ; i++) {
			char[] data = new char[3];
			data = (br.readLine()).replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		
		tree.preorder(tree.root);
		bw.write("\n");
		tree.inorder(tree.root);
		bw.write("\n");
		tree.postorder(tree.root);
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class Node {
		char data;
		Node leftChild;
		Node rightChild;
		
		Node(char data){
			this.data = data;
		}
	}
	
	static class Tree {
		Node root;
		
		private void createNode(char data, char leftChild, char rightChild) {
			if(root == null) {
				root = new Node(data);
				if(leftChild != '.') {
					root.leftChild = new Node(leftChild);
				}
				if(rightChild != '.') {
					root.rightChild = new Node(rightChild);
				}
			}else {
				searchNode(root, data, leftChild, rightChild);
			}
		}
		
		private void searchNode(Node root, char data, char leftChild, char rightChild) {
			if(root == null) {
				return;
			}else if(root.data == data) {
				if(leftChild != '.') {
					root.leftChild = new Node(leftChild);
				}
				if(rightChild != '.') {
					root.rightChild = new Node(rightChild);
				}
			}else {
				searchNode(root.leftChild, data, leftChild, rightChild);
				searchNode(root.rightChild, data, leftChild, rightChild);
			}
		}
		
		public void preorder(Node root) throws IOException {
			bw.write(root.data);
			if(root.leftChild != null) {
				preorder(root.leftChild);
			}
			if(root.rightChild != null) {
				preorder(root.rightChild);
			}
		}
		
		public void inorder(Node root) throws IOException {
			if(root.leftChild != null) {
				inorder(root.leftChild);
			}
			bw.write(root.data);
			if(root.rightChild != null) {
				inorder(root.rightChild);
			}
		}
		
		public void postorder(Node root) throws IOException {
			if(root.leftChild != null) {
				postorder(root.leftChild);
			}
			if(root.rightChild != null) {
				postorder(root.rightChild);
			}
			bw.write(root.data);
		}
		
	}

}
