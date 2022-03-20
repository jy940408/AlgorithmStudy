package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 모양만들기 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        int[] upDown = {-1, 1, 0, 0, 0};
        int[] leftRight = {0, 0, -1, 1, 0};

        String[] firstLine = (br.readLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        
        int[][] board = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        LinkedHashSet<String> visitList = new LinkedHashSet<>();
        ArrayList<Integer> numBoard = new ArrayList<>();
        numBoard.add(1);
        int result = 0, numIdx = 1;

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] == 1){
                    int subResult = 0;
                    Queue<int[]> bfsQueue = new LinkedList<>();
                    bfsQueue.add(new int[] {i, j});

                    while(!bfsQueue.isEmpty()){
                        int[] thisQueue = bfsQueue.poll();

                        for(int k = 0 ; k < 5 ; k++){
                            int thisHeight = (thisQueue[0] + upDown[k]);
                            int thisWidth = (thisQueue[1] + leftRight[k]);

                            if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                                if(board[thisHeight][thisWidth] == 1){
                                    if(!visitList.contains((thisHeight + " " + thisWidth))){
                                        visitList.add(thisHeight + " " + thisWidth);
                                        board[thisHeight][thisWidth] = numIdx;
                                        subResult++;
                                        bfsQueue.add(new int[] {thisHeight, thisWidth});
                                    }
                                }
                            }
                        }
                    }

                    numIdx++;
                    numBoard.add(subResult);
                    result = Math.max(result, subResult);
                }
            }
        }

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j] == 0){
                    int subResult = 0;
                    LinkedHashSet<Integer> subVisit = new LinkedHashSet<>();
                    for(int k = 0 ; k < 5 ; k++){
                        int thisHeight = (i + upDown[k]);
                        int thisWidth = (j + leftRight[k]);

                        if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                            if(!subVisit.contains(board[thisHeight][thisWidth])){
                                subVisit.add(board[thisHeight][thisWidth]);
                                subResult += (numBoard.get(board[thisHeight][thisWidth]));
                            }
                        }
                    }
                    
                    result = Math.max(subResult, result);
                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

}
