package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 뱀과사다리게임 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result;
    static int[] visitList, diceList = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        int ladderNum = Integer.parseInt(firstLine[0]);
        int snakeNum = Integer.parseInt(firstLine[1]);
        visitList = new int[101];

        for(int i = 0 ; i < ladderNum ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            int firstNum = Integer.parseInt(secondLine[0]);
            int secondNum = Integer.parseInt(secondLine[1]);
            visitList[firstNum] = secondNum;
        }
        for(int j = 0 ; j < snakeNum ; j++){
            String[] secondLine = (br.readLine()).split(" ");
            int firstNum = Integer.parseInt(secondLine[0]);
            int secondNum = Integer.parseInt(secondLine[1]);
            visitList[firstNum] = secondNum;
        }

        bfs();

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(){

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {1, 0});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 6 ; i++){
                int subRoot = (thisQueue[0] + diceList[i]);

                if(subRoot >= 1 && subRoot < 101){
                    if(subRoot == 100){
                        result = (thisQueue[1] + 1);
                        return;
                    }
                    if(visitList[subRoot] != -1){
                        if(visitList[subRoot] != 0){
                            bfsQueue.add(new int[] {visitList[subRoot], (thisQueue[1]+1)});
                            visitList[visitList[subRoot]] = -1;
                            visitList[subRoot] = -1;
                        }else{
                            visitList[subRoot] = -1;
                            bfsQueue.add(new int[] {subRoot, (thisQueue[1] + 1)});
                        }
                    }
                }
            }
        }

    }

}
