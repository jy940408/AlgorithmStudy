package JAVArecursive;

import java.util.ArrayList;
import java.util.Scanner;

public class 압축 {

	public static void originalLength(String comps) {
		
		String[] compress_ = comps.split("");
		int compsNum = compress_.length;
		ArrayList compress = new ArrayList();
		for(int i = 0 ; i < compsNum ; i++) {
			compress.add(compress_[i]);
		}
		
		ArrayList extraction = new ArrayList();		
		for(int i = 0 ; i < compsNum ; i++) {
			if(((String)compress.get(i)).equals("(")) {
				extraction.add((String)compress.get(i));
			}
		}
		
		String stringLast = "";
		
		int extractionNum = 0;
		if(extraction.size() != 0) {
			extractionNum = extraction.size();
		}else if(extraction.size() == 0) {
			extractionNum = 0;
		}
		if(extractionNum != 0) {
			
			int pareNum = 0;
			int mainNum = 0;
			for(int i = 0 ; i < compsNum ; i++) {
				if(((String)compress.get(i)).equals("(")) {
					pareNum += 1;
					if(pareNum == extractionNum) {
						mainNum = i+1;
					}
				}
			}
			
			int secondNum = 0;
			int pareNum2 = 0;
			if(pareNum > 1) {
				for(int i = 0 ; i < compsNum ; i++) {
					if(((String)compress.get(i)).equals("(")) {
						pareNum2 += 1;
						if(pareNum2 == pareNum-1) {
							secondNum = i+1;
						}
					}
				}
			}
			
			String mainString = "";
			int mainLast = 0;
			for(int i = mainNum ; i < compsNum ; i++) {
				if(((String)compress.get(i)).equals(")")) {
					for(int j = mainNum ; j < i ; j++) {
						mainString += compress.get(j);
					}
					mainLast = i;
					break;
				}
			}
			
			String middleS = "";
			if(mainNum-secondNum > 1) {
				for(int i = secondNum ; i < mainNum-2 ; i++) {
					middleS += compress.get(i);
				}
			}
			
			String mainCom = "";
			for(int i = 0 ; i < Integer.parseInt((String)(compress.get(mainNum-2))) ; i++) {
				mainCom += mainString;
			}
			mainCom = middleS + mainCom;
			
			stringLast = "";
			String pareLast = "";
			for(int i = 0 ; i < secondNum ; i++) {
				stringLast += compress.get(i);
				if(((String)compress.get(i)).equals("(")) {
					pareLast += ")";
				}
			}
			
			stringLast = stringLast + mainCom + pareLast;
			
			originalLength(stringLast);
		}else {
			System.out.println(comps.length());
		}
	}
	
	public static void main(String[] args) {
		
	 Scanner scan = new Scanner(System.in);
	 String comps = scan.nextLine();
	 originalLength((String)comps);
	}

}
