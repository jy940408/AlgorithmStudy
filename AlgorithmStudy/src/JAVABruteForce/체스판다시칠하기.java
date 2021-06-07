package JAVABruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 체스판다시칠하기 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		M*N 크기의 보드
		String[] firstLine_ = (scan.nextLine()).split(" ");
		int[] firstLine = {Integer.parseInt(firstLine_[0]), Integer.parseInt(firstLine_[1])};
		
//		M*N 크기 보드 색상 집어넣기
		ArrayList<String> bwLine = new ArrayList<String>();
		for(int i = 0 ; i < firstLine[0] ; i++) {
			bwLine.add(scan.nextLine());
		}
		
//		수정해야하는 색상 숫자 리스트 여기서 가장 작은 숫자 출력
		ArrayList modifyNum = new ArrayList<>(); 
		
//		옮길 수 있는 세로 숫자 ex) 10칸이면 총 3개의 경우의 수 가능 -> columnNum = 3
		int columnNum = (firstLine[0]-7);
//		옮길 수 있는 가로 숫사
		int rowNum = (firstLine[1]-7);
		
		System.out.println("bwLine: " + bwLine);
		System.out.println("columnNum: " + columnNum + ", rowNum: " + rowNum);
		
		ArrayList bStart = new ArrayList<>();
		ArrayList wStart = new ArrayList<>();
		bStart.add("B");
		wStart.add("W");
		
		for(int i = 1 ; i < 64 ; i++) {
			if(bStart.get(i-1).equals("W") && i%8 != 0) {
				bStart.add("B");
			}else if(bStart.get(i-1).equals("W") && i%8 == 0) {
				bStart.add("W");
			}else if(bStart.get(i-1).equals("B") && i%8 != 0) {
				bStart.add("W");
			}else if(bStart.get(i-1).equals("B") && i%8 == 0) {
				bStart.add("B");
			}
		}
		
		for(int i = 1 ; i < 64 ; i++) {
			if(wStart.get(i-1).equals("W") && i%8 != 0) {
				wStart.add("B");
			}else if(wStart.get(i-1).equals("W") && i%8 == 0) {
				wStart.add("W");
			}else if(wStart.get(i-1).equals("B") && i%8 != 0) {
				wStart.add("W");
			}else if(wStart.get(i-1).equals("B") && i%8 == 0) {
				wStart.add("B");
			}
		}
		
		System.out.println("bStart: " + bStart);
		System.out.println("wStart: " + wStart);
		
		for(int i = 0 ; i < rowNum ; i++) {
			for(int j = 0 ; j < columnNum ; j++) {
//				8*8 타일이 들어갈 목록
				ArrayList separateLine = new ArrayList<>();				

//				세로 목록 나눠주기
				for(int k = 0 ; k < 8 ; k++) {
					
//					가로 목록 나눠주기
					String[] bwLineSplit= (bwLine.get(k+j)).split("");
					for(int l = i ; l < i+8 ; l++) {
						System.out.println("bwLineSplit[" + l + "]" + bwLineSplit[l]);
						separateLine.add(bwLineSplit[l]);
					}
										
					System.out.println("i: " + i + ", j: " + j + ", k: " + k);
					System.out.println("separateLine: " + separateLine);
				
				}

				System.out.println("separateLine.size(): " + separateLine.size());
				
				int m = 0;

//				틀린 갯수 확인하기
				for(int n = 0 ; n < 64 ; n++) {
					if(!(separateLine.get(n)).equals(bStart.get(n))) {
						m = m + 1;
					}
				}
				modifyNum.add(m);
				m = 0;
				
				for(int n = 0 ; n < 64 ; n++) {
					if(!(separateLine.get(n)).equals(wStart.get(n))) {
						m = m + 1;
					}
				}
				modifyNum.add(m);
				
				System.out.println("modifyNum: " + modifyNum);

			}
		}
		
		Collections.sort(modifyNum);
		System.out.println(modifyNum.get(0));
	}
}
