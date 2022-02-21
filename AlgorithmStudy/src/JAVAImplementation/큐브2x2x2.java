package JAVAImplementation;

import java.util.Scanner;

public class 큐브2x2x2 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int[] originBoard = new int[25];
        for(int i = 1 ; i < 25 ; i++){
            originBoard[i] = Integer.parseInt(firstLine[i-1]);
        }

        int[][][] turnOrder = {{{1, 24}, {3, 22}, {5, 1}, {7, 3}, {9, 5}, {11, 7},  {22, 11},  {24, 9}},
                                {{1, 5}, {3, 7}, {5, 9}, {7, 11}, {9, 24}, {11, 22}, {22, 3}, {24, 1}},
                                {{2, 6}, {4, 8}, {6, 10}, {8, 12}, {10, 23}, {12, 21}, {21, 4}, {23, 2}},
                                {{2, 23}, {4, 21}, {6, 2}, {8, 4}, {10, 6}, {12, 8}, {21, 12}, {23, 10}},
                                {{13, 5}, {14, 6}, {5, 17}, {6, 18}, {17, 21}, {18, 22}, {21, 13}, {22, 14}},
                                {{13, 21}, {14, 22}, {5, 13}, {6, 14}, {17, 5}, {18, 6}, {21, 17}, {22, 18}},
                                {{15, 23}, {16, 24}, {7, 15}, {8, 16}, {19, 7}, {20, 8}, {23, 19}, {24, 20}},
                                {{15, 7}, {16, 8}, {7, 19}, {8, 20}, {19, 23}, {20, 24}, {23, 15}, {24, 16}},
                                {{3, 17}, {4, 19},  {17, 10}, {19, 9}, {10, 16}, {9, 14}, {16, 3}, {14, 4}},
                                {{3, 16}, {4, 14}, {17, 3}, {19, 4}, {10, 17}, {9, 19}, {16, 10}, {14, 9}},
                                {{1, 18}, {2, 20}, {18, 12}, {20, 11}, {12, 15}, {11, 13}, {15, 1}, {13, 2}},
                                {{1, 15}, {2, 13}, {18, 1}, {20, 2}, {12, 18}, {11, 20}, {15, 12}, {13, 11}}};

        boolean resultCheck = true;
        for(int i = 0 ; i < 12 ; i++){
            resultCheck = true;
            int[] subBoard = new int[25];

            for(int j = 0 ; j < 25 ; j++){
                subBoard[j] = originBoard[j];
            }

            for(int j = 0 ; j < 8 ; j++){
                subBoard[turnOrder[i][j][0]] = originBoard[turnOrder[i][j][1]];
            }

            loop:
            for(int j = 0 ; j < 6 ; j++){
                int checkNum = subBoard[1+(j*4)];
                for(int k = 1 ; k < 5 ; k++){
                    if(checkNum != subBoard[k+(j*4)]){
                        resultCheck = false;
                        break loop;
                    }
                }
            }

            if(resultCheck){
                break;
            }

        }

        if(resultCheck){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}
