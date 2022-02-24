package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SMUPC계산기 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    int symbolNum = Integer.parseInt(br.readLine());
    String[] testCase = (br.readLine()).split("");

    ArrayList<Long> splitList = splitCheck(testCase);
    int numberIdx = 1;
    String result = "";
    long subResult = splitList.get(0);
    StringBuffer sb = new StringBuffer();

    for (String i : testCase) {
      if (i.equals("C")) {
        sb.append(Long.toString(subResult) + " ");

      } else {
        if (splitList.size() > numberIdx) {
          if (i.equals("S")) {
            subResult -= splitList.get(numberIdx);
            numberIdx++;

          } else if (i.equals("M")) {
            subResult *= splitList.get(numberIdx);
            numberIdx++;

          } else if (i.equals("U")) {
            if (subResult < 0) {
              subResult = -1 * ((-1 * subResult) / splitList.get(numberIdx));
            } else {
              subResult /= splitList.get(numberIdx);
            }
            numberIdx++;

          } else if (i.equals("P")) {
            subResult += splitList.get(numberIdx);
            numberIdx++;
          }
        }
      }
    }

    result = sb.toString();

    if (result.equals("")) {
      bw.write("NO OUTPUT");
    } else {
      bw.write(result + "");
    }

    br.close();
    bw.flush();
    bw.close();

  }

  private static ArrayList<Long> splitCheck(String[] testCase) {
    ArrayList<Long> splitResult = new ArrayList<>();
    StringBuffer subResult = new StringBuffer();

    for (String i : testCase) {
      if (i.equals("S") || i.equals("M") || i.equals("U") || i.equals("P") || i.equals("C")) {
        if (!(subResult.toString()).equals("")) {
          splitResult.add(Long.parseLong(subResult.toString()));
        }
        subResult = new StringBuffer();

      } else {
        subResult.append(i);
      }
    }

    return splitResult;
  }

}
