package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 침투{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean trueCheck = false;
    static int[] upDown = {-1,1,0,0};
    static int[] leftRight = {0,0,-1,1};
    static int[][] board;
    static boolean[][] visitList;
    static int height, width;

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        board = new int[height][width];
        visitList = new boolean[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        for(int i = 0 ; i < width ; i++){
            if(!visitList[0][i] && board[0][i] == 0){
                if(!trueCheck){
                    bfs(0, i);
                }else{
                    break;
                }
            }
        }

        if(trueCheck){
            bw.write("YES");
        }else{
            bw.write("NO");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int heightRoot, int widthRoot){

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {heightRoot, widthRoot});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            if(thisHeight == (height-1)){
                trueCheck = true;
                return;
            }

            if(!visitList[thisHeight][thisWidth]){
                visitList[thisHeight][thisWidth] = true;

                for(int i = 0 ; i < 4 ; i++){
                    int subHeight = (thisHeight + upDown[i]);
                    int subWidth = (thisWidth + leftRight[i]);
                    if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                        if(board[subHeight][subWidth] == 0){
                            if(!visitList[subHeight][subWidth]){
                                bfsQueue.add(new int[] {subHeight, subWidth});
                            }
                        }
                    }
                }
            }
        }

    }

}