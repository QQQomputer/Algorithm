package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1022_G3_소용돌이예쁘게출력하기_ver실패 {

	static int N, ans;
	static int [] board;
	// 우상, 좌상, 좌하, 우하
	static int [] cross = {2,4,6,8};
	// 좌, 우
	static int [] x = {5,0,1};
	// 상, 하
	static int [] y = {3,0,7};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1,r2,c1,c2;
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		int N = r2-r1+1;
		int M = c2-c1+1;
		board = new int[N*M];
		
		//c 거리는 최대 4이므로 col 기준으로 접근 후 row 계산
		
		int idx =0;
		
		for (int i = c1; i < c2+1; i++) {
			int colIfRowZero = getNumByCol(i);
			System.out.println("c : "+i+ " colIfRowZero : "+colIfRowZero);
			for (int j = r1; j < r2+1; j++) {
				board[idx] = getNumByRow(j, i, colIfRowZero);
				idx++;
			}
		}
//		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(board[i*N+j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M; j++) {
				sb.append(board[j*N+i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 왼쪽 	0
	// 0	1
	// 오른쪽	2
	static int getDirect(int n) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else
			return 2;
	}
	
	static int getNumByCol(int n) {
		int dir = getDirect(n);
		if(dir == 1)
			return 1;
		
		return 1+arithmeticSequence(x[dir]*n, Math.abs(n));
	}
	
	static int getNumByRow(int r, int c, int colIfRowZero) {
		int gap = Math.abs(r) - Math.abs(c);
		int dirR = getDirect(r);
		
		if(dirR == 0)
			return colIfRowZero;
		
		
		
		
		return 0;
	}	
	static int arithmeticSequence(int d, int n) {
		int sum = d;
		while(--n>0) {
			sum+=n*8;
		}
		return sum;
	}
}
