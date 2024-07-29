package silver;

import java.io.*;
import java.util.*;

public class Q1012 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;	
	static int N,M,K, ans;
	static boolean [][] checked;
	static int [] deltaR = {-1,1,0,0};
	static int [] deltaC = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			checked = new boolean[N][M];
			int cnt=0;
			
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());	
				//System.out.println("k : "+k);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				checked[y][x]=true;				
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(checked[r][c]) {
						checked[r][c]=false;
						dfs(0,r,c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);			
		}
		
	}
	static boolean check(int row, int col) {
		return row>=0 && row < N && col>=0 && col < M;
	}
	
	static void dfs(int depth, int r, int c) {
//		if(depth==N)
//			return;
		
		for (int i = 0; i < 4; i++) {
			int rr = r+deltaR[i];
			int cc = c+deltaC[i];
			if(check(rr,cc) && checked[rr][cc]) {
				checked[rr][cc]=false;
				dfs(depth+1,rr,cc);
			}
		}
	}

}