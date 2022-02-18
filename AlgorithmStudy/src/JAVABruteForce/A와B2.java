package JAVABruteForce;

import java.util.Scanner;

public class A와B2 {

  static int result = 0;

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    String[] startWord = (scan.nextLine()).split("");
    String[] goalWord = (scan.nextLine()).split("");

    wordOrder(startWord, goalWord);

    System.out.println(result);

  }

  private static void wordOrder(String[] startWord, String[] goalWord) {

    if (result == 1 || (goalWord.length) < (startWord.length)) {
      return;
    }

    if (goalWord.length == startWord.length) {
      boolean resultCheck = true;
      for (int i = 0; i < goalWord.length; i++) {
        if (!goalWord[i].equals(startWord[i])) {
          resultCheck = false;
        }
      }

      if (resultCheck) {
        result = 1;
        return;
      }
    }

    if (goalWord[(goalWord.length - 1)].equals("A")) {
      String[] subString = new String[(goalWord.length - 1)];
      for (int i = 0; i < (goalWord.length - 1); i++) {
        subString[i] = goalWord[i];
      }
      wordOrder(startWord, subString);
    }
    if (goalWord[0].equals("B")) {
      String[] subString = new String[(goalWord.length - 1)];
      for (int i = 0; i < (goalWord.length - 1); i++) {
        subString[i] = goalWord[((goalWord.length - 1) - i)];
      }
      wordOrder(startWord, subString);
    }

  }

}

// if lengthCheck and result == 0:
// if goalWord[len(goalWord)-1] == "A":
// wordOrder(startWord, goalWord[:len(goalWord)-1])
// if goalWord[0] == "B":
// wordOrder(startWord, list(reversed(goalWord))[:len(goalWord)-1])
