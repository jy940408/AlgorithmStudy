package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] orderList = {"D", "S", "L", "R"};
        int roundNum = Integer.parseInt(scan.nextLine());

        String allResult = "";
        for(int i = 0 ; i < roundNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            int startNum = Integer.parseInt(firstLine[0]), goalNum = Integer.parseInt(firstLine[1]);
            boolean[] visitList = new boolean[10000];
            visitList[startNum] = true;
            
            Queue<String[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new String[] {Integer.toString(startNum), ""});
            String result = "";
            loop:
            while(!bfsQueue.isEmpty()){
                String[] thisQueue = bfsQueue.poll();
                int thisNum = Integer.parseInt(thisQueue[0]);

                for(int j = 0 ; j < 4 ; j++){
                    int subNum = 0;

                    if(orderList[j].equals("D")){
                        subNum = (thisNum*2)%10000;
                    }else if(orderList[j].equals("S")){
                        if(thisNum != 0){
                            subNum = thisNum-1;
                        }else{
                            subNum = 9999;
                        }
                    }else if(orderList[j].equals("L")){
                        subNum = (((thisNum%1000)*10) + thisNum/1000);
                    }else if(orderList[j].equals("R")){
                        subNum = (((thisNum%10)*1000) + thisNum/10);
                    }

                    if(!visitList[subNum]){
                        if(subNum != goalNum){
                            visitList[subNum] = true;
                            bfsQueue.add(new String[] {Integer.toString(subNum), (thisQueue[1] + orderList[j])});
                        }else{
                            visitList[subNum] = true;
                            result = (thisQueue[1] + orderList[j]);
                            break loop;
                        }
                    }
                }
            }

            allResult += result + "\n";
        }

        System.out.println(allResult);

    }

}
