package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 순열 ArrayList 받기 
// 받은대로 나열해보고 되는 것 sb에 담기
// 그 과정에서 0,1,2 처리 메서드
public class BOJ7490_G5_0만들기 {
	static int N,M, ans;
	static int [] arr = new int[10];
	static int [] calc = {0,1,2};
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			ans=0;
			N = Integer.parseInt(br.readLine());
			M = N-1;
			list = new ArrayList<>();
			arr = new int[M];
			
			recursion(0);

			for (int[] ar : list) {
				
				int sum = 0;
				int bef = N;
				int r = 1;
				for (int i = M; i > 0; i--) {
					if(ar[i-1]==0) {
						r*=10;
						bef = r*i+bef;
					}else if(ar[i-1]==1) {
						r=1;
						sum+=bef;
						bef=i;
					}else if(ar[i-1]==2) {
						r=1;
						sum-=bef;
						bef=i;
					}
				}	
				sum+=bef;
				if(sum==0) {
					ans++;
					for (int i = 1; i < N; i++)
						sb.append(i).append(ar[i-1]==0?" ":(ar[i-1]==1?"+":"-"));
					sb.append(N).append("\n");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);		
	}
	static void recursion(int n) {
		if(n==M) {
			list.add(Arrays.copyOf(arr,M));
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			arr[n]=i;
			recursion(n+1);
		}
	}
}
