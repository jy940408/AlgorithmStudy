package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 추월 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{

		int carNum = Integer.parseInt(br.readLine());
		String[] orderCar = new String[carNum];
		HashMap<String, Integer> inCar = new HashMap<String, Integer>();
		HashMap<String, Integer> outCar = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < carNum ; i++) {
			String car = br.readLine();
			inCar.put(car, (i+1));
		}
		for(int i = 0 ; i < carNum ; i++) {
			String car = br.readLine();
			orderCar[i] = car;
			outCar.put(car, (i+1));
		}
		
		int result = 0;
		for(int i = 0 ; i < carNum ; i++) {
			for(int j = i ; j < carNum ; j++) {
				if(j != i && inCar.get(orderCar[j]) < inCar.get(orderCar[i])) {
					result++;
					break;
				}
			}
		}
		
		br.close();
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

}
