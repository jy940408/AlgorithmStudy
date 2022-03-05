package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Yourlife {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = (br.readLine()).split(" ");
        int situationNum = Integer.parseInt(firstLine[0]);
        int changeNum = Integer.parseInt(firstLine[1]);

        ArrayList[] board = new ArrayList[situationNum+1];
        for(int i = 0 ; i < situationNum+1 ; i++){
            board[i] = new ArrayList<>();
        }
        boolean[] visitList = new boolean[situationNum+1];

        for(int i = 0 ; i < changeNum ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            board[Integer.parseInt(secondLine[0])].add(Integer.parseInt(secondLine[1]));
        }

        visitList[1] = true;
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {1, 0});

        int result = -1;
        loop:
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < board[thisQueue[0]].size() ; i++){
                int thisNum = (int)board[thisQueue[0]].get(i);
                if(!visitList[thisNum]){
                    visitList[thisNum] = true;
                    bfsQueue.add(new int[] {thisNum, (thisQueue[1]+1)});
                
                    if(thisNum == situationNum){
                        result = (thisQueue[1]+1);
                        break loop;
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
