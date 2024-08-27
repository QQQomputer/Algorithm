package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//45m
//누적합 + binary search
public class BOJ1806_G4_부분합 {
	static int N,M, ans;
	static long [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		ans=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int l = i;
			int r = N;
			while(l<=r) {
				int mid = (l+r)/2;
				long result =(arr[mid]-arr[i-1]);
				if(result==M) {
					min = Math.min(min, mid-i+1);
					break;
				}
				else if(result>M) {
					min = Math.min(min, mid-i+1);
					r=mid-1;
				}else {
					l=mid+1;
				}
			}
			if(min==0)break;
		}
		if(min == Integer.MAX_VALUE)min=0;
		System.out.println(min);
	}
}