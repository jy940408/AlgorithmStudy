package JAVADepthFirstSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class 두로봇 {
    
    static int result = 0;
    static ArrayList<int[]>[] board;

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int roomNum = Integer.parseInt(firstLine[0]);
        int startNum = Integer.parseInt(firstLine[1]);
        int goalNum = Integer.parseInt(firstLine[2]);

        board = new ArrayList[roomNum+1];
        for(int i = 0 ; i < roomNum+1 ; i++){
            board[i] = new ArrayList<int[]>();
        }
        boolean[] visitList = new boolean[roomNum+1];
        visitList[startNum] = true;

        for(int i = 0 ; i < roomNum-1 ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            int firstNum = Integer.parseInt(secondLine[0]);
            int secondNum = Integer.parseInt(secondLine[1]);
            int length = Integer.parseInt(secondLine[2]);

            board[firstNum].add(new int[] {secondNum, length});
            board[secondNum].add(new int[] {firstNum, length});
        }

        dfsCheck(startNum, goalNum, visitList, 0, 0);
        System.out.println(result);

    }

    private static void dfsCheck(int thisRoom, int goalRoom, boolean[] visitList, int maxNum, int subResult){

        if(thisRoom == goalRoom){
            result = (subResult - maxNum);
            return;
        }

        if(result != 0){
            return;
        }

        for(int[] i: board[thisRoom]){
            if(!visitList[i[0]]){
                visitList[i[0]] = true;
                dfsCheck(i[0], goalRoom, visitList, Math.max(maxNum, i[1]), (subResult+i[1]));
            }
        }

    }

}
