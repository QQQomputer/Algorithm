package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//N<=1,000,000,000
public class Q1024_수열의합__ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,L, ans,idx;
	static boolean [][] board;
	static boolean [] isUsed;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int l = 0;
		int r = 0;
		
		//1+2+3+...+N-1+N;
		//N(N+1)/2
		
		//2+3+...+N-1,N;
		//

		

	}

}
