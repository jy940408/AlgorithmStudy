package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수열 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int sequenceLength = Integer.parseInt(br.readLine());
		String[] sequence_ = (br.readLine()).split(" ");
		int[] sequence = new int[sequenceLength];
		for(int i = 0 ; i < sequenceLength ; i++) {
			sequence[i] = Integer.parseInt(sequence_[i]);
		}
		
		int large = 0;
		int small = 0;
		boolean largeCheck = true;
		boolean smallCheck = true;
		for(int i = 0 ; i < sequenceLength ; i++) {
			largeCheck = true;
			smallCheck = true;
			if(large < (sequenceLength-i) || small < (sequenceLength-i)) {
				for(int j = i ; j < sequenceLength ; j++) {
					if(j < sequenceLength-1) {
						if(largeCheck && sequence[j] <= sequence[j+1]) {
							if(large < ((j+1)-i)+1) {
								large = ((j+1)-i)+1;
							}
						}else {
							largeCheck = false;
						}
						if(smallCheck && sequence[j] >= sequence[j+1]) {
							if(small < ((j+1)-i)+1) {
								small = ((j+1)-i)+1;
							}
						}else {
							smallCheck = false;
						}
						if(!largeCheck && ! smallCheck) {
							break;
						}
					}else if(sequenceLength == 1){
                        large = 1;
                    }
				}
			}else {
				break;
			}
		}
		
		if(small <= large) {
			bw.write(large + "");
		}else {
			bw.write(small + "");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
