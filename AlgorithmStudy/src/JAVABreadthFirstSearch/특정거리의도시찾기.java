package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 특정거리의도시찾기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cityNum, roadNum, minLen, startCity;
    static ArrayList[] board;
    static ArrayList resultList;
    static boolean[] visitList;
    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        cityNum = Integer.parseInt(firstLine[0]);
        roadNum = Integer.parseInt(firstLine[1]);
        minLen = Integer.parseInt(firstLine[2]);
        startCity = Integer.parseInt(firstLine[3]);

        board = new ArrayList[cityNum+1];
        visitList = new boolean[cityNum+1];
        resultList = new ArrayList<Integer>();
        for(int i = 0 ; i < visitList.length ; i++){
            board[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < roadNum ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            board[Integer.parseInt(secondLine[0])].add(Integer.parseInt(secondLine[1]));
        }

        visitList[startCity] = true;
        bfs(startCity);

        Collections.sort(resultList);

        if(resultList.size() != 0){
            for(int i = 0 ; i < resultList.size() ; i++){
                bw.write(resultList.get(i) + "\n");
            }
        }else{
            bw.write(-1 + "");
        }

        br.close();
        bw.flush();
        bw.close();

    }
    
    private static void bfs(int root){

        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int i = 0 ; i < board[root].size() ; i++){
            bfsQueue.add(new int[] {(int)board[root].get(i), 0});
        }

        while(!bfsQueue.isEmpty()){
            int[] thisCity = bfsQueue.poll();
            if(!visitList[thisCity[0]]){
                visitList[thisCity[0]] = true;
                if(thisCity[1] + 1 == minLen){
                    resultList.add(thisCity[0]);
                }

                for(int i = 0 ; i < board[thisCity[0]].size() ; i++){
                    if(!visitList[(int)board[thisCity[0]].get(i)]){
                        bfsQueue.add(new int[] {(int)board[thisCity[0]].get(i), thisCity[1]+1});
                    }
                }

            }
        }

    }
}
