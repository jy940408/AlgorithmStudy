package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 나무자르기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");

		int trees = Integer.parseInt(firstLine[0]);
		int length = Integer.parseInt(firstLine[1]);
		
		String[] treesHeight_ = (br.readLine()).split(" ");
		int[] treesHeight = new int[trees];
		for(int i = 0 ; i < trees ; i++) {
			treesHeight[i] = Integer.parseInt(treesHeight_[i]);
		}
		
		Arrays.sort(treesHeight);
		
		bw.write(lengthCheck(length, treesHeight) + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int lengthCheck(int length, int[] treesHeight) {
	
		int first = 0;
		int mid = 0;
		int last = treesHeight[treesHeight.length-1];
		long result = 0;
		int midLength = 0;
		
		while(first <= last) {
			
			mid = (first+last)/2;
			result = 0;
			for(int i = 0 ; i < treesHeight.length ; i++) {
				if(mid < treesHeight[i]) {
					result += (treesHeight[i] - mid);
				}
			}
			
			if(result == length) {
				midLength = mid;
				return midLength;
			}else if(result > length) {
				first = mid + 1;
				midLength = mid;
			}else if(result < length) {
				last = mid - 1;
			}
		}
		
		return midLength;
	}
	
}
