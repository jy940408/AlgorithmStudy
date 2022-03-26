package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class EscapeWallMaria {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

        String[] firstLine = (br.readLine()).split(" ");
        int time = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]), width = Integer.parseInt(firstLine[2]);

        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];

                if(board[i][j].equals("S")){
                    bfsQueue.add(new int[] {i, j, 0});
                }
            }
        }

        String result = "NOT POSSIBLE";
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == 0 || thisQueue[0] == (height-1) || thisQueue[1] == 0 || thisQueue[1] == (width-1)){
                if(thisQueue[2] <= time){
                    result = Integer.toString(thisQueue[2]);
                    break;
                }
            }

            for(int i = 0 ; i < 4 ; i++){
                int thisHeight = (thisQueue[0] + upDown[i]), thisWidth = (thisQueue[1] + leftRight[i]);

                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                    if(!board[thisHeight][thisWidth].equals("1")){
                        if(!visitList[thisHeight][thisWidth]){
                            if(board[thisHeight][thisWidth].equals("D") && i == 0){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});

                            }else if(board[thisHeight][thisWidth].equals("U") && i == 1){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});

                            }else if(board[thisHeight][thisWidth].equals("R") && i == 2){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});

                            }else if(board[thisHeight][thisWidth].equals("L") && i == 3){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});

                            }else if(board[thisHeight][thisWidth].equals("0")){
                                visitList[thisHeight][thisWidth] = true;
                                bfsQueue.add(new int[] {thisHeight, thisWidth, (thisQueue[2]+1)});
                            }
                        }
                    }
                }
            }
        }

        br.close();
        bw.write(result);
        bw.flush();
        bw.close();

    }

}
