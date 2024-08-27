package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111_마인크래프트_ver2 {

	static int N,M,B, ans, ansH,l,r,max,min;
	static int [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		max=ansH=0; min=ans = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		board = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]>max) max = board[i][j];
				if(board[i][j]<min) min = board[i][j];
			}
		}
		dfs(min);
		System.out.println(ans + " " + ansH);
	}
	static void dfs(int n) {
		if(n>max) {
			
			return;
		}
		int remove = 0;
		int used = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int m = board[i][j]-n;
				if(m>=0)remove+=m;
				else used-=m;
			}
		}
		if(used>B+remove) {
			
		}else {
			if( remove*2 + used <= ans) {
				ans = remove*2 + used;
				ansH = n;
			}
		}
		dfs(n+1);
	}
}

/*
2 2 10000
0 0
0 256
640 128
 */
