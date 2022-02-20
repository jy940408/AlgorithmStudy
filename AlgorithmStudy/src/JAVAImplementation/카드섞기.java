package JAVAImplementation;

import java.util.Scanner;

public class 카드섞기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int cardNum = Integer.parseInt(scan.nextLine());

        int[] orderList = new int[cardNum];
        int[] shuffleList = new int[cardNum];
        int[] cardList = new int[cardNum];
        int[] subList = new int[cardNum];

        String[] firstLine = (scan.nextLine()).split(" ");
        String[] secondLine = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < cardNum ; i++){
            orderList[i] = Integer.parseInt(firstLine[i]);
            shuffleList[i] = Integer.parseInt(secondLine[i]);
            cardList[i] = i;
            subList[i] = i;
        }

        int result = 0;
        boolean subCheck = true;
        boolean firstCheck = true;

        for(int i = 0 ; i < cardNum ; i++){
            if(orderList[i] != (cardList[i]%3)){
                firstCheck = false;
                break;
            }
        }

        if(!firstCheck){
            while(true){
                result++;

                for(int i = 0 ; i < cardNum ; i++){
                    subList[i] = cardList[shuffleList[i]];
                }

                for(int i = 0 ; i < cardNum ; i++){
                    cardList[i] = subList[i];
                }

                boolean resultCheck = true;
                for(int i = 0 ; i < cardNum ; i++){
                    if(orderList[i] != (cardList[i]%3)){
                        resultCheck = false;
                        break;
                    }
                }

                for(int i = 0 ; i < cardNum ; i++){
                    if(cardList[i] == i){
                        if(i == (cardNum - 1)){
                            subCheck = false;
                            break;
                        }
                    }else{
                        break;
                    }
                }

                if(resultCheck || !subCheck){
                    break;
                }
            }
        }

        if(subCheck){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }

}
