package JAVAGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 도서관 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int allBook = Integer.parseInt(firstLine[0]), moveBook = Integer.parseInt(firstLine[1]);

        String[] secondLine = (scan.nextLine()).split(" ");
        ArrayList<Integer>[] bookList = new ArrayList[2];
        bookList[0] = new ArrayList<Integer>();
        bookList[1] = new ArrayList<Integer>();
        for(String idx : secondLine){
            if(Integer.parseInt(idx) < 0){
                bookList[0].add(Integer.parseInt(idx)*-1);
            }else{
                bookList[1].add(Integer.parseInt(idx));
            }
        }
        Collections.sort(bookList[0], Collections.reverseOrder());
        Collections.sort(bookList[1], Collections.reverseOrder());

        int result = 0, rightMax = 0, leftMax = 0;

        ArrayList<ArrayList<Integer>> leftList = listSplit(bookList[0], moveBook);
        for(int i = 0 ; i < leftList.size() ; i++){
            result += (leftList.get(i)).get(0)*2;
            leftMax = Math.max(leftMax, (leftList.get(i).get(0)));
        }
        
        ArrayList<ArrayList<Integer>> rightList = listSplit(bookList[1], moveBook);
        for(int i = 0 ; i < rightList.size() ; i++){
            result += (rightList.get(i)).get(0)*2;
            rightMax = Math.max(rightMax, (rightList.get(i).get(0)));
        }

        if(leftMax <= rightMax){
            result -= rightMax;
        }else{
            result -= leftMax;
        }

        System.out.println(result);

    }

    private static ArrayList<ArrayList<Integer>> listSplit(ArrayList<Integer> idxList, int leng){

        ArrayList<ArrayList<Integer>> splitList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0 ; i < idxList.size() ; i += leng){
            ArrayList<Integer> subList = new ArrayList<Integer>();
            for(int j = i ; j < (i+leng) ; j++){
                if(j < idxList.size()){
                    subList.add(idxList.get(j));
                }
            }
            splitList.add(subList);
        }

        return splitList;

    }

}
