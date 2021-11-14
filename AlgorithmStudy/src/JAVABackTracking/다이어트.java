package JAVABackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 다이어트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int resultPrice = 7500;
	static int minProtein, minFat, minCarbs, minVitamin, minPrice;
	static int thisProtein, thisFat, thisCarbs, thisVitamin, thisPrice = 0;
	static ArrayList<Integer> resultList = new ArrayList<Integer>();
	static ArrayList<Integer> subList = new ArrayList<Integer>();
	static String result = "";
	
	public static void main(String[] args) throws IOException{
		
		int ingredientsNum = Integer.parseInt(br.readLine());
		String[] firstLine = (br.readLine()).split(" ");
		minProtein = Integer.parseInt(firstLine[0]);
		minFat = Integer.parseInt(firstLine[1]);
		minCarbs = Integer.parseInt(firstLine[2]);
		minVitamin = Integer.parseInt(firstLine[3]);

		String[][] ingredientsList = new String[ingredientsNum][5];
		boolean[] visitList = new boolean[ingredientsNum];
		for(int i = 0 ; i < ingredientsNum ; i++) {
			String[] secondLine = (br.readLine()).split(" ");
			ingredientsList[i] = secondLine;
		}
		
		bt(ingredientsList, visitList, 0);
		
		if(resultList.size() == 0) {
			bw.write(-1 + "");
		}else {
			for(int i = 0 ; i < resultList.size() ; i++) {
				result += resultList.get(i) + " ";
			}
			bw.write(resultPrice + "\n");
			bw.write(result);
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void bt(String[][] ingredientsList, boolean[] visitList, int root) {
		
		if(thisProtein >= minProtein && thisFat >= minFat && thisCarbs >= minCarbs && thisVitamin >= minVitamin) {
			if(thisPrice < resultPrice) {
				resultPrice = thisPrice;
				resultList = (ArrayList<Integer>) subList.clone();
			}else if(thisPrice == resultPrice) {
				
				String standard = "";
				String compare = "";
				for(int i = 0 ; i < resultList.size() ; i++) {
					standard += resultList.get(i) + " ";
				}
				for(int i = 0 ; i < subList.size() ; i++) {
					compare += subList.get(i) + " ";
				}
				if(standard.compareTo(compare) > 0) {
					resultPrice = thisPrice;
					resultList = (ArrayList<Integer>) subList.clone();
				}
			}
		}
		
		for(int i = 0 ; i < ingredientsList.length ; i++) {
			if(i >= root) {
				if(!visitList[i]) {
					visitList[i] = true;
					
					subList.add((i+1));
					thisProtein += Integer.parseInt(ingredientsList[i][0]);
					thisFat += Integer.parseInt(ingredientsList[i][1]);
					thisCarbs += Integer.parseInt(ingredientsList[i][2]);
					thisVitamin += Integer.parseInt(ingredientsList[i][3]);
					thisPrice += Integer.parseInt(ingredientsList[i][4]);
					
					bt(ingredientsList, visitList, i);
					
					subList.remove((subList.size()-1));
					thisProtein -= Integer.parseInt(ingredientsList[i][0]);
					thisFat -= Integer.parseInt(ingredientsList[i][1]);
					thisCarbs -= Integer.parseInt(ingredientsList[i][2]);
					thisVitamin -= Integer.parseInt(ingredientsList[i][3]);
					thisPrice -= Integer.parseInt(ingredientsList[i][4]);
					
					visitList[i] = false;
				}
				
			}
		}
		
	}
}
