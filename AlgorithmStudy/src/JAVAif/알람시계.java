package JAVAif;

import java.util.Scanner;

public class 알람시계 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt(); 
		int m = scan.nextInt();
		
		if(m < 45) {
			if(h > 0 && h < 24) {
				h = h - 1;
				m = 15 + m;
				System.out.println(h + " " + m);
			}else if(h == 0) {
				h = 23;
				m = 15 + m;
				System.out.println(h + " " + m);
			}
		}else{
			m = m-45;
			System.out.println(h + " " + m);
		}
		
	}

}
