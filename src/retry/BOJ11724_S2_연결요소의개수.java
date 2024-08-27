package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1 <= N <= 1,000
//0 <= M <= 499,500
//50m
public class BOJ11724_S2_연결요소의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M, ans,idx;
	static boolean [][] board;
	static boolean [] isUsed;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new boolean[N+1][N+1];
		isUsed = new boolean[N+1];
		ans=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			board[a1][a2]=true;
			board[a2][a1]=true;
		}
		
		for (int row = 1; row <= N; row++) {
			idx=0;
			dfs(row);
			ans+=idx==0?0:1;
		}
		System.out.println(ans);
	}
	
	static void dfs(int r) {
		if(isUsed[r]) {
			return;
		}
		isUsed[r] = true;
		idx++;
		for (int col = 1; col <= N; col++) {
			if(!isUsed[col]&&board[r][col]) {
				dfs(col);
			}
		}
	}
}
