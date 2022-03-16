package JAVADepthFirstSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class 작업 {
    
    static int result = 0;
    static boolean[] visitList;

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String[] firstLine = (scan.nextLine()).split(" ");
        int workNum = Integer.parseInt(firstLine[0]), orderNum = Integer.parseInt(firstLine[1]);

        ArrayList<Integer>[] board = new ArrayList[workNum+1];
        visitList = new boolean[workNum+1];
        for(int i = 0 ; i < workNum+1 ; i++){
            board[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < orderNum ; i++){
            String[] secondLine = (scan.nextLine()).split(" ");
            board[Integer.parseInt(secondLine[1])].add(Integer.parseInt(secondLine[0]));
        }

        int goalWork = Integer.parseInt(scan.nextLine());

        dfsCheck(goalWork, board);
        System.out.println(result);

    }

    private static void dfsCheck(int thisWork, ArrayList<Integer>[] board){

        if(board[thisWork].size() == 0){
            return;
        }

        for(Object i: board[thisWork]){
            if(!visitList[(int)i]){
                visitList[(int)i] = true;
                result++;
                dfsCheck((int)i, board);
            }
        }

    }

}
