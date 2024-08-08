package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798_B2_블랙잭 {
	
	static int N,M,sum,ans;
	static int [] arr;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = 0;
		sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(0,0);
		System.out.println(ans);
	}
	static void dfs(int depth, int idx) {
		if(depth==3) {
			if(M>=sum)
				ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sum += arr[i];
			dfs(depth+1, i+1);
			sum -= arr[i];
		}
	}
}
