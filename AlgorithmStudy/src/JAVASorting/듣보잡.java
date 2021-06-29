package JAVASorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 듣보잡 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		String[] firstLine = (scan.readLine()).split(" ");
		
		int notHearNum = Integer.parseInt(firstLine[0]);
		int notSeeNum = Integer.parseInt(firstLine[1]);
		
		Set<String> notHear = new HashSet<String>();
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i = 0 ; i < notHearNum ; i++) {
			notHear.add(scan.readLine());
		}
		for(int i = 0 ; i < notSeeNum ; i++) {
			String notSee = scan.readLine();
			if(notHear.contains(notSee)) {
				result.add(notSee);
			}
		}
		
		scan.close();
		
		Collections.sort(result);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(result.size() + "\n");
		for(int i = 0 ; i < result.size() ; i++) {
			bw.write(result.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
