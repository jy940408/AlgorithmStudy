package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 지금만나러갑니다 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        int length = Integer.parseInt(firstLine[0]);
        int firstNum = Integer.parseInt(firstLine[1]);
        int secondNum = Integer.parseInt(firstLine[2]);
        
        ArrayList[][] board = new ArrayList[length+1][2];
        for(int i = 0 ; i < (length+1) ; i++){
            board[i][0] = new ArrayList<Integer>();
            board[i][1] = new ArrayList<Integer>();
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {0, 0, firstNum});
        bfsQueue.add(new int[] {1, 0, secondNum});
        board[firstNum][0].add(0);
        board[secondNum][1].add(0);

        int result = 0;
        boolean resultCheck = false;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if((thisQueue[1]+1) > 20){
                break;
            }

            for(int i = 0 ; i < 2 ; i++){
                int subRoot = 0;
                if(i == 0){
                    subRoot = (thisQueue[2] + (int)Math.pow(2, thisQueue[1]));
                }else {
                    subRoot = (thisQueue[2] - (int)Math.pow(2, thisQueue[1]));
                }

                if(subRoot >= 1 && subRoot < (length+1)){
                    board[subRoot][thisQueue[0]].add(thisQueue[1]+1);
                    bfsQueue.add(new int[] {thisQueue[0], (thisQueue[1]+1), subRoot});

                    int idx = 0;
                    if(thisQueue[0] == 0){
                        idx = 1;
                    }else{
                        idx = 0;
                    }

                    for(int j = 0 ; j < board[subRoot][idx].size() ; j++){
                        if((thisQueue[1]+1) == (int)board[subRoot][idx].get(j)){
                            result = (thisQueue[1] + 1);
                            resultCheck = true;
                            break loop;
                        }
                    }
                }
            }
        }

        if(resultCheck){
            bw.write(result + "");
        }else{
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
