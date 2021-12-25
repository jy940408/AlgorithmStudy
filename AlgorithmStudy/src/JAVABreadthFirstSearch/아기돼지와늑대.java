package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 아기돼지와늑대 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[][] board;
    static int height, width;
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);

        board = new String[height][width];
        boolean[][][] visitList = new boolean[height][width][];

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
                if(board[i][j].equals("W")){
                    bfsQueue.add(new int[] {i, j, 0});
                    visitList[i][j] = new boolean[] {true};
                }else if(board[i][j].equals("+")){
                    visitList[i][j] = new boolean[] {false, false, false, false};
                }else {
                    visitList[i][j] = new boolean[] {false};
                }
            }
        }

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int subHeight = (thisQueue[0] + upDown[i]);
                int subWidth = (thisQueue[1] + leftRight[i]);

                if(subHeight >= 0 && subHeight < height && subWidth >= 0 && subWidth < width){
                    if(board[subHeight][subWidth].equals(".")){
                        if(!visitList[subHeight][subWidth][0]){
                            visitList[subHeight][subWidth][0] = true;
                            bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
                        }
                    }else if(board[subHeight][subWidth].equals("+")){
                        if(!visitList[subHeight][subWidth][i]){
                            int[] result = boardCheck(subHeight, subWidth, i);
                            visitList[subHeight][subWidth][i] = true;

                            if(board[result[0]][result[1]].equals(".")){
                                if(!visitList[result[0]][result[1]][0]){
                                    visitList[result[0]][result[1]][0] = true;
                                    bfsQueue.add(new int[] {result[0], result[1], (thisQueue[2]+1)});
                                }
                            }else if(board[result[0]][result[1]].equals("+")){
                                bfsQueue.add(new int[] {result[0], result[1], (thisQueue[2]+1)});
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < height ; i++){
            String result = "";
            for(int j = 0 ; j < width ; j++){
                if(board[i][j].equals(".")){
                    if(!visitList[i][j][0]){
                        board[i][j] = "P";
                    }
                }
                result += board[i][j];
            }
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }

    private static int[] boardCheck(int subHeight, int subWidth, int direction){
        if(direction == 0){
            int thisHeight = subHeight;
            while(!board[thisHeight][subWidth].equals(".") || !board[thisHeight][subWidth].equals("#")){
                thisHeight -= 1;
                if(board[thisHeight][subWidth].equals(".")){
                    return new int[] {thisHeight, subWidth, 0};
                }else if(board[thisHeight][subWidth].equals("#")){
                    return new int[] {(thisHeight+1), subWidth, 1};
                }
            }
        }else if(direction == 1){
            int thisHeight = subHeight;
            while(!board[thisHeight][subWidth].equals(".") || !board[thisHeight][subWidth].equals("#")){
                thisHeight += 1;
                if(board[thisHeight][subWidth].equals(".")){
                    return new int[] {thisHeight, subWidth, 0};
                }else if(board[thisHeight][subWidth].equals("#")){
                    return new int[] {(thisHeight-1), subWidth, 1};
                }
            }
        }else if(direction == 2){
            int thisWidth = subWidth;
            while(!board[subHeight][thisWidth].equals(".") || !board[subHeight][thisWidth].equals("#")){
                thisWidth -= 1;
                if(board[subHeight][thisWidth].equals(".")){
                    return new int[] {subHeight, thisWidth, 0};
                }else if(board[subHeight][thisWidth].equals("#")){
                    return new int[] {subHeight, (thisWidth+1), 1};
                }
            }
        }else if(direction == 3){
            int thisWidth = subWidth;
            while(!board[subHeight][thisWidth].equals(".") || !board[subHeight][thisWidth].equals("#")){
                thisWidth += 1;
                if(board[subHeight][thisWidth].equals(".")){
                    return new int[] {subHeight, thisWidth, 0};
                }else if(board[subHeight][thisWidth].equals("#")){
                    return new int[] {subHeight, (thisWidth-1), 1};
                }
            }
        }

        return new int[] {};
    }

}
