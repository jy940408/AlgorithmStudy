package JAVABreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CornMaze {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String[] firstLine = (scan.nextLine()).split(" ");
    int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

    int[] upDown = { -1, 1, 0, 0 }, leftRight = { 0, 0, -1, 1 };

    String[][] board = new String[height][width];
    boolean[][] visitList = new boolean[height][width];

    int[][][] slideList = new int[height][width][2];
    int[][] checkList = new int[26][2];
    for (int i = 0; i < 26; i++) {
      checkList[i][0] = -1;
      checkList[i][1] = -1;
    }

    Queue<int[]> bfsQueue = new LinkedList<>();
    for (int i = 0; i < height; i++) {
      String[] secondLine = (scan.nextLine()).split("");
      for (int j = 0; j < width; j++) {
        board[i][j] = secondLine[j];

        if (board[i][j].equals("@")) {
          bfsQueue.add(new int[] { i, j, 0 });

        } else if (!board[i][j].equals("@") && !board[i][j].equals(".") && !board[i][j].equals("=")
            && !board[i][j].equals("#")) {
          if (checkList[board[i][j].charAt(0) - 65][0] != -1) {
            slideList[i][j][0] = checkList[board[i][j].charAt(0) - 65][0];
            slideList[i][j][1] = checkList[board[i][j].charAt(0) - 65][1];
            slideList[checkList[board[i][j].charAt(0) - 65][0]][checkList[board[i][j].charAt(0) - 65][1]][0] = i;
            slideList[checkList[board[i][j].charAt(0) - 65][0]][checkList[board[i][j].charAt(0) - 65][1]][1] = j;

          } else {
            checkList[board[i][j].charAt(0) - 65][0] = i;
            checkList[board[i][j].charAt(0) - 65][1] = j;
          }
        }
      }
    }

    int result = 0;
    while (!bfsQueue.isEmpty()) {
      int[] thisQueue = bfsQueue.poll();

      if (board[thisQueue[0]][thisQueue[1]].equals("=")) {
        result = thisQueue[2];
        break;
      }

      for (int i = 0; i < 4; i++) {
        int thisHeight = (thisQueue[0] + upDown[i]);
        int thisWidth = (thisQueue[1] + leftRight[i]);

        if (thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width) {
          if (!board[thisHeight][thisWidth].equals("#")) {
            if (!visitList[thisHeight][thisWidth]) {
              visitList[thisHeight][thisWidth] = true;

              if (board[thisHeight][thisWidth].equals(".")) {
                bfsQueue.add(new int[] { thisHeight, thisWidth, (thisQueue[2] + 1) });
              } else if (!board[thisHeight][thisWidth].equals(".") && !board[thisHeight][thisWidth].equals("@")
                  && !board[thisHeight][thisWidth].equals("=")) {
                bfsQueue.add(new int[] { slideList[thisHeight][thisWidth][0], slideList[thisHeight][thisWidth][1],
                    (thisQueue[2] + 1) });
              } else {
                bfsQueue.add(new int[] { thisHeight, thisWidth, (thisQueue[2] + 1) });
              }
            }
          }
        }
      }
    }

    System.out.println(result);

  }

}
