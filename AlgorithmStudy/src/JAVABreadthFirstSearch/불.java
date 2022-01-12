package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 불 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        
        int roundNum = Integer.parseInt(br.readLine());

        String result = "";
        for(int i = 0 ; i < roundNum ; i++){
            String[] firstLine = (br.readLine()).split(" ");
            int width = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]);
            String[][] board = new String[height][width];
            int[][][] visitList = new int[height][width][2];

            int[] person = new int[2];
            Queue<int[]> bfsQueue = new LinkedList<>();
            for(int j = 0 ; j < height ; j++){
                String[] secondLine = (br.readLine()).split("");

                for(int k = 0 ; k < width ; k++){
                    board[j][k] = secondLine[k];

                    if(board[j][k].equals("@")){
                        person = new int[] {j, k};
                        visitList[j][k][0] = -1;
                        visitList[j][k][1] = 0;
                    }else if(board[j][k].equals("*")){
                        bfsQueue.add(new int[] {1, j, k, 0});
                        visitList[j][k][0] = 1;
                        visitList[j][k][1] = 0;
                    }
                }
            }   
            bfsQueue.add(new int[] {-1, person[0], person[1], 0});

            boolean resultCheck = false;
            loop:
            while(!bfsQueue.isEmpty()){
                int[] thisQueue = bfsQueue.poll();

                for(int j = 0 ; j < 4 ; j++){
                    int thisHeight = (thisQueue[1] + upDown[j]);
                    int thisWidth = (thisQueue[2] + leftRight[j]);

                    if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
                        if(visitList[thisHeight][thisWidth][0] == 0 && !board[thisHeight][thisWidth].equals("#")){
                            if(thisQueue[0] == -1){
                                visitList[thisHeight][thisWidth][0] = -1;
                                visitList[thisHeight][thisWidth][1] = (thisQueue[3]+1);
                                bfsQueue.add(new int[] {thisQueue[0], thisHeight, thisWidth, (thisQueue[3]+1)});
                            
                            }else if(thisQueue[0] == 1){
                                visitList[thisHeight][thisWidth][0] = 1;
                                visitList[thisHeight][thisWidth][1] = (thisQueue[3]+1);
                                bfsQueue.add(new int[] {thisQueue[0], thisHeight, thisWidth, (thisQueue[3]+1)});
                            }

                        }else if(visitList[thisHeight][thisWidth][0] == -1){
                            if(thisQueue[0] == 1){
                                visitList[thisHeight][thisWidth][0] = 1;
                                visitList[thisHeight][thisWidth][1] = (thisQueue[3]+1);
                                bfsQueue.add(new int[] {thisQueue[0], thisHeight, thisWidth, (thisQueue[3]+1)});
                            }
                        }
                    
                    }else{
                        if(thisQueue[0] == -1){
                            result += Integer.toString((thisQueue[3] + 1)) + "\n";
                            resultCheck = true;
                            break loop;
                        }
                    }
                }
            }
            
            if(!resultCheck){
                result += "IMPOSSIBLE\n";
            }
        }

        System.out.println(result);

    }

}
