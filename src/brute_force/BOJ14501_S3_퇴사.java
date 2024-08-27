package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1H
public class BOJ14501_S3_퇴사 {
	static int N, ans,sum;
	static int [] day;
	static int [] money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		sum=ans=0;
		N = Integer.parseInt(br.readLine());
		day = new int[N];
		money = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i]=Integer.parseInt(st.nextToken());
			money[i]=Integer.parseInt(st.nextToken());
		}
		
		recursion(0);
		System.out.println(ans);
	}
	static void recursion(int n) {
		if(n==N) {
			ans=Math.max(ans, sum);
			return;
		}
		for (int i = n; i < N; i++) {		
			if(i+day[i]>N) {
				ans=Math.max(ans, sum);
				continue;
			}			
			sum+=money[i];
			recursion(i+day[i]);
			sum-=money[i];
		}
		
	}
}
