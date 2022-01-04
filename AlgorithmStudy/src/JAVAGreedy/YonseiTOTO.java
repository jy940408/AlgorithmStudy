package JAVAGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class YonseiTOTO {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        
        String[] firstLine = (br.readLine()).split(" ");
        int subjectNum = Integer.parseInt(firstLine[0]), mileageNum = Integer.parseInt(firstLine[1]);
        
        int[] resultList = new int[subjectNum];
        for(int i = 0 ; i < subjectNum ; i++){
            String[] secondLine = (br.readLine()).split(" ");
            int subNum = Integer.parseInt(secondLine[0]), fullNum = Integer.parseInt(secondLine[1]);
            String[] mileageList = (br.readLine()).split(" ");

            int[] scoreList = new int[101];
            for(int j = 0 ; j < subNum ; j++){
                scoreList[Integer.parseInt(mileageList[j])] += 1;
            }

            int result = 0;
            if(subNum < fullNum){
                resultList[i] = 1;
            }else if(subNum >= fullNum){
                for(int j = 100 ; j > 0 ; j--){
                    result += scoreList[j];
                    if(result >= fullNum){
                        resultList[i] = j;
                        break;
                    }
                }
            }
        }

        Arrays.sort(resultList);
        int mileageSum = 0;
        int result = 0;
        for(int i = 0 ; i < subjectNum ; i++){
            mileageSum += resultList[i];
            if(mileageSum > mileageNum){
                result = i;
                break;
            }else if(mileageSum == mileageNum){
                result = (i+1);
                break;
            }
        }

        if(mileageNum > mileageSum){
            result = subjectNum;
        }

        br.close();
        bw.write(result + "");
        bw.flush();
        bw.close();

    }

}
