package JAVAGreedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 모두의마블 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int cardNum = Integer.parseInt(scan.nextLine());

        Integer[] cardList = new Integer[cardNum];
        String[] card = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < cardNum ; i++){
            cardList[i] = Integer.parseInt(card[i]);
        }

        Arrays.sort(cardList, Collections.reverseOrder());

        int result = 0;
        for(int i = 1 ; i < cardNum ; i++){
            result += (cardList[0] + cardList[i]);
        }

        System.out.println(result);

    }

}
