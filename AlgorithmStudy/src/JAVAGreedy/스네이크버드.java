package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class 스네이크버드 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String[] firstLine = (scan.nextLine()).split(" ");
        int fruitNum = Integer.parseInt(firstLine[0]), snakebird = Integer.parseInt(firstLine[1]);

        int[] fruitList = new int[fruitNum];
        String[] secondLine = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < fruitNum ; i++){
            fruitList[i] = Integer.parseInt(secondLine[i]);
        }
        Arrays.sort(fruitList);

        for(int i = 0 ; i < fruitNum ; i++){
            if(snakebird >= fruitList[i]){
                snakebird++;
            }
        }

        System.out.println(snakebird);

    }

}
