package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 시그널 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int gridNum = Integer.parseInt(br.readLine());
		int height = 5;
		int width = gridNum/5;
		String[] signal = (br.readLine()).split("");
		String[][] map = new String[height][width];
		String result = "";
		
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				map[i][j] = signal[(i*width)+j];
			}
		}
		
		String colSum = "";
		Loop1:
		for(int i = 0 ; i < width ; i++) {
			colSum = "";
			for(int j = 0 ; j < height ; j++) {
				colSum += map[j][i];
			}
			if(colSum.equals("#####")) {
				colSum = "";
				if(i < width-1) {
					for(int j = 0 ; j < height ; j++) {
						colSum += map[j][i+1];
					}
					if(colSum.equals("#...#")) {
						result += "0";
						if(i < (width-3)) {
							i += 3;
						}else {
							break Loop1;
						}
					}else if(colSum.equals("#.#.#")) {
						colSum = "";
						for(int j = 0 ; j < height ; j++) {
							colSum += map[j][i+2];
						}
						if(colSum.equals("#.###")) {
							result += "6";
							if(i < (width-3)) {
								i += 3;
							}else {
								break Loop1;
							}
						}else {
							result += "8";
							if(i < (width-3)) {
								i += 3;
							}else {
								break Loop1;
							}
						}
						
					}else {
						result += "1";
						if(i < (width-1)) {
							i += 1;
						}else {
							break Loop1;
						}
					}
				}else {
					result += "1";
				}
				
			}else if(colSum.equals("#.###")) {
				result += "2";
				if(i < (width-3)) {
					i += 3;
				}else {
					break Loop1;
				}
			}else if(colSum.equals("#.#.#")) {
				result += "3";
				if(i < (width-3)) {
					i += 3;
				}else {
					break Loop1;
				}
			}else if(colSum.equals("###..")) {
				result += "4";
				if(i < (width-3)) {
					i += 3;
				}else {
					break Loop1;
				}
			}else if(colSum.equals("###.#")) {
				colSum = "";
				for(int j = 0 ; j < height ; j++) {
					colSum += map[j][i+2];
				}
				if(colSum.equals("#.###")) {
					result += "5";
				}else {
					result += "9";
				}
				if(i < (width-3)) {
					i += 3;
				}else {
					break Loop1;
				}
			}else if(colSum.equals("#....")) {
				result += "7";
				if(i < (width-3)) {
					i += 3;
				}else {
					break Loop1;
				}
			}
		}
		
		bw.write(result + "");
        br.close();
		bw.flush();
        bw.close();
		
	}

}
