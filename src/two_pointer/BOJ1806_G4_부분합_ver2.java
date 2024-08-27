package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// min => 확인된 최소 길이
// 최소 길이를 만족하면서 sum>=M인 구간 계속해서 유지
// 슬라이딩 윈도우
public class BOJ1806_G4_부분합_ver2 {
	static int N,M, ans;
	static long [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N];
		ans=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0;
		int r = 1;
		long sum = arr[0];
		int min = Integer.MAX_VALUE;
		while(l<N) {
			if(r==N) {
				if(sum>=M) {
					min = Math.min(r-l, min);
				}
				sum-=arr[l++];
				if(sum<M)break;
			}
			else if(sum>=M) {
				min = Math.min(r-l, min);
				sum-=arr[l++];
			}else if(sum<M) {
				sum+=arr[r++];
			}
		}
		if(min == Integer.MAX_VALUE)min=0;
		System.out.println(min);
	}
}