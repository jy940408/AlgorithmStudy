package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 스타트링크 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean resultCheck = false;
    static int result, allFloor, nowFloor, goalFloor, upFloor, downFloor;
    public static void main(String[] args) throws IOException{
        
        String[] firstLine = (br.readLine()).split(" ");
        allFloor = Integer.parseInt(firstLine[0]);
        nowFloor = Integer.parseInt(firstLine[1]);
        goalFloor = Integer.parseInt(firstLine[2]);
        upFloor = Integer.parseInt(firstLine[3]);
        downFloor = Integer.parseInt(firstLine[4]);

        boolean[] visitList = new boolean[(allFloor+1)];

        bfs(nowFloor, visitList);

        if(resultCheck){
            bw.write(result + "");
        }else{
            bw.write("use the stairs");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int root, boolean[] visitList){

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {root, 0});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();
            int thisRoot = thisQueue[0];

            if (thisRoot == goalFloor){
                result = thisQueue[1];
                resultCheck = true;
                return;
            }

            if((thisRoot + upFloor) >= 1 && (thisRoot + upFloor) < (allFloor+1)){
                if(!visitList[(thisRoot+upFloor)]){
                    visitList[(thisRoot+upFloor)] = true;
                    bfsQueue.add(new int[] {(thisRoot+upFloor), (thisQueue[1]+1)});
                }
            }

            if((thisRoot - downFloor) >= 1 && (thisRoot - downFloor) < (allFloor+1)){
                if(!visitList[(thisRoot-downFloor)]){
                    visitList[(thisRoot-downFloor)] = true;
                    bfsQueue.add(new int[] {(thisRoot-downFloor), (thisQueue[1]+1)});
                }
            }
        }
    }
}
