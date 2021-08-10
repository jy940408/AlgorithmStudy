package JAVABruteForce;

import java.util.Scanner;

public class 문자열 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] testString = (scan.nextLine()).split(" ");
		String[] aWord = testString[0].split("");
		String[] bWord = testString[1].split("");
		String[] addWord = new String[bWord.length];
		
		int wrongWord = 0;
		int wrongWord_ = 0;
		int checkIdx = 0;
		int result = 0;
		if(aWord.length == bWord.length) {
			for(int i = 0 ; i < aWord.length ; i++) {
				if(!aWord[i].equals(bWord[i])) {
					System.out.println(aWord[i] + " " + bWord[i]);
					result += 1;
				}
			}
		}else if(aWord.length < bWord.length) {
			for(int i = 0 ; i < ((bWord.length - aWord.length)+1) ; i++) {
				wrongWord = 0;
				for(int j = 0 ; j < aWord.length ; j++) {
					System.out.println("aWord[" + j+ "]: " + aWord[j] + ", bWord[" + (j+i) + "]: " + bWord[j+i]);
					if(!aWord[j].equals(bWord[j+i])) {
						wrongWord += 1;
					}
					
					if(i == 0 && j == aWord.length-1) {
						wrongWord_ = wrongWord;
					}else if(i != 0 && j == aWord.length-1) {
						if(wrongWord < wrongWord_) {
							wrongWord_ = wrongWord;
							checkIdx = i;
						}
					}
				}
			}
			
			for(int i = 0 ; i < checkIdx ; i++) {
				addWord[i] = bWord[i];
			}
			for(int i = 0 ; i < aWord.length ; i++) {
				addWord[i+checkIdx] = aWord[i];
			}
			for(int i = (checkIdx + aWord.length) ; i < bWord.length ; i++) {
				addWord[i] = bWord[i];
			}
			for(int i = 0 ; i < addWord.length ; i++) {
				System.out.println("addWord[" + i+ "]: " + addWord[i] + ", bWord[" + i + "]: " + bWord[i]);
				if(!addWord[i].equals(bWord[i])) {
					result += 1;
				}
			}
		}
		
		System.out.println("wrongWord_: " + wrongWord_ + ", checkIdx: " + checkIdx);
		System.out.println("result: " + result);

	}

}
