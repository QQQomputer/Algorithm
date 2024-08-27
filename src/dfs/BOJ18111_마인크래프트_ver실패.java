package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 단조 함수가 아니므로 바이너리 서치 불가능!
public class BOJ18111_마인크래프트_ver실패 {

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
		parametricSearch();
		System.out.println(ans + " " + ansH);
	}
	static void parametricSearch() {
		l = min;
		r = max;
		while(l<=r) {
			int mid = (l+r)/2;
			
			int sum = 0;
			int used = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int n = board[i][j]-mid;
					if(n>=0)sum+=2*n;
					else used-=n;
				}
			}
			if(used>B+sum/2) {
				System.out.println(1);
				r=mid-1;
			} 
			if(sum/2 >= used*2) {
				System.out.println(2);
				r=mid-1;
				if( sum + used < ans || ( sum + used == ans && mid > ansH )) {
					ans = sum + used;
					ansH = mid;
				}
			}
			else {
				System.out.println(3);
				l=mid+1;
				if( sum + used < ans || ( sum + used == ans && mid > ansH )) {
					ans = sum + used;
					ansH = mid;
				}
			}
		}
	}
}

/*
2 2 10000
0 0
0 256
640 128
 */
