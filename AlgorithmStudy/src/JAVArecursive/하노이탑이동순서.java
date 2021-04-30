package JAVArecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 하노이탑이동순서 {

	public static int count(int blockNum, ArrayList firstP, ArrayList secondP, ArrayList thirdP) {
		int result = 0;
		
		System.out.println("블록 갯수: " + blockNum);
		System.out.println("첫번째 칸 갯수: " + firstP.size());
		System.out.println("두번째 칸 갯수: " + secondP.size());
		System.out.println("세번째 칸 갯수: " + thirdP.size());
		System.out.println("첫번째 칸 블록 목록: " + firstP);
		System.out.println("두번째 칸 블록 목록: " + secondP);
		System.out.println("세번째 칸 블록 목록: " + thirdP);
		
		if(firstP.size() == 0 && secondP.size() == 0) {
			System.out.println("최종 성공!");
		}else if(firstP.size() == 0 && thirdP.size() == 0) {
			
		}else if(secondP.size() == 0 && thirdP.size() == 0) {
			secondP.add(firstP.get(firstP.size()-1));
			firstP.remove((firstP.size()-1));
			count(blockNum, firstP, secondP, thirdP);
		}else if(firstP.size() == 0) {
			
		}else if(secondP.size() == 0) {
			if((int)(firstP.get(firstP.size()-1)) == blockNum){
				secondP.add(firstP.get(firstP.size()-1));
				firstP.remove((firstP.size()-1));
				count(blockNum, firstP, secondP, thirdP);
			}
		}else if(thirdP.size() == 0) {
			if((int)(secondP.get(secondP.size()-1)) == blockNum) {
				thirdP.add(secondP.get(secondP.size()-1));
				secondP.remove((secondP.size()-1));
				count(blockNum, firstP, secondP, thirdP);
			}else if(firstP.size() == 1) {
				if((int)(firstP.get(firstP.size()-1)) == blockNum){
					thirdP.add(firstP.get(firstP.size()-1));
					firstP.remove((firstP.size()-1));
					count(blockNum, firstP, secondP, thirdP);
				}else if((int)(firstP.get(firstP.size()-1)) < (int)(secondP.get(secondP.size()-1))) {
					secondP.add(firstP.get(firstP.size()-1));
					firstP.remove((firstP.size()-1));
				}
			}
		}else {
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int blockNum = scan.nextInt();
		
		Integer[] firstP_ = new Integer[blockNum];
		
		ArrayList firstP = new ArrayList();
		ArrayList secondP = new ArrayList();
		ArrayList thirdP = new ArrayList();
		
		for(int i = 1 ; i <= blockNum ; i++) {
			firstP_[(i-1)] = i;
		}
		
		Arrays.sort(firstP_, Collections.reverseOrder());
		
		for(int i = 0 ; i < blockNum ; i++) {
			firstP.add(firstP_[i].intValue());
		}
		
		count(blockNum, firstP, secondP, thirdP);
	}
	
}
