package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMoves {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] upDown = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] leftRight = {-2, -1, 1, 2, -2, -1, 1, 2};

        String firstLine = "";
        while((firstLine = br.readLine()) != null){
            String[] boardList = firstLine.split(" ");
            int startHeight = (boardList[0].charAt(0)-97), startWidth = (Integer.parseInt(Character.toString(boardList[0].charAt(1)))-1);
            int goalHeight = (boardList[1].charAt(0)-97), goalWidth = (Integer.parseInt(Character.toString(boardList[1].charAt(1)))-1);

            boolean[][] visitList = new boolean[8][8];
            Queue<int[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new int[] {startHeight, startWidth, 0});
            while(!bfsQueue.isEmpty()){
                int[] thisQueue = bfsQueue.poll();

                if(thisQueue[0] == goalHeight && thisQueue[1] == goalWidth){
                    bw.write("To get from " + boardList[0] + " to " + boardList[1] + " takes " + thisQueue[2] + " knight moves.\n");
                    bw.flush();
                    break;
                }

                for(int i = 0 ; i < 8 ; i++){
                    int thisHeight = (thisQueue[0] + upDown[i]);
                    int thisWidth = (thisQueue[1] + leftRight[i]);

                    if(thisHeight >= 0 && thisHeight < 8 && thisWidth >= 0 && thisWidth < 8){
                        if(!visitList[thisHeight][thisWidth]){
                            visitList[thisHeight][thisWidth] = true;
                            bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});
                        }
                    }
                }
            }
        }

        br.close();
        bw.close();

    }

}