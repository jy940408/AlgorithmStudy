package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class 숨바꼭질3 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{

        String[] firstLine = (br.readLine()).split(" ");
        int startNum = Integer.parseInt(firstLine[0]);
        int goalNum = Integer.parseInt(firstLine[1]);
        boolean[] visitList = new boolean[100001];

        LinkedList<int[]> bfsDeque = new LinkedList<>();
        bfsDeque.add(new int[] {startNum, 0});
        int result = 0;

        while(!bfsDeque.isEmpty()){
            int[] thisDeque = bfsDeque.poll();
            int thisRoot = thisDeque[0];
            System.out.println("thisRoot: " + thisRoot);

            if(thisRoot == goalNum){
                result = thisDeque[1];
                break;
            }

            if((thisRoot*2) >= 0 && (thisRoot*2) < 100001){
                if(!visitList[(thisRoot*2)]){
                    visitList[(thisRoot*2)] = true;
                    bfsDeque.addFirst(new int[] {(thisRoot*2), thisDeque[1]});
                }
            }
            if((thisRoot+1) >= 0 && (thisRoot+1) < 100001){
                if(!visitList[(thisRoot+1)]){
                    visitList[(thisRoot+1)] = true;
                    bfsDeque.offer(new int[] {(thisRoot+1), (thisDeque[1]+1)});
                }
            }
            if((thisRoot-1) >= 0 && (thisRoot-1) < 100001){
                if(!visitList[(thisRoot-1)]){
                    visitList[(thisRoot-1)] = true;
                    bfsDeque.offer(new int[] {(thisRoot-1), (thisDeque[1]+1)});
                }
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

}
