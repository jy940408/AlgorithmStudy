package JAVAGreedy;

import java.util.Scanner;
import java.util.Stack;

public class 스카이라인쉬운거 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int changeNum = Integer.parseInt(scan.nextLine());

        Stack<Integer> greedyStack = new Stack<>();
        int result = 0;
        for(int i = 0 ; i < changeNum ; i++){
            String[] firstLine = (scan.nextLine()).split(" ");
            int changeIdx = Integer.parseInt(firstLine[0]), height = Integer.parseInt(firstLine[1]);

            if(i == 0){
                if(height != 0){
                    greedyStack.add(height);
                    result++;
                }
            
            }else{
                while(true){
                    if(!greedyStack.isEmpty()){
                        if(height != 0){
                            if(greedyStack.peek() > height){
                                greedyStack.pop();
                            }else if(greedyStack.peek() < height){
                                greedyStack.add(height);
                                result++;
                                break;
                            }else{
                                break;
                            }
                        
                        }else{
                            greedyStack = new Stack<>();
                            break;
                        }
                    
                    }else{
                        if(height != 0){
                            greedyStack.add(height);
                            result++;
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

}
