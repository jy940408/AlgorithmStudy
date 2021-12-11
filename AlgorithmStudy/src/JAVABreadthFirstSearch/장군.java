package JAVABreadthFirstSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 장군 {
        
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int[] upDown = {-2, -3, -3, -2, 2, 3, 3, 2}, leftRight = {-3, -2, 2, 3, -3, -2, 2, 3};
        static int result;
        static boolean resultCheck = false;

        public static void main(String[] args) throws IOException{
            
            boolean[][] visitList = new boolean[10][9];

            String[] firstLine = (br.readLine()).split(" ");
            int startHeight = Integer.parseInt(firstLine[0]);
            int startWidth = Integer.parseInt(firstLine[1]);
            String[] secondLine = (br.readLine()).split(" ");
            int goalHeight = Integer.parseInt(secondLine[0]);
            int goalWidth = Integer.parseInt(secondLine[1]);

            bfs(startHeight, startWidth, goalHeight, goalWidth, visitList);

            if(resultCheck){
                bw.write(result + "");
            }else{
                bw.write(-1 + "");
            }

            br.close();
            bw.flush();
            bw.close();
        }

        private static void bfs(int startHeight, int startWidth, int goalHeight, int goalWidth, boolean[][] visitList){
            Queue<int[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new int[] {startHeight, startWidth, 0});

            while(!bfsQueue.isEmpty()){
                int[] thisQueue = bfsQueue.poll();
                int thisHeight = thisQueue[0];
                int thisWidth = thisQueue[1];

                for(int i = 0 ; i < 8 ; i++){
                    int subHeight = (thisHeight + upDown[i]);
                    int subWidth = (thisWidth + leftRight[i]);

                    boolean roadCheck = true;
                    if(i == 0 || i == 1){
                        if((subHeight+1) == goalHeight && (subWidth+1) == goalWidth){
                            roadCheck = false;
                        }else if((subHeight+2) == goalHeight && (subWidth+2) == goalWidth){
                            roadCheck = false;
                        }
                    }else if(i == 2 || i == 3){
                        if((subHeight+1) == goalHeight && (subWidth-1) == goalWidth){
                            roadCheck = false;
                        }else if((subHeight+2) == goalHeight && (subWidth-2) == goalWidth){
                            roadCheck = false;
                        }
                    }else if(i == 4 || i == 5){
                        if((subHeight-1) == goalHeight && (subWidth+1) == goalWidth){
                            roadCheck = false;
                        }else if((subHeight-2) == goalHeight && (subWidth+2) == goalWidth){
                            roadCheck = false;
                        }
                    }else{
                        if((subHeight-1) == goalHeight && (subWidth-1) == goalWidth){
                            roadCheck = false;
                        }else if((subHeight-2) == goalHeight && (subWidth-2) == goalWidth){
                            roadCheck = false;
                        }
                    }

                    if(roadCheck){
                        if(subHeight >= 0 && subHeight < 10 && subWidth >= 0 && subWidth < 9){
                            if(!visitList[subHeight][subWidth]){
                                if(subHeight == goalHeight && subWidth == goalWidth){
                                    result = (thisQueue[2] + 1);
                                    resultCheck = true;
                                    return;
                                }
                                visitList[subHeight][subWidth] = true;
                                bfsQueue.add(new int[] {subHeight, subWidth, (thisQueue[2]+1)});
                            }
                        }
                    }
                }
            }
        }

}
