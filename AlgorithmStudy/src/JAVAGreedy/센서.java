package JAVAGreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 센서 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int sensorNum = Integer.parseInt(scan.nextLine());
        int centerNum = Integer.parseInt(scan.nextLine());
        
        String[] firstLine = (scan.nextLine()).split(" ");

        ArrayList<Integer> sensorList = new ArrayList<>();
        for(int i = 0 ; i < sensorNum ; i++){
            sensorList.add(Integer.parseInt(firstLine[i]));
        }
        Collections.sort(sensorList);

        int[] lengthList = new int[(sensorList.size()-1)];
        for(int i = 1 ; i < sensorList.size() ; i++){
            lengthList[(i-1)] = (sensorList.get(i) - sensorList.get(i-1));
        }
        Arrays.sort(lengthList);

        int result = 0;
        for(int i = 0 ; i < (lengthList.length - (centerNum-1)) ; i++){
            result += lengthList[i];
        }

        System.out.println(result);

    }

}
