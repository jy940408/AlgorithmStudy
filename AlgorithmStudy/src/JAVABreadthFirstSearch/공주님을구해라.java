package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 공주님을구해라 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};
    static int height, width, maxTime;
    static int[][] board, firstVisit, secondVisit;

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        maxTime = Integer.parseInt(firstLine[2]);
        
        board = new int[height][width];
        firstVisit = new int[height][width];
        secondVisit = new int[height][width];

        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        bfs(0, 0, firstVisit, secondVisit);

        if(firstVisit[(height-1)][(width-1)] == 0 && secondVisit[(height-1)][(width-1)] == 0){
            bw.write("Fail");
        }else{
            if(firstVisit[(height-1)][(width-1)] == 0){
                if(secondVisit[(height-1)][(width-1)] <= maxTime){
                    bw.write(secondVisit[(height-1)][(width-1)] + "");
                }else{
                    bw.write("Fail");
                }
            }else if(secondVisit[(height-1)][(width-1)] == 0){
                if(firstVisit[(height-1)][(width-1)] <= maxTime){
                    bw.write(firstVisit[(height-1)][(width-1)] + "");
                }else{
                    bw.write("Fail");
                }
            }else{
                int result = Math.min(firstVisit[(height-1)][(width-1)], secondVisit[(height-1)][(width-1)]);
                if(result <= maxTime){
                    bw.write(result + "");
                }else{
                    bw.write("Fail");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static void bfs(int heightRoot, int widthRoot, int[][] firstVisit, int[][] secondVisit){
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {heightRoot, widthRoot, 0, 0});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();
            int thisHeight = thisQueue[0];
            int thisWidth = thisQueue[1];

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisHeight + upDown[i]);
                int subWidth = (thisWidth + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(thisQueue[2] == 0){
                        if(firstVisit[subHeight][subWidth] == 0){
                            if(board[subHeight][subWidth] == 0){
                                firstVisit[subHeight][subWidth] = (thisQueue[3]+1);
                                bfsQueue.add(new int[] {subHeight, subWidth, 0 , (thisQueue[3]+1)});
                            }else if(board[subHeight][subWidth] == 2){
                                firstVisit[subHeight][subWidth] = (thisQueue[3]+1);
                                bfsQueue.add(new int[] {subHeight, subWidth, 1, (thisQueue[3]+1)});
                            }
                        }
                    }else{
                        if(secondVisit[subHeight][subWidth] == 0){
                            secondVisit[subHeight][subWidth] = (thisQueue[3]+1);
                            bfsQueue.add(new int[] {subHeight, subWidth, 1, (thisQueue[3]+1)});
                        }
                    }
                }
            }
        }
    }

}
