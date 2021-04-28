package JAVAwhile;

import java.util.Scanner;

public class 더하기싸이클 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		int j = 0;
		int k = 0;
		if(i < 10) {
			j = 0;
			k = i;
		}else {
			String itoString = Integer.toString(i);
			String[] l = itoString.split("");
			j = Integer.parseInt(l[0]);
			k = Integer.parseInt(l[1]);
		}
		
		int o = j + k;
		int m = 0;
		int n = 0;
		if(o < 10) {
			m = 0;
			n = j+k;
		}else {
			String otoString = Integer.toString(o);
			String[] p = otoString.split("");
			m = Integer.parseInt(p[0]);
			n = Integer.parseInt(p[1]);
		}
		
		if(i != o) {
			
		}
		
		
	}

}
