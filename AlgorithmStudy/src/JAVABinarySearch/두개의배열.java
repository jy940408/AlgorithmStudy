package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 두개의배열 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int allRound = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < allRound ; i++) {
			String[] firstLine = (br.readLine()).split(" ");
			
			int aNum = Integer.parseInt(firstLine[0]);
			int bNum = Integer.parseInt(firstLine[1]);
			
			String[] aList_ = (br.readLine()).split(" ");
			String[] bList_ = (br.readLine()).split(" ");
			
			int[] bList = new int[bNum];
			for(int j = 0 ; j < bNum ; j++) {
				bList[j] = Integer.parseInt(bList_[j]);
			}
			Arrays.sort(bList);
			
			long result = (long)0;
			for(int j = 0 ; j < aNum ; j++) {
				result += binaryResult(Integer.parseInt(aList_[j]), bList);
			}
			bw.write(result + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static int binaryResult(int aTest, int[] bList) {
		
		int first = 0;
		int mid = 0;
		int last = (bList.length - 1);
		
		while(first <= last) {
			mid = (first+last)/2;
			
			if(aTest == bList[mid]) {
				return bList[mid];
			}else if(aTest > bList[mid]) {
				if(mid != (bList.length-1)) {
					if(aTest <= bList[mid+1]) {
						if(aTest == bList[mid+1]) {
							return bList[mid+1];
						}else if(aTest < bList[mid+1]) {
							if((aTest-bList[mid]) <= (bList[mid+1]-aTest)) {
								return bList[mid];
							}else {
								return bList[mid+1];
							}
						}
					}else {
						first = mid+1;
					}
				}else {
					return bList[mid];
				}
			}else if(aTest < bList[mid]) {
				if(mid != 0) {
					if(aTest >= bList[mid-1]) {
						if(aTest == bList[mid-1]) {
							return bList[mid-1];
						}else if(aTest > bList[mid-1]) {
							if((aTest-bList[mid-1]) <= (bList[mid]-aTest)) {
								return bList[mid-1];
							}else {
								return bList[mid];
							}
						}
					}else {
						last = mid-1;
					}
				}else {
					return bList[mid];
				}
			}
		}
		
		return 0;
	}

}
