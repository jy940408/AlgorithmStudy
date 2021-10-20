package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 톱니바퀴 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] firstGear = new int[8];
	static int[] secondGear = new int[8];
	static int[] thirdGear = new int[8];
	static int[] forthGear = new int[8];
	
	public static void main(String[] args) throws IOException{
		
		String[] firstGear_ = (br.readLine()).split("");
		String[] secondGear_ = (br.readLine()).split("");
		String[] thirdGear_ = (br.readLine()).split("");
		String[] forthGear_ = (br.readLine()).split("");
		for(int i = 0 ; i < 8 ; i++) {
			firstGear[i] = Integer.parseInt(firstGear_[i]);
			secondGear[i] = Integer.parseInt(secondGear_[i]);
			thirdGear[i] = Integer.parseInt(thirdGear_[i]);
			forthGear[i] = Integer.parseInt(forthGear_[i]);
		}
		
		int round = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < round ; i++) {
			String[] testLine = (br.readLine()).split(" ");
			int gearNum = Integer.parseInt(testLine[0]);
			int direction = Integer.parseInt(testLine[1]);
			
			int firstRight = firstGear[2];
			int secondLeft = secondGear[6];
			int secondRight = secondGear[2];
			int thirdLeft = thirdGear[6];
			int thirdRight = thirdGear[2];
			int forthLeft = forthGear[6];
			
			if(gearNum == 1) {
				gearCheck(gearNum, direction);
				if(firstRight != secondLeft) {
					direction *= -1;
					gearCheck(2, direction);
					if(secondRight != thirdLeft) {
						direction *= -1;
						gearCheck(3, direction);
						if(thirdRight != forthLeft) {
							direction *= -1;
							gearCheck(4, direction);
						}
					}
				}
			}else if(gearNum == 2) {
				gearCheck(gearNum, direction);
				if(firstRight != secondLeft) {
					gearCheck(1, -direction);
				}
				if(secondRight != thirdLeft) {
					direction *= -1;
					gearCheck(3, direction);
					if(thirdRight != forthLeft) {
						direction *= -1;
						gearCheck(4, direction);
					}
				}
			}else if(gearNum == 3) {
				gearCheck(gearNum, direction);
				if(secondRight != thirdLeft) {
					gearCheck(2, -direction);
					if(firstRight != secondLeft) {
						gearCheck(1, direction);
					}
				}
				if(thirdRight != forthLeft) {
					gearCheck(4, -direction);
				}
			}else if(gearNum == 4) {
				gearCheck(gearNum, direction);
				if(thirdRight != forthLeft) {
					direction *= -1;
					gearCheck(3, direction);
					if(secondRight != thirdLeft) {
						direction *= -1;
						gearCheck(2, direction);
						if(firstRight != secondLeft) {
							direction *= -1;
							gearCheck(1, direction);
						}
					}
				}
			}
			
		}
		
		int result = (firstGear[0]*1) + (secondGear[0]*2) + (thirdGear[0]*4) + (forthGear[0]*8);
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();

	}
	
	private static void gearCheck(int gearNum, int direction) {
		
		if(gearNum == 1) {
			if(direction == 1) {
				int subNum = firstGear[7];
				for(int i = 7 ; i >= 1 ; i--) {
					firstGear[i] = firstGear[i-1];
				}
				firstGear[0] = subNum;
			}else {
				int subNum = firstGear[0];
				for(int i = 0 ; i < 7 ; i++) {
					firstGear[i] = firstGear[i+1];
				}
				firstGear[7] = subNum;
			}
		}else if(gearNum == 2) {
			if(direction == 1) {
				int subNum = secondGear[7];
				for(int i = 7 ; i >= 1 ; i--) {
					secondGear[i] = secondGear[i-1];
				}
				secondGear[0] = subNum;
			}else {
				int subNum = secondGear[0];
				for(int i = 0 ; i < 7 ; i++) {
					secondGear[i] = secondGear[i+1];
				}
				secondGear[7] = subNum;
			}
		}else if(gearNum == 3) {
			if(direction == 1) {
				int subNum = thirdGear[7];
				for(int i = 7 ; i >= 1 ; i--) {
					thirdGear[i] = thirdGear[i-1];
				}
				thirdGear[0] = subNum;
			}else {
				int subNum = thirdGear[0];
				for(int i = 0 ; i < 7 ; i++) {
					thirdGear[i] = thirdGear[i+1];
				}
				thirdGear[7] = subNum;
			}
		}else {
			if(direction == 1) {
				int subNum = forthGear[7];
				for(int i = 7 ; i >= 1 ; i--) {
					forthGear[i] = forthGear[i-1];
				}
				forthGear[0] = subNum;
			}else {
				int subNum = forthGear[0];
				for(int i = 0 ; i < 7 ; i++) {
					forthGear[i] = forthGear[i+1];
				}
				forthGear[7] = subNum;
			}
		}
		
	}
}
