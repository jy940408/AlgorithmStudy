package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class 회의실배정 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        
        int roundNum = Integer.parseInt(br.readLine());
        int[][] roomList = new int[roundNum][2];

        for(int i = 0 ; i < roundNum ; i++){
            String[] firstLine = (br.readLine()).split(" ");
            roomList[i][0] = Integer.parseInt(firstLine[0]);
            roomList[i][1] = Integer.parseInt(firstLine[1]);
        }

        Arrays.sort(roomList, new Comparator<int[]>() {
            public int compare(int[] firstNum, int[] secondNum) {
                return firstNum[0] - secondNum[0];
            }
        });

        Arrays.sort(roomList, new Comparator<int[]>() {
            public int compare(int[] firstNum, int[] secondNum) {
                return firstNum[1] - secondNum[1];
            }
        });

        int endTime = 0, result = 0;
        for(int i = 0 ; i < roomList.length ; i++){
            if(roomList[i][0] >= endTime){
                endTime = roomList[i][1];
                result++;
            }
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();
        
    }

}
