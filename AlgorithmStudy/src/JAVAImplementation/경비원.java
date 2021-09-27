package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 경비원 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int width = Integer.parseInt(firstLine[0]);
		int height = Integer.parseInt(firstLine[1]);
		int placeNum = Integer.parseInt(br.readLine());
		String[] placeList = new String[placeNum];
		for(int i = 0 ; i < placeNum ; i++) {
			placeList[i] = br.readLine();
		}
		String[] secondLine = (br.readLine()).split(" ");
		int myDirection = Integer.parseInt(secondLine[0]);
		int myDistance = Integer.parseInt(secondLine[1]);
		
		int result = 0;
		int subResult = 0;
		for(int i = 0 ; i < placeNum ; i++) {
			int direction = Integer.parseInt((placeList[i].split(" "))[0]);
			int distance = Integer.parseInt((placeList[i].split(" "))[1]);
			
			if(myDirection == 1) {
				if(direction == 1) {
					if(myDistance <= distance) {
						subResult = (distance - myDistance);
					}else if(myDistance > distance) {
						subResult = (myDistance - distance);
					}
				}else if(direction == 2) {
					subResult = (myDistance + height + distance);
				}else if(direction == 3) {
					subResult = (myDistance + distance);
				}else if(direction == 4) {
					subResult = ((width - myDistance) + distance);
				}
			}else if(myDirection == 2) {
				if(direction == 1) {
					subResult = (myDistance + height + distance);
				}else if(direction == 2) {
					if(myDistance <= distance) {
						subResult = (distance - myDistance);
					}else if(myDistance > distance) {
						subResult = (myDistance - distance);
					}
				}else if(direction == 3) {
					subResult = (myDistance + (height - distance));
				}else if(direction == 4) {
					subResult = ((width - myDistance) + (height - distance));
				}
			}else if(myDirection == 3) {
				if(direction == 1) {
					subResult = (myDistance + distance);
				}else if(direction == 2) {
					subResult = ((height - myDistance) + distance);
				}else if(direction == 3) {
					if(myDistance <= distance) {
						subResult = (distance - myDistance);
					}else if(myDistance > distance) {
						subResult = (myDistance - distance);
					}
				}else if(direction == 4) {
					subResult = (myDistance + width + distance);
				}
			}else if(myDirection == 4) {
				if(direction == 1) {
					subResult = ((width - distance) + myDistance);
				}else if(direction == 2) {
					subResult = ((height - myDistance) + (width - distance));
				}else if(direction == 3) {
					subResult = (myDistance + width + distance);
				}else if(direction == 4) {
					if(myDistance <= distance) {
						subResult = (distance - myDistance);
					}else if(myDistance > distance) {
						subResult = (myDistance - distance);
					}
				}
			}
			
			if((((2*width) + (2*height) - subResult)) > subResult) {
				result += subResult;
			}else {
				result += (((2*width) + (2*height) - subResult));
			}
			
			subResult = 0;
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}

}
