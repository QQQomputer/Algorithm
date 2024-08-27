package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929_S3_소수구하기 {
//소수 구하기
//1 ≤ M ≤ N ≤ 1,000,000
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean [] isNotPrime = new boolean[N+1];
		
		isNotPrime[1]=true;
		
		for (int i = 2; i <= N; i++) {
			if(!isNotPrime[i]) {
				if(i>=M)
					sb.append(i).append("\n");
				
				int idx=1;
				while(i*++idx<=N)
					isNotPrime[i*idx]=true;
			}
		}
		
		System.out.println(sb);
	}

}
