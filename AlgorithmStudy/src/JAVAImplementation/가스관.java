package JAVAImplementation;

import java.util.Scanner;

public class 가스관 {
    
    public static void main(String[] args) {
        
        int[] upDown = {-1, 1, 0, 0};
        int[] leftRight = {0, 0, -1, 1};
        int[] sideCheck = {1, 0, 3, 2};
        String[] markList = {"|", "-", "+", "1", "2", "3", "4", "M", "Z"};
        int[][] markSideList = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 1, 0, 1}, {1, 0, 0, 1}, 
                                {1, 0, 1, 0}, {0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);
        
        String[][][] board = new String[height][width][4];
        String[][] originBoard = new String[height][width];

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    board[i][j][k] = "0";
                }
            }
        }

        String result = "";
        int[] resultLocation = {-1, -1};
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                originBoard[i][j] = secondLine[j];

                for(int k = 0 ; k < 9 ; k++){
                    if(secondLine[j].equals(markList[k])){
                        for(int l = 0 ; l < 4 ; l++){
                            board[i][j][l] = Integer.toString(markSideList[k][l]);
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                int[] subList = {0, 0, 0, 0};
                int subCheck = 0;
                int mLocation = -1;
                int zLocation = -1;

                if(originBoard[i][j].equals(".")){
                    for(int k = 0 ; k < 4 ; k++){
                        int subHeight = (i + upDown[k]);
                        int subWidth = (j + leftRight[k]);

                        if(subHeight >= 0 && subHeight < height && subWidth >= 0 &&  subWidth < width){
                            subList[k] = Integer.parseInt(board[subHeight][subWidth][sideCheck[k]]);
                            if(originBoard[subHeight][subWidth].equals("M")){
                                mLocation = k;
                            }else if(originBoard[subHeight][subWidth].equals("Z")){
                                zLocation = k;
                            }

                            if(subList[k] == 1){
                                subCheck++;
                            }
                        }
                    }

                }

                if(mLocation != -1 && zLocation != -1){
                    subList[mLocation] = 0;
                    subList[zLocation] = 0;
                }

                if(subCheck > 1){
                    for(int k = 0 ; k < 7 ; k++){
                        boolean thisCheck = true;
                        for(int l = 0 ; l < 4 ; l++){
                            if(subList[l] != markSideList[k][l]){
                                thisCheck = false;
                                break;
                            }
                        }

                        if(thisCheck){
                            result = markList[k];
                            resultLocation = new int[] {i, j};
                            break;
                        }
                    }
                }
            }
        }

        System.out.println((resultLocation[0]+1) + " " + (resultLocation[1]+1) + " " + result);

    }

}
