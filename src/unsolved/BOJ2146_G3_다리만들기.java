package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 	1. 가로 두 점 사이 되는 지점 체크
 		l r 거리 2 이상일 때 두점 정보 저장
 	2. 세로 두점 사이 되는 지점 체크
 		l r 거리 2 이상일 때 두점 정보 저장
 	3. 체크된 점 중에 중복되는 섬 있는지
 		점 정보*2 - 중복개수 = 섬개수 - 1
 		8
 */
public class BOJ2146_G3_다리만들기 {
	static int N,M, ans;
	static int [][] board;
	static boolean [][] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		checked = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		
		
		
		
		
	}

}
