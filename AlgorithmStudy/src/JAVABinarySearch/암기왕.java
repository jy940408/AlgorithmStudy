package JAVABinarySearch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 암기왕 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner scan = new Scanner(System.in);
		
		int firstNum = scan.nextInt();
		
		for(int i = 0 ; i < firstNum ; i++) {
			
			int nNum = scan.nextInt();
			int[] nList = new int[nNum];
			
			for(int j = 0 ; j < nNum ; j++) {
				nList[j] = scan.nextInt();
			}
			
			Arrays.sort(nList);
			
			int mNum = scan.nextInt();
			
			for(int j = 0 ; j < mNum ; j++) {
				if(Arrays.binarySearch(nList, scan.nextInt()) >= 0) {
					bw.write(1 + "");
					bw.newLine();
				}else {
					bw.write(0 + "");
					bw.newLine();
				}
			}
			
		}
		
		bw.flush();
		bw.close();
	}

}
