package JAVAGreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 배 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int crainNum = Integer.parseInt(scan.nextLine());
        String[] firstLine = (scan.nextLine()).split(" ");
        Integer[] crainList = new Integer[crainNum];
        for(int i = 0 ; i < crainNum ; i++){
            crainList[i] = Integer.parseInt(firstLine[i]);
        }
        Arrays.sort(crainList, Collections.reverseOrder());

        int boxNum = Integer.parseInt(scan.nextLine());
        String[] secondLine = (scan.nextLine()).split(" ");
        ArrayList<Integer> boxList = new ArrayList<Integer>();
        for(int i = 0 ; i < boxNum ; i++){
            boxList.add(Integer.parseInt(secondLine[i]));
        }
        Collections.sort(boxList, Collections.reverseOrder());

        if(crainList[0] < boxList.get(0)){
            System.out.println(-1);

        }else{
            int result = 0;
            while(boxList.size() != 0){
                for(int i = 0 ; i < crainNum ; i++){
                    if(boxList.size() == 0){
                        break;
                    }else if(crainList[i] < boxList.get(boxList.size()-1)){
                        break;
                    }else{
                        for(int j = 0 ; j < boxList.size() ; j++){
                            if(crainList[i] >= boxList.get(j)){
                                boxList.remove(j);
                                break;
                            }
                        }
                    }
                }
                
                result++;
            }
            
            System.out.println(result);
        }

    }

}
