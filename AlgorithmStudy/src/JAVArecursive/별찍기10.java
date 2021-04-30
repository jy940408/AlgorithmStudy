package JAVArecursive;

import java.util.Scanner;

public class 별찍기10 {
	
	public static String star(int j, String oneStar, String space) {
		
		String result = null;
		
		for(int i = 0 ; i < j ; i++) {
			if(j == 1) {
				result = oneStar + oneStar + oneStar + "\n" + oneStar + space + oneStar + "\n" + oneStar + oneStar + oneStar;
			}else if(j > 1) {
				
				result = oneStar + oneStar + oneStar + "\n" + oneStar + space + oneStar + "\n" + oneStar + oneStar + oneStar;
				
				oneStar = result;
				int spaceNum = 1;
				for(int k = 0 ; k < j-1 ; k++) {
					spaceNum = spaceNum*3;
					System.out.println("공백수: " + spaceNum);
				}
				
				space = "";
				for(int l = 0 ; l < spaceNum ; l++) {
					space += " ";
				}
				
				j = j - 1;
				System.out.println("j값: " + j);
				System.out.println("oneStar값: " + "\n" + oneStar);
				star(j, oneStar, space);
			}
			
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		String oneStar = "*";
		String space = " ";
		
		int j = 1;
		while(i/3 != 1) {
			j++;
			i = i/3;
		}
		
		System.out.println("최종 j(반복횟수)값: " + j);
		String result = star(j, oneStar, space);
		
		System.out.println(result);

	}

}
