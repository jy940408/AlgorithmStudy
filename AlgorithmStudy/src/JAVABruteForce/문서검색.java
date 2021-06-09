package JAVABruteForce;

import java.util.Scanner;

public class 문서검색 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] firstLine = (scan.nextLine()).split("");
		String[] secondLine = (scan.nextLine()).split("");

		System.out.println("firstLine.length: " + firstLine.length);
		System.out.println("secondLine.length: " + secondLine.length);
		
		int num = 0;
		
		for(int i = 0 ; i < firstLine.length ; i++) {
			System.out.println(i + "번째 for문");
			if(i <= (firstLine.length - secondLine.length) && firstLine[i].equals(secondLine[0])) {
				System.out.println(i + "번째 if문");
				for(int j = 0 ; j < secondLine.length ; j++) {
					if(secondLine[j].equals(firstLine[i+j])) {
						System.out.println("secondLine[" + j + "]: "+ secondLine[j]);
						System.out.println("firstLine[" +(i+j) +"]: " + firstLine[i+j]);
						if(j == secondLine.length-1) {
							num = num + 1;
							i = i + secondLine.length-1;
							System.out.println("num: " + num);
						}
					}else {
						break;
					}
				}
			}
		}
		
		System.out.println(num);
		
	}

}
