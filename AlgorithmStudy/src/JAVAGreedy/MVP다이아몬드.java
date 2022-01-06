package JAVAGreedy;

import java.util.Scanner;

public class MVP다이아몬드 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int month = Integer.parseInt(scan.nextLine());
        String[] firstLine = (scan.nextLine()).split(" ");
        int[] payList = {Integer.parseInt(firstLine[0]), Integer.parseInt(firstLine[1]),
                        Integer.parseInt(firstLine[2]), Integer.parseInt(firstLine[3])};
        
        int[] gradeList = new int[month];
        String[] grade = (scan.nextLine()).split("");
        for(int i = 0 ; i < month ; i++){
            if(grade[i].equals("B")){
                gradeList[i] = 0;
            }else if(grade[i].equals("S")){
                gradeList[i] = 1;
            }else if(grade[i].equals("G")){
                gradeList[i] = 2;
            }else if(grade[i].equals("P")){
                gradeList[i] = 3;
            }else if(grade[i].equals("D")){
                gradeList[i] = 4;
            }
        }

        int result = 0;
        int preMonth = 0;
        for(int i = 0 ; i < month ; i++){
            if(i == 0){
                if(gradeList[i] == 4){
                    result += payList[3];
                }else{
                    result += (payList[gradeList[i]]-1);
                    preMonth = (payList[gradeList[i]]-1);
                }
            }else{
                if(gradeList[i] == 4){
                    result += payList[3];
                }else{
                    result += ((payList[gradeList[i]]-1)-preMonth);
                    preMonth = ((payList[gradeList[i]]-1)-preMonth);
                }
            }
        }

        System.out.println(result);
    
    }

}
