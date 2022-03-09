package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 돌그룹 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int firstNum = Integer.parseInt(firstLine[0]);
        int secondNum = Integer.parseInt(firstLine[1]);
        int thirdNum = Integer.parseInt(firstLine[2]);

        int allNum = (firstNum + secondNum + thirdNum);
        boolean[][] visitList = new boolean[allNum+1][allNum+1];

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[] {firstNum, secondNum, thirdNum});

        int result = 0;
        while(!bfsQueue.isEmpty()){
            int[] thisQueue = bfsQueue.poll();

            if(thisQueue[0] == thisQueue[1] && thisQueue[0] == thisQueue[2] && thisQueue[1] == thisQueue[2]){
                result = 1;
                break;
            }

            for(int i = 0 ; i < 3 ; i++){
                int[] subQueue = {thisQueue[0], thisQueue[1], thisQueue[2]};
                if(thisQueue[i%3] != thisQueue[(i+1)%3]){
                    if(thisQueue[i%3] > thisQueue[(i+1)%3]){
                        subQueue[i%3] -= thisQueue[(i+1)%3];
                        subQueue[(i+1)%3] += thisQueue[(i+1)%3];
                    
                    }else{
                        subQueue[i%3] += thisQueue[i%3];
                        subQueue[(i+1)%3] -= thisQueue[i%3];
                    }

                    int maxNum = Math.max(Math.max(subQueue[0], subQueue[1]), subQueue[2]);
                    int minNum = Math.min(Math.min(subQueue[0], subQueue[1]), subQueue[2]);

                    if(!visitList[maxNum][minNum]){
                        visitList[maxNum][minNum] = true;
                        bfsQueue.add(new int[] {subQueue[0], subQueue[1], subQueue[2]});
                    }
                }
            }
        }

        System.out.println(result);

    }

}
