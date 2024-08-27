package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2667_S1_단지번호붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, ans, idx,sum;
	static int [] arr;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static boolean [][] board;
	
	public static void main(String[] args) throws IOException {		
		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		arr = new int[N*N/2+1];
		for (int i = 0; i < N; i++) {			
			String [] str = br.readLine().split("");
			
			for (int j = 0; j < N; j++) {		
				if(Integer.parseInt(str[j])==1)
					board[i][j]=true;
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum=0;
				dfs(0,r,c);
				if(sum>0)
					arr[idx++]=sum;
			}
		}
		
		int [] arr1 = Arrays.copyOf(arr, idx);
		Arrays.sort(arr1);

		sb.append(arr1.length).append("\n");
		for (int i = 0; i < arr1.length; i++) {
			sb.append(arr1[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int r, int c) {
		if(board[r][c]) {
			board[r][c]=false;
			sum++;
			for (int m = 0; m < 4; m++) {
				int row = r+dr[m];
				int col = c+dc[m];
				if(check(row,col))
					dfs(depth+1, row, col);
			}	
		}	
	}
	
	static boolean check(int row, int col) {
		return row>=0&&row<N&&col>=0&&col<N;
	}	
}