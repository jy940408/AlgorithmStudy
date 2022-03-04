package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Knight {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String[] start = (scan.nextLine()).split("");
    String[] goal = (scan.nextLine()).split("");
    int startHeight = (start[0].charAt(0) - 96), startWidth = Integer.parseInt(start[1]);
    int goalHeight = (goal[0].charAt(0) - 96), goalWidth = Integer.parseInt(goal[1]);

    boolean[][] board = new boolean[9][9];
    board[startHeight][startWidth] = true;

    int[] upDown = { -1, -2, -2, -1, 1, 2, 2, 1 };
    int[] leftRight = { -2, -1, 1, 2, -2, -1, 1, 2 };

    Queue<int[]> bfsQueue = new LinkedList<>();
    bfsQueue.add(new int[] { startHeight, startWidth, 0 });
    int result = 0;
    while (!bfsQueue.isEmpty()) {
      int[] thisQueue = bfsQueue.poll();

      if (thisQueue[0] == goalHeight && thisQueue[1] == goalWidth) {
        result = thisQueue[2];
        break;
      }

      for (int i = 0; i < 8; i++) {
        int thisHeight = (thisQueue[0] + upDown[i]);
        int thisWidth = (thisQueue[1] + leftRight[i]);

        if (thisHeight >= 1 && thisHeight < 9 && thisWidth >= 1 && thisWidth < 9) {
          if (!board[thisHeight][thisWidth]) {
            board[thisHeight][thisWidth] = true;
            bfsQueue.add(new int[] { thisHeight, thisWidth, (thisQueue[2] + 1) });
          }
        }
      }
    }

    System.out.println(result);

  }

}
