package JAVAGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 수열의점수 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int listNum = Integer.parseInt(scan.nextLine());
    
        ArrayList<Integer> leftBoard = new ArrayList<>();
        ArrayList<Integer> rightBoard = new ArrayList<>();
        for (int i = 0; i < listNum; i++) {
          int testNum = Integer.parseInt(scan.nextLine());
    
          if (testNum <= 0) {
            leftBoard.add(testNum);
          } else {
            rightBoard.add(testNum);
          }
        }
    
        Collections.sort(leftBoard);
        Collections.sort(rightBoard, Collections.reverseOrder());
    
        long result = 0;
        for (int i = 0; i < leftBoard.size(); i += 2) {
          if (i < (leftBoard.size() - 1)) {
            result += ((long) leftBoard.get(i) * (long) leftBoard.get(i + 1));
    
          } else {
            result += (leftBoard.get(i));
          }
        }
    
        for (int i = 0; i < rightBoard.size(); i += 2) {
          if (i < (rightBoard.size() - 1)) {
            if (rightBoard.get(i) == 1 || rightBoard.get(i + 1) == 1) {
              result += (rightBoard.get(i) + rightBoard.get(i + 1));
            } else {
              result += ((long) rightBoard.get(i) * (long) rightBoard.get(i + 1));
            }
    
          } else {
            result += rightBoard.get(i);
          }
        }
    
        System.out.println(result);

    }

}
