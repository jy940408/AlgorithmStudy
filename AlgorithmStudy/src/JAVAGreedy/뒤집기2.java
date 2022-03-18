package JAVAGreedy;

import java.util.Scanner;

public class 뒤집기2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

        int[][] board = new int[height][width];
        for(int i = 0 ; i < height ; i++){
            String[] secondLine = (scan.nextLine()).split("");
            for(int j = 0 ; j < width ; j++){
                board[i][j] = Integer.parseInt(secondLine[j]);
            }
        }

        int result = 0;
        for(int i = (height-1) ; i > -1 ; i--){
            for(int j = (width-1) ; j > -1 ; j--){
                if(board[i][j] == 1){
                    result++;

                    for(int k = 0 ; k < (i+1) ; k++){
                        for(int l = 0 ; l < (j+1) ; l++){
                            if(board[k][l] == 0){
                                board[k][l] = 1;
                            }else{
                                board[k][l] = 0;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}
