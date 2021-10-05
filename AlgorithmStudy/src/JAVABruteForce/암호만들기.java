package JAVABruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class 암호만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<String> result = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{

		String[] firstLine = (br.readLine()).split(" ");
		int codeLength = Integer.parseInt(firstLine[0]);
		int candidateNum = Integer.parseInt(firstLine[1]);
		String[] candidate = (br.readLine()).split(" ");
		boolean[] visitCheck = new boolean[candidateNum];
		
		Arrays.sort(candidate);
		System.out.println("candidate: " + Arrays.toString(candidate));
		code(candidate, codeLength, visitCheck, 0, 0, 0, 0);
		
		br.close();
		bw.flush();
		bw.close();
	
	}
	
	private static void code(String[] candidate, int codeLength, boolean[] visitCheck, int depth, int postIdx, int vowel, int consonant) throws IOException{
		
		if(depth == codeLength) {
			if(vowel >= 1 && consonant >= 2) {
				for(int i = 0 ; i < result.size() ; i++) {
					if(i == result.size()-1) {
						bw.write(result.get(i) + ", vowel: " + vowel + ", consonant: " + consonant + "\n");
					}else {
						bw.write(result.get(i) + "");
					}
				}
			}
			return;
		}
		
		for(int i = postIdx ; i < candidate.length ; i++) {
			if(!visitCheck[i]) {
				visitCheck[i] = true;
				if(candidate[i].equals("a") || candidate[i].equals("e") || candidate[i].equals("i") || candidate[i].equals("o") || candidate[i].equals("u")) {
					vowel++;
				}else {
					consonant++;
				}
				result.add(depth, candidate[i]);
				code(candidate, codeLength, visitCheck, depth+1, i, vowel, consonant);
				result.remove(depth);
				if(candidate[i].equals("a") || candidate[i].equals("e") || candidate[i].equals("i") || candidate[i].equals("o") || candidate[i].equals("u")) {
					vowel--;
				}else {
					consonant--;
				}
				visitCheck[i] = false;
			}
		}
		
	}

}
