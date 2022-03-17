package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 우리집엔도서관이있어 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        int bookNum = Integer.parseInt(br.readLine());

        int[] board = new int[bookNum];
        for(int i = 0 ; i < bookNum ; i++){
            board[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int thisBook = bookNum;
        for(int i = (bookNum-1) ; i > -1 ; i--){
            if(board[i] == thisBook){
                thisBook--;
                result++;
            }
        }

        System.out.println((bookNum-result));

    }

}
