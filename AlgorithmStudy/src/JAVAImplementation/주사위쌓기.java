package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class 주사위쌓기 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Integer> diceCheck = Map.of(0,5, 1,3, 2,4, 3,1, 4,2, 5,0);

    public static void main(String[] args) throws IOException{

        int diceNum = Integer.parseInt(br.readLine());
        int[][] diceList = new int[diceNum][6];

        for(int i = 0 ; i < diceNum ; i++){
            String[] firstLine = (br.readLine()).split(" ");
            for(int j = 0 ; j < firstLine.length ; j++){
                diceList[i][j] = Integer.parseInt(firstLine[j]);
            }
        }

        int result = 0;
        for(int i = 0 ; i < 6 ; i++){
            int thisDice = 0;
            for(int j = 0 ; j < 6 ; j++){
                if(j != i && j != diceCheck.get(i)){
                    thisDice = Math.max(thisDice, diceList[0][j]);
                }
            }
            int subResult = thisDice;
            int preDice = diceList[0][diceCheck.get(i)];

            for(int j = 1 ; j < diceNum ; j++){
                int idx = 0;
                for(int k = 0 ; k < 6 ; k++){
                    if(diceList[j][k] == preDice){
                        idx = k;
                    }
                }

                thisDice = 0;
                for(int k = 0 ; k < 6 ; k++){
                    if(k != idx && k != diceCheck.get(idx)){
                        thisDice = Math.max(thisDice, diceList[j][k]);
                    }
                }

                subResult += thisDice;
                preDice = diceList[j][diceCheck.get(idx)];
            }

            result = Math.max(result, subResult);
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
