package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질2 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        int startNum = Integer.parseInt(firstLine[0]);
        int goalNum = Integer.parseInt(firstLine[1]);

        int[] visitList = new int[100001];
        for(int i = 0 ; i < 100001 ; i++){
            visitList[i] = -1;
        }
        visitList[startNum] = 1;

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {startNum, 0});

        int resultLen = 0;
        int resultNum = 0;
        if(startNum == goalNum){
            resultNum = 1;
        }else{
            while(!bfsQueue.isEmpty()){
                int[] thisQueue = bfsQueue.poll();

                for(int i = 0 ; i < 3 ; i++){
                    int subRoot = 0;
                    if(i == 0){
                        subRoot = (thisQueue[0] + 1);
                    }else if(i == 1){
                        subRoot = (thisQueue[0] - 1);
                    }else{
                        subRoot = (thisQueue[0]*2);
                    }

                    if(subRoot >= 0 && subRoot < 100001){
                        if(visitList[subRoot] == -1 || visitList[subRoot] == (thisQueue[1]+1)){
                            visitList[subRoot] = (thisQueue[1]+1);
                            bfsQueue.add(new int[] {subRoot, (thisQueue[1]+1)});
                        }
                        if(subRoot == goalNum && visitList[subRoot] == (thisQueue[1]+1)){
                            resultLen = visitList[subRoot];
                            resultNum += 1;
                        }
                    }
                }
            }
        }

        br.close();
        bw.write(resultLen + "\n" + resultNum);
        bw.flush();
        bw.close();

    }

}
