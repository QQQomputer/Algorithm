package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_S4_수들의합2_ver2 {
	static int N,M, ans;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int l = 0;
		int r = 1;
		int sum = arr[0];
		
		while(r<N) {
			if(sum>=M) {
				if(sum==M) {
					ans++;
					sum+=arr[r++];
				}
				sum-=arr[l++];
			}else if(sum<M) {
				sum+=arr[r++];
			}
		}
		while(sum>=M) {
			if(sum==M)ans++;
			sum-=arr[l++];
		}
		System.out.println(ans);
	}
}