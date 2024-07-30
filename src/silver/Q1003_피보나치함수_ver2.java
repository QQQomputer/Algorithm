package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//2차배열 > 1차배열
public class Q1003_피보나치함수_ver2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int [] fiboList = new int [82];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
		int T = Integer.parseInt(br.readLine());	
		fiboList[0]=1;	fiboList[1]=0;	fiboList[2]=0;	fiboList[3]=1;
		
		int idx = 4;
		
		while(idx<82) {
			fiboList[idx]=fiboList[idx-4]+fiboList[idx-2];
			fiboList[idx+1]=fiboList[idx-3]+fiboList[idx-1];
			idx+=2;
		}

		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(fiboList[num*2] + " " + fiboList[num*2+1]+"\n");
		}
		System.out.println(sb.toString());
	}	
}
