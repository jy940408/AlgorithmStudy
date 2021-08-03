package JAVATree;

import java.util.Scanner;

public class 무한이진트리 {
	
	private static int leftRound = 0;
	private static int rightRound = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] firstLine = (scan.nextLine()).split(" ");
		int leftNode = Integer.parseInt(firstLine[0]);
		int rightNode = Integer.parseInt(firstLine[1]);
		
		rootSearch(leftNode, rightNode);
		
	}
	
	public static void rootSearch(int leftNode, int rightNode) {
		
		if(leftNode > rightNode) {
			int leftDivision = leftNode/rightNode;
			int leftRest = leftNode%rightNode;
			
			if(leftRest != 0) {
				leftNode = leftRest;
				leftRound += leftDivision;
			}else {
				leftNode = rightNode;
				leftRound += (leftDivision-1);
			}
			
			System.out.println("case1: " + leftNode + " " + rightNode + ", leftRound: " + leftRound + ", rightRound: " + rightRound);
			rootSearch(leftNode, rightNode);
		}else if(leftNode < rightNode) {
			int rightDivision = rightNode/leftNode;
			int rightRest = rightNode%leftNode;
			
			if(rightRest != 0) {
				rightNode = rightRest;
				rightRound += rightDivision;
			}else {
				rightNode = leftNode;
				rightRound += (rightDivision-1);
			}
			
			System.out.println("case2: " + leftNode + " " + rightNode + ", leftRound: " + leftRound + ", rightRound: " + rightRound);
			rootSearch(leftNode, rightNode);
		}else if(leftNode == rightNode) {
			System.out.println("case3: " + leftNode + " " + rightNode + ", leftRound: " + leftRound + ", rightRound: " + rightRound);
			System.out.println(leftRound + " " + rightRound);
		}
		
	}
	
}