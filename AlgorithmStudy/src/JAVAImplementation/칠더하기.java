package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 칠더하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String firstLine = "";
		while(!firstLine.equals("BYE")) {
			
			firstLine = br.readLine();
			if(!firstLine.equals("BYE")) {
				String[] lineSplit = firstLine.split("\\+");
				String firstNum = "";
				String firstString = "";
				String[] firstList = lineSplit[0].split("");
				for(int i = 0 ; i < lineSplit[0].length() ; i +=3) {
					firstString = firstList[i] + firstList[i+1] + firstList[i+2];
					if(firstString.equals("063")) {
						firstNum += "0";
					}else if(firstString.equals("010")) {
						firstNum += "1";
					}else if(firstString.equals("093")) {
						firstNum += "2";
					}else if(firstString.equals("079")) {
						firstNum += "3";
					}else if(firstString.equals("106")) {
						firstNum += "4";
					}else if(firstString.equals("103")) {
						firstNum += "5";
					}else if(firstString.equals("119")) {
						firstNum += "6";
					}else if(firstString.equals("011")) {
						firstNum += "7";
					}else if(firstString.equals("127")) {
						firstNum += "8";
					}else if(firstString.equals("107")) {
						firstNum += "9";
					}
				}
				
				String secondNum = "";
				String secondString = "";
				String[] secondList = lineSplit[1].split("");
				for(int i = 0 ; i < lineSplit[1].length()-1 ; i +=3) {
					secondString = secondList[i] + secondList[i+1] + secondList[i+2];
					if(secondString.equals("063")) {
						secondNum += "0";
					}else if(secondString.equals("010")) {
						secondNum += "1";
					}else if(secondString.equals("093")) {
						secondNum += "2";
					}else if(secondString.equals("079")) {
						secondNum += "3";
					}else if(secondString.equals("106")) {
						secondNum += "4";
					}else if(secondString.equals("103")) {
						secondNum += "5";
					}else if(secondString.equals("119")) {
						secondNum += "6";
					}else if(secondString.equals("011")) {
						secondNum += "7";
					}else if(secondString.equals("127")) {
						secondNum += "8";
					}else if(secondString.equals("107")) {
						secondNum += "9";
					}
				}
				
				int firstInt = Integer.parseInt(firstNum);
				int secondInt = Integer.parseInt(secondNum);
				
				String[] resultNum = Integer.toString(firstInt + secondInt).split("");
				String result = "";
				for(int i = 0 ; i < resultNum.length ; i++) {
					if(resultNum[i].equals("0")) {
						result += "063";
					}else if(resultNum[i].equals("1")) {
						result += "010";
					}else if(resultNum[i].equals("2")) {
						result += "093";
					}else if(resultNum[i].equals("3")) {
						result += "079";
					}else if(resultNum[i].equals("4")) {
						result += "106";
					}else if(resultNum[i].equals("5")) {
						result += "103";
					}else if(resultNum[i].equals("6")) {
						result += "119";
					}else if(resultNum[i].equals("7")) {
						result += "011";
					}else if(resultNum[i].equals("8")) {
						result += "127";
					}else if(resultNum[i].equals("9")) {
						result += "107";
					}
				}
				
				bw.write(firstLine + result + "\n");
			}
			
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
