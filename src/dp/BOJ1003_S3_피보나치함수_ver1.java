package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_S3_피보나치함수_ver1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int [][] fiboList = new int [41][2];
	static int zero,one;
	
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	
		
		//0		f(0)		1	0
		//1		f(1)		0	1
		//2		f(1)-f(0)	1	1
		//3		f(2)-f(1)	1	2	
		fiboList[0][0]=1;
		fiboList[0][1]=0;
		fiboList[1][0]=0;
		fiboList[1][1]=1;
		
		for (int i = 2; i < 41; i++) {
			fiboList[i][0]=fiboList[i-2][0]+fiboList[i-1][0];
			fiboList[i][1]=fiboList[i-2][1]+fiboList[i-1][1];
		}
		
//		for (int i = 0; i < fiboList.length; i++) {
//			System.out.println(fiboList[i][0] + " " +fiboList[i][1]);
//		}
		
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(fiboList[num][0] + " " + fiboList[num][1]+"\n");
		}
		
		System.out.println(sb.toString());
	}	
	
//	public static int fibo(int n) {
//	    if (n == 0) {
//	    	zero++;
//	        return 0;
//	    } else if (n == 1) {
//	    	one++;
//	        return 1;
//	    } else {
//	        return fibo(n-1) + fibo(n-2);
//	    }
//	}
}
