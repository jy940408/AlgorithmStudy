package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 예산 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int local = Integer.parseInt(br.readLine());
		String[] budgetList_ = (br.readLine()).split(" ");
		int[] budgetList = new int[local];
		for(int i = 0 ; i < local ; i++) {
			budgetList[i] = Integer.parseInt(budgetList_[i]);
		}
		Arrays.sort(budgetList);
		int allBudget = Integer.parseInt(br.readLine());
		
		br.close();
		bw.write(bs(budgetList, allBudget) + "");
		bw.flush();
		bw.close();
		
	}
	
	private static int bs(int[] budgetList, int allBudget) {
		
		int first = 0;
		int mid = 0;
		int last = budgetList[budgetList.length-1];
		int budgetSum = 0;
		int testSum = 0;
		
		while(first <= last) {
			budgetSum = 0;
			testSum = 0;
			mid = (first+last)/2;
			for(int i = 0 ; i < budgetList.length ; i++) {
				if(budgetList[i] >= mid) {
					budgetSum += mid;
				}else {
					budgetSum += budgetList[i];
				}
			}
			
			if(budgetSum == allBudget) {
				return mid;
			}else if(budgetSum < allBudget) {
				for(int i = 0 ; i < budgetList.length ; i++) {
					if(budgetList[i] >= (mid+1)) {
						testSum += (mid+1);
					}else {
						testSum += budgetList[i];
					}
				}
				if(testSum == allBudget) {
					return (mid + 1);
				}else if(testSum > allBudget) {
					return mid;
				}else {
					first = mid + 1;
				}
			}else if(budgetSum > allBudget) {
				last = mid - 1;
			}
		}
		
		return mid;
	}

}
