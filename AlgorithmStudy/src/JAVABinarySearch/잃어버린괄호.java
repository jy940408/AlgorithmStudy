package JAVABinarySearch;

import java.util.Scanner;

public class 잃어버린괄호 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] testcase = (scan.nextLine()).split("-");

        int result = 0;
        for(int i = 0 ; i < testcase.length ; i++){

            int subSum = 0;
            for(int j = 0 ; j < (testcase[i].split("\\+")).length ; j++){
                subSum += Integer.parseInt(testcase[i].split("\\+")[j]);
            }

            if(i == 0){
                result = subSum;
            }else {
                result -= subSum;
            }

        }

        System.out.println(result);

    }

}
