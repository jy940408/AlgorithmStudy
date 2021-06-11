package JAVAImplementation;

import java.util.ArrayList;
import java.util.Scanner;

public class 사탕박사고창영 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int caseNum = Integer.parseInt(scan.nextLine());
		ArrayList<String> rcList = new ArrayList<String>();
		
		ArrayList candyList = new ArrayList<>();
		
		for(int i = 0 ; i < caseNum ; i++) {
			int candyNum = 0;
			
			scan.nextLine();
			String[] rcInfo_ = (scan.nextLine()).split(" ");
			int[] rcInfo = {Integer.parseInt(rcInfo_[0]), Integer.parseInt(rcInfo_[1])};
			for(int j = 0 ; j < rcInfo[0] ; j++) {
				String[] candyLine = (scan.nextLine()).split("");
				for(int k = 0 ; k < rcInfo[1] ; k++) {
					rcList.add(candyLine[k]);
					if(k > 1 && candyLine[k].equals("<") && candyLine[k-1].equals("o") && candyLine[k-2].equals(">")) {
						candyNum = candyNum + 1;
					}else if(rcList.size() > rcInfo[1]*2 && rcList.get((rcList.size()-1)).equals("^") && rcList.get((rcList.size()-1-rcInfo[1])).equals("o") && rcList.get((rcList.size()-1-(rcInfo[1]*2))).equals("v")) {
						candyNum = candyNum + 1;
					}
				}
			}
			
			candyList.add(candyNum);
		}
		
		for(int i = 0 ; i < candyList.size() ; i++) {
			System.out.println(candyList.get(i));
		}
		
	}
	
}
