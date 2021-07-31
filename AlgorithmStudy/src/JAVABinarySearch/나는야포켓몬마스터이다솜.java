package JAVABinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class 나는야포켓몬마스터이다솜 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String[] firstLine = (br.readLine()).split(" ");
		int pokemonNum = Integer.parseInt(firstLine[0]);
		int questionNum = Integer.parseInt(firstLine[1]);
		HashMap<Integer, String> pokemon = new HashMap<Integer, String>();
		
		char testString_;
		String testString;
		
		for(int i = 0 ; i < pokemonNum ; i++) {
			pokemon.put(i, br.readLine());
		}
		
		for(int i = 0 ; i < questionNum ; i++) {
			
			testString = br.readLine();
			testString_ = testString.charAt(0);
			
			if(Character.isDigit(testString_)) {
				bw.write(pokemon.get((Integer.parseInt(testString)-1)));
			}else {
				for(int j = 0 ; j < pokemonNum ; j++) {
					if(testString.equals(pokemon.get(j))) {
						bw.write((j+1)+"");
						break;
					}
				}
			}
			
			bw.newLine();
			
			if(i == questionNum-1) {
				br.close();
				bw.flush();
				bw.close();
			}
			
		}

	}

}
