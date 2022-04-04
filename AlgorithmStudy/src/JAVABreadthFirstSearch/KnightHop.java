package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightHop {

  public static void main(String[] args) {

    int[] upDown = { -1, -2, -2, -1, 1, 2, 2, 1 };
    int[] leftRight = { -2, -1, 1, 2, -2, -1, 1, 2 };

    Scanner scan = new Scanner(System.in);

    String[] firstLine = (scan.nextLine()).split(" ");
    int startHeight = Integer.parseInt(firstLine[0]), startWidth = Integer.parseInt(firstLine[1]);

    String[] secondLine = (scan.nextLine()).split(" ");
    int goalHeight = Integer.parseInt(secondLine[0]), goalWidth = Integer.parseInt(secondLine[1]);

    boolean[][] visitList = new boolean[9][9];

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
          if (!visitList[thisHeight][thisWidth]) {
            visitList[thisHeight][thisWidth] = true;
            bfsQueue.add(new int[] { thisHeight, thisWidth, (thisQueue[2] + 1) });
          }
        }
      }
    }

    System.out.println(result);

  }

}
