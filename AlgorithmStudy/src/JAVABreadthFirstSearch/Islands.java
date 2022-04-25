package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Islands {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0};
    static int[] leftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        String[][] board = new String[height][width];
        boolean[][] visitList = new boolean[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (br.readLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = secondLine[j];
            }
        }

        int result = 0;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(board[i][j].equals("C") || board[i][j].equals("L")){
                    if(!visitList[i][j]){
                        visitList[i][j] = true;
                        Queue<int[]> bfsQueue = new LinkedList<>();
                        bfsQueue.add(new int[] {i, j});

                        boolean lCheck = false;
                        if(board[i][j].equals("L")){
                            lCheck = true;
                        }

                        while(!bfsQueue.isEmpty()){
                            int[] thisQueue = bfsQueue.poll();

                            for(int k = 0 ; k < 4 ; k++){
                                int thisHeight = (thisQueue[0] + upDown[k]);
                                int thisWidth = (thisQueue[1] + leftRight[k]);

                                if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                                    if(board[thisHeight][thisWidth].equals("L") || board[thisHeight][thisWidth].equals("C")){
                                        if(!visitList[thisHeight][thisWidth]){
                                            visitList[thisHeight][thisWidth] = true;

                                            if(board[thisHeight][thisWidth].equals("L")){
                                                lCheck = true;
                                            }

                                            bfsQueue.add(new int[] {thisHeight, thisWidth});
                                        }
                                    }
                                }
                            }
                        }

                        if(lCheck){
                            result += 1;
                        }
                    }
                }
            }
        }
        
        System.out.println(result);

    }

}
