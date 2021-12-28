package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기 {
    
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        
        String[] firstLine = (br.readLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        int[][] board = new int[height][width];
        int[][][] visitList = new int[height][width][2];
        visitList[0][0][1] = 1;

        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, 1, 0});

        int result = -1;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == (height-1) && thisQueue[1] == (width-1)){
                result = visitList[thisQueue[0]][thisQueue[1]][thisQueue[2]];
                break;
            }

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){

                    if(board[subHeight][subWidth] == 1 && thisQueue[2] == 1){
                        visitList[subHeight][subWidth][0] = (visitList[thisQueue[0]][thisQueue[1]][thisQueue[2]] + 1);
                        bfsQueue.add(new int[] {subHeight, subWidth, 0 , (thisQueue[3]+1)});
                    }else if(board[subHeight][subWidth] == 0 && visitList[subHeight][subWidth][thisQueue[2]] == 0){
                        visitList[subHeight][subWidth][thisQueue[2]] = (visitList[thisQueue[0]][thisQueue[1]][thisQueue[2]] + 1);
                        bfsQueue.add(new int[] {subHeight, subWidth, thisQueue[2], (thisQueue[3] + 1)});
                    }

                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

}
