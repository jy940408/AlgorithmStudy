package JAVAImplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 달팽이리스트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		String[] firstLine = (br.readLine()).split(" ");
		int nodeNum = Integer.parseInt(firstLine[0]);
		int questionNum = Integer.parseInt(firstLine[1]);
		int connectNode = Integer.parseInt(firstLine[2]);
		String[] secondLine = (br.readLine()).split(" ");
		int[] nodeList = new int[nodeNum];
		for(int i = 0 ; i < nodeNum ; i++) {
			nodeList[i] = Integer.parseInt(secondLine[i]);
		}
		
		int afterRotation = 0;
		for(int i = 0 ; i < questionNum ; i++) {
			int question = Integer.parseInt(br.readLine());
			if(connectNode != (nodeNum-1)) {
				if(question < connectNode) {
					bw.write(nodeList[question] + "\n");
				}else {
					afterRotation = ((question-(connectNode-1))%(nodeNum-(connectNode-1))+(connectNode-1));
					bw.write(nodeList[afterRotation] + "\n");
				}
			}else {
				if(question < connectNode) {
					bw.write(nodeList[i] + "\n");
				}else {
					bw.write(nodeList[nodeNum-1] + "\n");
				}
			}
		}
		
		System.out.println("connectNode: " + connectNode);
		for(int i = 0 ; i < nodeNum ; i++) {
			System.out.println("nodeList[" + i + "]: " + nodeList[i]);
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
