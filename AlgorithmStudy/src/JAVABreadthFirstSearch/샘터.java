package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 샘터 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        int waterNum = Integer.parseInt(firstLine[0]);
        int houseNum = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = (br.readLine()).split(" ");
        HashMap<Integer, Boolean> visitList = new HashMap<Integer, Boolean>();
        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < waterNum ; i++){
            visitList.put(Integer.parseInt(secondLine[i]), true);
            bfsQueue.add(new int[] {Integer.parseInt(secondLine[i]), 0});
        }

        int[] leftRight = {-1, 1};

        int result = 0, thisHouse = 0;
        loop:
        while(thisHouse != houseNum){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 2 ; i++){
                int subIdx = (thisQueue[0] + leftRight[i]);

                if(!visitList.containsKey(subIdx)){
                    visitList.put(subIdx, true);
                    bfsQueue.add(new int[] {subIdx, (thisQueue[1]+1)});
                    thisHouse++;

                    if(thisHouse <= houseNum){
                        result += (thisQueue[1] + 1);
                    }else{
                        break loop;
                    }
                }
            }
        }

        System.out.println(result);

    }

}
