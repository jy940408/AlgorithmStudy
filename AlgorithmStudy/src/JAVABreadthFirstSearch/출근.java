package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 출근 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown, leftRight;
    static int[][] board, visitList;
    static int height, width, moveNum, result = 100000;
    static boolean resultCheck;

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        Queue<int[]> bfsQueue = new LinkedList<>();

        board = new int[height][width];
        visitList = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                visitList[i][j] = -1;
                board[i][j] = Integer.parseInt(secondLine[j]);
                if(i == 0 && board[i][j] == 1){
                    bfsQueue.add(new int[] {i, j, 0});
                }
            }
        }

        moveNum = Integer.parseInt(br.readLine());
        upDown = new int[moveNum];
        leftRight = new int[moveNum];
        for(int i = 0 ; i < moveNum ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            upDown[i] = Integer.parseInt(secondLine[0]);
            leftRight[i] = Integer.parseInt(secondLine[1]);
        }

        bfs(bfsQueue);

        if(resultCheck){
            bw.write(result + "");
        }else{
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(Queue<int[]> bfsQueue){

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < moveNum ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(board[subHeight][subWidth] == 1){
                        if(visitList[subHeight][subWidth] == -1){
                            visitList[subHeight][subWidth] = (thisQueue[2]+1);
                            if(subHeight == (height-1)){
                                resultCheck = true;
                                if(result > visitList[subHeight][subWidth]){
                                    result = visitList[subHeight][subWidth];
                                }
                            }
                            bfsQueue.add(new int[] {subHeight, subWidth, visitList[subHeight][subWidth]});
                        }
                    }
                }
            }
        }

    }
}
