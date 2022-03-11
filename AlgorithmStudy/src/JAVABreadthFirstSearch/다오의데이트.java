package JAVABreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 다오의데이트 {
    
    public static void main(String[] args) {
        
        int[] upDown = {0, -1, 0, 0, 1};
        int[] leftRight = {-1, 0, 0, 1, 0};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        
        String[][] board = new String[height][width];
        Queue<String[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i ++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("D")){
                    bfsQueue.add(new String[] {Integer.toString(i), Integer.toString(j), "0", ""});
                }
            }
        }

        int timeNum = Integer.parseInt(scan.nextLine());
        ArrayList<String[]> moveList = new ArrayList<>();
        for(int i = 0 ; i < timeNum ; i++){
            String[] thirdLine = (scan.nextLine()).split(" ");
            moveList.add(new String[] {thirdLine[0], thirdLine[1]});
        }

        String result = "";
        boolean resultCheck = false;
        loop:
        while(!bfsQueue.isEmpty()){
            String[] thisQueue = bfsQueue.poll();
            int subHeight = Integer.parseInt(thisQueue[0]);
            int subWidth = Integer.parseInt(thisQueue[1]);
            int thisTime = Integer.parseInt(thisQueue[2]);

            if (thisTime < timeNum){
                for(int i = 0 ; i < 2 ; i++){
                    int thisHeight = (subHeight + upDown[(moveList.get(thisTime)[i].charAt(0)-65)%7]);
                    int thisWidth = (subWidth + leftRight[(moveList.get(thisTime)[i].charAt(0)-65)%7]);
                
                    if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                        if(!board[thisHeight][thisWidth].equals("@")){
                            bfsQueue.add(new String[] {Integer.toString(thisHeight), Integer.toString(thisWidth), Integer.toString(thisTime+1), (thisQueue[3] + moveList.get(thisTime)[i])});
                            
                            if(board[thisHeight][thisWidth].equals("Z")){
                                resultCheck = true;
                                result = (thisQueue[3] + moveList.get(thisTime)[i]);
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        if(resultCheck){
            System.out.println("YES\n" + result);
        }else{
            System.out.println("NO");
        }

    }

}
