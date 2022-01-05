package JAVAGreedy;

import java.util.Scanner;

public class 블로그2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String[] sentence = (scan.nextLine()).split("");

        int result = 0;
        if(!sentence[0].equals(sentence[length-1])){
            for(int i = (length-1) ; i > -1 ; i--){
                if(!sentence[length-1].equals(sentence[i])){
                    result += 2;
                    for(int j = 0 ; j < i ; j++){
                        if(sentence[length-1].equals(sentence[j])){
                            for(int k = j ; k < i ; k++){
                                if(sentence[length-1].equals(sentence[k])){
                                    j++;
                                }else{
                                    break;
                                }
                            }
                            result += 1;
                        }
                    }
                    break;
                }
            }

        }else{
            result += 1;
            for(int i = 0 ; i < length ; i++){
                if(!sentence[0].equals(sentence[i])){
                    for(int j = i ; j < length ; j++){
                        if(!sentence[0].equals(sentence[j])){
                            i++;
                        }else{
                            break;
                        }
                    }
                    result += 1;
                }
            }

        }

        System.out.println(result);

    }

}
