package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 게임 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int gameNum = Integer.parseInt(firstLine[0]);
		int winNum = Integer.parseInt(firstLine[1]);
		
		br.close();
		bw.write(bs(gameNum, winNum) + "");
		bw.flush();
		bw.close();
	}
	
	private static long bs(int gameNum, int winNum) {
		
		int first = 0;
		int mid = 0;
		int last = gameNum;
		int standard = (int)Math.floor((100*(double)winNum/(double)gameNum));
		int rate = 0;
		
		while(first <= last) {
			
			mid = (first+last)/2;
			rate = (int)Math.floor((100*(double)(winNum+mid)/(double)(gameNum+mid)));
			
			if(rate == standard) {
				first = mid + 1;
			}else if(rate > standard) {
				rate = (int)Math.floor((100*(double)(winNum+mid-1)/(double)(gameNum+mid-1)));
				if(rate == standard) {
					return mid;
				}else if(rate > standard) {
					last = mid - 1;
				}else if(rate < standard) {
					return mid;
				}
			}
			
		}
		
		return -1;
	}

}
