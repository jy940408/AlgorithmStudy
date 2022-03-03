package JAVABreadthFirstSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연산4 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String[] firstLine = (scan.nextLine()).split(" ");
    int startNum = Integer.parseInt(firstLine[0]);
    int goalNum = Integer.parseInt(firstLine[1]);
    HashMap<Long, Boolean> visitMap = new HashMap<>();

    String[] operatorList = { "*", "+", "-", "/" };

    Queue<String[]> bfsQueue = new LinkedList<>();
    bfsQueue.add(new String[] { Integer.toString(startNum), "" });
    String result = "-1";

    if (startNum == goalNum) {
      result = "0";
    }

    if (result.equals("-1")) {
      while (!bfsQueue.isEmpty()) {
        String[] thisQueue = bfsQueue.poll();
        Long thisNum = Long.parseLong(thisQueue[0]);
        if (thisNum == goalNum) {
          result = thisQueue[1];
          break;
        }

        for (int i = 0; i < 4; i++) {
          if (i == 0) {
            if ((thisNum * thisNum) <= 1000000000 && !visitMap.containsKey((thisNum * thisNum))) {
              bfsQueue.add(new String[] { Long.toString(thisNum * thisNum), (thisQueue[1] + operatorList[i]) });
              visitMap.put((thisNum * thisNum), true);
            }
          } else if (i == 1) {
            if ((thisNum + thisNum) <= 1000000000 && !visitMap.containsKey((thisNum + thisNum))) {
              bfsQueue.add(new String[] { Long.toString(thisNum + thisNum), (thisQueue[1] + operatorList[i]) });
              visitMap.put((thisNum + thisNum), true);
            }
          } else if (i == 2) {
            if ((thisNum - thisNum) >= 0 && !visitMap.containsKey((thisNum - thisNum))) {
              bfsQueue.add(new String[] { Long.toString(thisNum - thisNum), (thisQueue[1] + operatorList[i]) });
              visitMap.put((thisNum - thisNum), true);
            }
          } else {
            if (thisNum != 0) {
              if (!visitMap.containsKey((thisNum / thisNum))) {
                bfsQueue.add(new String[] { Long.toString(thisNum / thisNum), (thisQueue[1] + operatorList[i]) });
                visitMap.put((thisNum / thisNum), true);
              }
            }
          }
        }
      }
    }

    System.out.println(result);

  }

}
