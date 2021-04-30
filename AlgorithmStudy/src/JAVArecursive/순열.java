package JAVArecursive;

import java.util.ArrayList;
import java.util.Scanner;

public class 순열 {

	//�Է��� ���ڸ� �ѱ��ھ� �и��� �� ������ ���� �迭
	public static ArrayList textList(String a_) {
		
		String[] a = a_.split("");
		int i = a.length;
		
		ArrayList list = new ArrayList();
		for(int j = 0 ; j < a.length ; j++) {
			list.add(a[j]);
		}
		
		return list;
	}
	
	//���� ���� ���ϴ� �޼ҵ�
	public static int maxNum(int i) {
		
		int k = 1;
		if(i > 0 && i <= 12) {
			for(int j = 1 ; j < i ; j++) {
				k = k * (j + 1);
			}
		}else if(i == 0){
			k = 1;
		}
		
		return k;
	}
	
	//����� ���� �� �� ���� �迭
	public static ArrayList separationList(ArrayList textGroup, int i) {
		ArrayList returnList = new ArrayList();
			for(int j = 0 ; j < textGroup.size() ; j++) {
				returnList.add(textGroup.get(j));			
				if(returnList.size() == (j + 1)) {
					if((textGroup.get(i)).equals(returnList.get(j))) {
						returnList.remove(textGroup.get(i));
					}
				}
			}
		ArrayList ratrunList2 = separationList(textGroup, i);
		System.out.println("returnList: " + returnList);
		return returnList;
	}
	
	public static ArrayList separationList2(ArrayList textGroup, int i) {
		ArrayList returnList = new ArrayList();
		for(int j = 0 ; j < textGroup.size() ; j++) {
			returnList.add(textGroup.get(j));			
			if(returnList.size() == (j + 1)) {
				if((textGroup.get(i)).equals(returnList.get(j))) {
					returnList.remove(textGroup.get(i));
				}
			}
		}
		System.out.println("returnList: " + returnList);
		return returnList;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a_ = scan.next();
	
		ArrayList textList = textList(a_);
		int maxNum = maxNum(textList.size());
		System.out.println("��� �׽�Ʈ: " + textList);
		System.out.println("���� �׽�Ʈ: " + maxNum);
		
//		compareTo ���� ���� ������ ����, ���� ���� �� ũ�� ���, ������ 0
		for(int i = 0 ; i < (textList.size()-1) ; i++) {
			((String)textList.get(i)).compareTo((String)textList.get(i+1));
			System.out.println(((String)textList.get(i)).compareTo((String)textList.get(i+1)));
		}
		
		ArrayList combineList_ = new ArrayList();
		int i = 0;
		System.out.println("������ �׽�Ʈ: " + textList.size());
		System.out.println("textList: " + textList);
		
//		while(i < textList.size()) {
//			String combineText = "";
//			combineText = (String)textList.get(i);
//			System.out.println("i�� �׽�Ʈ: " + i);
//			combineList_ = separationList(textList, i);
//			System.out.println("combineList_ �׽�Ʈ: " + combineList_);
//			for(int j = (i+1) ; j < combineList_.size() ; j++) {
//				System.out.println("j��: " + j);
//				combineText += (String)textList.get(j);
//				System.out.println("���ڿ� ��ġ�� �׽�Ʈ: " + combineText);
//				ArrayList testList = separationList(textList, j);
//			}
//			i++;
//		}
	}

	
	
	
	
}
