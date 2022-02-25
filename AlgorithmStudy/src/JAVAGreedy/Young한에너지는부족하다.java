package JAVAGreedy;

import java.util.Arrays;
import java.util.Scanner;

public class Young한에너지는부족하다 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int crewNum = Integer.parseInt(scan.nextLine());

    int[] crewList = new int[3 * crewNum];
    String[] firstLine = (scan.nextLine()).split(" ");
    for (int i = 0; i < 3 * crewNum; i++) {
      crewList[i] = Integer.parseInt(firstLine[i]);
    }

    Arrays.sort(crewList);
    int result = crewList[2 * crewNum - 1] - crewList[crewNum];
    System.out.println(result);

  }

}
