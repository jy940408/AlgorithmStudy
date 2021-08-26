package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 철벽보안알고리즘 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		int firstNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < firstNum ; i++) {
			
			int codeLength = Integer.parseInt(br.readLine());
			String[] firstPublic = (br.readLine()).split(" ");
			String[] secondPublic_ = (br.readLine()).split(" ");
			HashMap<String, Integer> secondPublic = new HashMap<String, Integer>();
			String[] code = (br.readLine()).split(" ");
			for(int j = 0 ; j < codeLength ; j++) {
				secondPublic.put(secondPublic_[j], j);
			}
			
			String result = "";
			for(int j = 0 ; j < codeLength ; j++) {
				result += code[(secondPublic.get(firstPublic[j]))] + " ";
			}
			bw.write(result + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
