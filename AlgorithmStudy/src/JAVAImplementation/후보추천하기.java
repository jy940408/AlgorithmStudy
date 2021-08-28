package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class 후보추천하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int frameNum = Integer.parseInt(br.readLine());
		int recommendNum = Integer.parseInt(br.readLine());
		String[] studentList_ = (br.readLine()).split(" ");
		int[] studentList = new int[recommendNum];
		HashMap<Integer, Integer> studentRec = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < recommendNum ; i++) {
			studentList[i] = Integer.parseInt(studentList_[i]);
		}
		
		int[] frameStudent = new int[frameNum];
		int smallNum = 0;
		int smallIdx = 0;
		for(int i = 0 ; i < recommendNum ; i++) {
			if(studentRec.containsKey(studentList[i])) {
				studentRec.put(studentList[i], studentRec.get(studentList[i])+1);
			}else {
				for(int j = 0 ; j < frameNum ; j++) {
					if(frameStudent[j] == 0) {
						frameStudent[j] = studentList[i];
						studentRec.put(frameStudent[j], 1);
						break;
					}else if(j == (frameNum-1) && frameStudent[j] != 0) {
						smallNum = studentRec.get(frameStudent[0]);
						smallIdx = 0;
						for(int k = 0 ; k < frameNum ; k++) {
							if(studentRec.containsKey(frameStudent[k])) {
								if(smallNum > (int)studentRec.get(frameStudent[k])) {
									smallIdx = k;
									smallNum = studentRec.get(frameStudent[k]);
								}
							}
						}
						studentRec.remove(frameStudent[smallIdx]);
						studentRec.put(studentList[i], 1);
						for(int k = smallIdx ; k < frameNum-1 ; k++) {
							frameStudent[k] = frameStudent[k+1];
						}
						frameStudent[frameNum-1] = studentList[i];
					}
				}
			}
		}
		
		Arrays.sort(frameStudent);
		
		String result = "";
		for(int i = 0 ; i < frameNum ; i++) {
			if(frameStudent[i] != 0) {
				result += (frameStudent[i] + " ");
			}
		}
		
		bw.write(result + "");
		br.close();
        bw.flush();
        bw.close();
		
	}

}
