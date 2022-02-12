package JAVAImplementation;

import java.util.ArrayList;
import java.util.Scanner;

public class 으어어에이쁠주세요 {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());
        String[] orderList = (scan.nextLine()).split("");

        String[][][] board = new String[length][length][2];
        int[][] zombieBoard = new int[length][length];
        ArrayList<int[]> zombieList = new ArrayList<int[]>();
        for(int i = 0 ; i < length ; i++){
            String[] firstLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < length ; j++){
                board[i][j][0] = firstLine[j];
                board[i][j][1] = "D";
                if(board[i][j][0].equals("Z")){
                    zombieBoard[i][j]++;
                    zombieList.add(new int[] {i, j, 0});
                }
            }
        }

        int[] upDown = {1, 0, -1, 0, -1, -1, 1, 1};
        int[] leftRight = {0, 1, 0, -1, -1, 1, -1, 1};

        int[] thisLocation = new int[3];
        boolean resultCheck = true;
        loop:
        for(String i: orderList){
            if(i.equals("F")){
                int subUpDown = (thisLocation[0] + upDown[thisLocation[2]]);
                int subLeftRight = (thisLocation[1] + leftRight[thisLocation[2]]);

                if(subUpDown >= 0 && subUpDown < length && subLeftRight >= 0 && subLeftRight < length){
                    thisLocation[0] = subUpDown;
                    thisLocation[1] = subLeftRight;

                    if(board[thisLocation[0]][thisLocation[1]][0].equals("S")){
                        board[thisLocation[0]][thisLocation[1]][1] = "B";
                        
                        for(int j = 0 ; j < 8 ; j++){
                            int lightUpDown = (thisLocation[0] + upDown[j]);
                            int lightLeftRight = (thisLocation[1] + leftRight[j]);

                            if(lightUpDown >= 0 && lightUpDown < length && lightLeftRight >= 0 && lightLeftRight < length){    
                                board[lightUpDown][lightLeftRight][1] = "B";
                            }
                        }
                    }

                    if(zombieBoard[thisLocation[0]][thisLocation[1]] != 0){
                        if(board[thisLocation[0]][thisLocation[1]][1].equals("D")){
                            resultCheck = false;
                            break;
                        }
                    }  
                }

            }else if(i.equals("L")){
                if(thisLocation[2] == 3){
                    thisLocation[2] = 0;
                }else{
                    thisLocation[2]++;
                }

            }else if(i.equals("R")){
                if(thisLocation[2] == 0){
                    thisLocation[2] = 3;
                }else{
                    thisLocation[2]--;
                }
            }

            for(int j = 0 ; j < zombieList.size() ; j++){
                int zombieUpDown = (zombieList.get(j)[0] + upDown[zombieList.get(j)[2]]);

                if(zombieUpDown >= 0 && zombieUpDown < length){
                    zombieBoard[zombieList.get(j)[0]][zombieList.get(j)[1]]--;
                    zombieList.get(j)[0] = zombieUpDown;
                    zombieBoard[zombieList.get(j)[0]][zombieList.get(j)[1]]++;

                    if(zombieBoard[thisLocation[0]][thisLocation[1]] != 0){
                        if(board[thisLocation[0]][thisLocation[1]][1].equals("D")){
                            resultCheck = false;
                            break loop;
                        }
                    }

                }else{
                    if(zombieList.get(j)[2] == 0){
                        zombieList.get(j)[2] = 2;
                    }else{
                        zombieList.get(j)[2] = 0;
                    }
                }
            }

        }

        if(resultCheck){
            System.out.println("Phew...");
        }else{
            System.out.println("Aaaaaah!");
        }
    }

}
