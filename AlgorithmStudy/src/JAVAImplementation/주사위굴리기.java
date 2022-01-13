package JAVAImplementation;

import java.util.Scanner;

public class 주사위굴리기 {
    
    static int height, width;

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        height = Integer.parseInt(firstLine[0]);
        width = Integer.parseInt(firstLine[1]);
        int thisHeight = Integer.parseInt(firstLine[2]);
        int thisWidth = Integer.parseInt(firstLine[3]);
        int roundNum = Integer.parseInt(firstLine[4]);

        int[][] board = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }
        
        int[] orderList = new int[roundNum];
        String[] secondLine = (scan.nextLine()).split(" ");
        for(int i = 0 ; i < roundNum ; i++){
            orderList[i] = Integer.parseInt(secondLine[i]);
        }

        String result = "";
        int[] dice = {0, 0, 0, 0, 0, 0};
        for(int i = 0 ; i < roundNum ; i++){
            int[] thisLocation = locationOrder(thisHeight, thisWidth, orderList[i]);
        
            if(thisLocation[0] != -1 && thisLocation[1] != -1){
                dice = diceOrder(dice, orderList[i]);

                thisHeight = thisLocation[0];
                thisWidth = thisLocation[1];

                if(board[thisHeight][thisWidth] == 0){
                    board[thisHeight][thisWidth] = dice[5];
                }else{
                    dice[5] = board[thisHeight][thisWidth];
                    board[thisHeight][thisWidth] = 0;
                }

                result += (Integer.toString(dice[0]) + "\n");
            }
        }

        System.out.println(result);

    }

    private static int[] diceOrder(int[] dice, int direction){
        int[] subDice = new int[6];
        
        if(direction == 1){
            subDice = new int[] {dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
        }else if(direction == 2){
            subDice = new int[] {dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
        }else if(direction == 3){
            subDice = new int[] {dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
        }else if(direction == 4){
            subDice = new int[] {dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
        }

        return subDice;
    }

    private static int[] locationOrder(int thisHeight, int thisWidth, int direction){
        if(direction == 1){
            thisWidth++;
        }else if(direction == 2){
            thisWidth--;
        }else if(direction == 3){
            thisHeight--;
        }else if(direction == 4){
            thisHeight++;
        }

        int[] subLocation = new int[2];
        if(thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width){
            subLocation = new int[] {thisHeight, thisWidth};
        }else{
            subLocation = new int[] {-1, -1};
        }

        return subLocation;
    }

}
