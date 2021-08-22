package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자정사각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int height = Integer.parseInt(firstLine[0]);
		int width = Integer.parseInt(firstLine[1]);
		
		int[][] square = new int[height][width];
		for(int i = 0 ; i < height ; i++) {
			String[] secondLine = (br.readLine()).split("");
			for(int j = 0 ; j < width ; j++) {
				square[i][j] = Integer.parseInt(secondLine[j]);
			}
		}
		
		int maxLength = 0;
		if(height <= width) {
			maxLength = height;
		}else {
			maxLength = width;
		}
		
		int wide = 0;
		for(int i = 0 ; i < height ; i++) {
			for(int j = 0 ; j < width ; j++) {
				for(int k = 0 ; k < maxLength ; k++) {
					if((i < (height-k)) && (j < (width-k))) {
						System.out.println("i: " + i + ", j: " + j + ", k: " + k);
						if(square[i][j] == square[i+k][j] && square[i][j] == square[i][j+k] 
								&& square[i][j] == square[i+k][j+k]) {
							if(wide <= Math.pow((k+1), 2)) {
								wide = (int)Math.pow((k+1), 2);
							}
						}
					}
				}
			}
		}

		bw.write(wide + "");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
