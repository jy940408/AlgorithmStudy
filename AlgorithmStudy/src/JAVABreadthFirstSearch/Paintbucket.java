package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Paintbucket {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] upDown = { -1, 1, 0, 0 };
    int[] leftRight = { 0, 0, -1, 1 };

    String[] firstLine = (br.readLine()).split(" ");
    int height = Integer.parseInt(firstLine[0]), width = Integer.parseInt(firstLine[1]);

    int[][] board = new int[height][width];
    boolean[][] visitList = new boolean[height][width];
    for (int i = 0; i < height; i++) {
      String[] secondLine = (br.readLine()).split("");
      for (int j = 0; j < width; j++) {
        board[i][j] = Integer.parseInt(secondLine[j]);
      }
    }

    String[] thirdLine = (br.readLine()).split(" ");
    int startHeight = Integer.parseInt(thirdLine[0]), startWidth = Integer.parseInt(thirdLine[1]),
        colorNum = Integer.parseInt(thirdLine[2]);
    Queue<int[]> bfsQueue = new LinkedList<>();
    bfsQueue.add(new int[] { startHeight, startWidth, board[startHeight][startWidth] });
    board[startHeight][startWidth] = colorNum;
    visitList[startHeight][startWidth] = true;

    while (!bfsQueue.isEmpty()) {
      int[] thisQueue = bfsQueue.poll();

      for (int i = 0; i < 4; i++) {
        int thisHeight = (thisQueue[0] + upDown[i]);
        int thisWidth = (thisQueue[1] + leftRight[i]);

        if (thisHeight >= 0 && thisHeight < height && thisWidth >= 0 && thisWidth < width) {
          if (board[thisHeight][thisWidth] == thisQueue[2]) {
            if (!visitList[thisHeight][thisWidth]) {
              visitList[thisHeight][thisWidth] = true;
              board[thisHeight][thisWidth] = colorNum;

              bfsQueue.add(new int[] { thisHeight, thisWidth, thisQueue[2] });
            }
          }
        }
      }
    }

    StringBuffer result = new StringBuffer();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        result.append(board[i][j]);
      }
      result.append("\n");
    }

    br.close();
    bw.write(result.toString());
    bw.flush();
    bw.close();
  }

}
