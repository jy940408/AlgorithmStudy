package JAVAGreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 통나무건너뛰기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int roundNum = Integer.parseInt(scan.nextLine());
        
        for(int i = 0 ; i < roundNum ; i++){
            int listNum = Integer.parseInt(scan.nextLine());

            int[] board = new int[listNum];
            String[] firstLine = (scan.nextLine()).split(" ");
            for(int j = 0 ; j < listNum ; j++){
                board[j] = Integer.parseInt(firstLine[j]);
            }

            Arrays.sort(board);

            ArrayList<Integer> evenList = new ArrayList<>();
            ArrayList<Integer> oddList = new ArrayList<>();
            for(int j = 0 ; j < listNum ; j++){
                if(j%2 == 0){
                    evenList.add(j);
                }else{
                    oddList.add(0, j);
                }
            }

            ArrayList<Integer> resultOrder = new ArrayList<>();
            resultOrder.addAll(evenList);
            resultOrder.addAll(oddList);
            int[] resultBoard = new int[listNum];
            for(int j = 0 ; j < listNum ; j++){
                resultBoard[j] = board[resultOrder.get(j)];
            }

            int result = 0;
            for(int j = 0 ; j < listNum ; j++){
                result = Math.max(result, Math.abs(resultBoard[j%listNum] - resultBoard[(j+1)%listNum]));
            }

            System.out.println(result);
        }

    }

}
