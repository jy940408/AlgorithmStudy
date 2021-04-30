package JAVAwhile;

import java.util.Scanner;

public class 더하기싸이클 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		String j = Integer.toString(i);
		
		int k = 0;
		int l = 0;
		
		if(j.length() == 1) {
			k = 0;
			l = i;
		}else if(j.length() == 2){
			String[] iSplit = j.split("");
			k = Integer.parseInt(iSplit[0]);
			l = Integer.parseInt(iSplit[1]);
		}
		int m = 0;
		int o = 0;
		if(i != 0) {
			while(i != m) {
				m = k + l;
				String n = Integer.toString(m);
				
				if(n.length() == 1) {
					String p = Integer.toString(l) + n;
					m = Integer.parseInt(p);
					k = l;
					l = Integer.parseInt(n);
				}else if(n.length() == 2) {
					String[] mSplit = n.split("");
					String p = Integer.toString(l) + mSplit[1];
					m = Integer.parseInt(p);
					k = l;
					l = Integer.parseInt(mSplit[1]);
				}
				
				o++;
			}
		}else {
			o = 1;
		}
		
		System.out.println(o);
	}

}