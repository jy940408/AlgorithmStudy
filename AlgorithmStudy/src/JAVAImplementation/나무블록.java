package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 나무블록 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String blockSum = "";
		int round = 0;
		String result = "";
		while(!blockSum.equals("0")) {
			round += 1;
			result = "VALID";
			blockSum = (br.readLine());
			if(!blockSum.equals("0")) {
				String[] blockList = blockSum.split("");
				for(int i = 0 ; i < blockList.length ; i++) {
					if(blockList[0].equals("1") && blockList[blockList.length-1].equals("2")) {
						if(i != 0 && i != (blockList.length-1)) {
							if(blockList[i].equals("1") && i != 0) {
								result = "NOT";
								break;
							}else if(blockList[i].equals("2") && i != (blockList.length-1)) {
								result = "NOT";
								break;
							}else if(blockList[i].equals("3")) {
								if(blockList[i-1].equals("4") || blockList[i-1].equals("6")) {
									if(blockList[i+1].equals("4") || blockList[i+1].equals("5")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}else if(blockList[i].equals("4")) {
								if(blockList[i-1].equals("1") || blockList[i-1].equals("3")) {
									if(blockList[i+1].equals("2") || blockList[i+1].equals("3")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}else if(blockList[i].equals("5")) {
								if(blockList[i-1].equals("1") || blockList[i-1].equals("3")) {
									if(blockList[i+1].equals("8")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}else if(blockList[i].equals("6")) {
								if(blockList[i-1].equals("8")) {
									if(blockList[i+1].equals("2") || blockList[i+1].equals("3")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}else if(blockList[i].equals("7")) {
								if(blockList[i-1].equals("8")) {
									if(blockList[i+1].equals("8")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}else if(blockList[i].equals("8")) {
								if(blockList[i-1].equals("5") || blockList[i-1].equals("7")) {
									if(blockList[i+1].equals("6") || blockList[i+1].equals("7")) {
										result = "VALID";
									}else {
										result = "NOT";
										break;
									}
								}else {
									result = "NOT";
									break;
								}
							}
						}
					}else {
						result = "NOT";
						break;
					}
				}
				bw.write(round + ". " + result + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
