package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int goalNum, result;

    public static void main(String[] args) throws IOException{
        
        goalNum = Integer.parseInt(br.readLine());
        boolean[][] visitList = new boolean[2001][2001];

        bfs(visitList);

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

    private static void bfs(boolean[][] visitList){

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {1, 0, 0});

        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            for(int i = 0 ; i < 3 ; i++){
                int display, clipboard;
                if(i == 0){
                    display = thisQueue[0];
                    clipboard = thisQueue[0];
                }else if(i == 1){
                    display = (thisQueue[0] + thisQueue[1]);
                    clipboard = thisQueue[1];
                }else{
                    display = (thisQueue[0] - 1);
                    clipboard = thisQueue[1];
                }

                if(display == goalNum){
                    result = (thisQueue[2] + 1);
                    return;
                }

                if(display >= 0 && display < 2001 && clipboard >= 0 && clipboard < 2001){
                    if(!visitList[display][clipboard]){
                        visitList[display][clipboard] = true;
                        bfsQueue.add(new int[] {display, clipboard, (thisQueue[2] + 1)});
                    }
                }
            }
        }

    }

}
