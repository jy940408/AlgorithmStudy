package JAVAGreedy;

import java.util.Scanner;

public class 화분부수기 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int potNum = Integer.parseInt(scan.nextLine());

        int result = 0;
        boolean[] board = new boolean[1000001];
        for(int i = 0 ; i < potNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            if(!board[Integer.parseInt(firstLine[0])] && !board[Integer.parseInt(firstLine[1])] && !board[Integer.parseInt(firstLine[2])]){
                result++;
            }

            board[Integer.parseInt(firstLine[0])] = true;
            board[Integer.parseInt(firstLine[1])] = true;
            board[Integer.parseInt(firstLine[2])] = true;
        }

        System.out.println(result);

    }

}
