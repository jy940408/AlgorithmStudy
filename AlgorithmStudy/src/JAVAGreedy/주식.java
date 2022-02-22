package JAVAGreedy;

import java.util.Scanner;

public class 주식 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int roundNum = Integer.parseInt(scan.nextLine());

    for (int i = 0; i < roundNum; i++) {
      int dayNum = Integer.parseInt(scan.nextLine());

      int[] stockList = new int[dayNum];
      String[] firstLine = (scan.nextLine()).split(" ");
      for (int j = 0; j < dayNum; j++) {
        stockList[j] = Integer.parseInt(firstLine[j]);
      }

      int maxNum = stockList[dayNum - 1];
      long result = 0;
      for (int j = (dayNum - 1); j > -1; j--) {
        if (stockList[j] > maxNum) {
          maxNum = stockList[j];
        } else {
          result += (maxNum - stockList[j]);
        }
      }

      System.out.println(result);
    }

  }

}
