package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926_배열돌리기_ver1 {
	
	//상,좌,하,우
	static int [] dr = {0,1,0,-1};
	static int [] dc = {-1,0,1,0};
	static int depth,N,M,R;
	
	//ex) 4x6
	/*
		 ㅁ	ㅁ	ㅁ	ㅁ	ㅁ	ㅁ
		 ㅁ	ㅁ	ㅁ	ㅁ	ㅁ	ㅁ
		 ㅁ	ㅁ	ㅁ	ㅁ	ㅁ	ㅁ
		 ㅁ	ㅁ	ㅁ	ㅁ	ㅁ	ㅁ
	 */
	//1겹
	//2(r+c)-4	=> cycle
	//2(4 + 6)-4	=> cycle
	//2겹
	//2(2 + 4)-4	=> cycle
	static int [] arr;
	static int [][] board;
	static int [][] mBoard;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		mBoard = new int[N][M];
		
		//min(N, M) mod 2 = 0
		int min = Math.min(N, M);
		
		depth = min/2;
		
		//각 depth 별 나누기 "이동횟수 % 순환횟수"
		arr = new int[depth];
		
		if(depth==1)
			arr[0] = R%(N*M);
		else
			make(0);
		
		//배열 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//배열 이동
		move();
		
		//출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(mBoard[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}		
	//board[0+n][0+n]
	static void make(int n) {
		if(n==depth)
			return;
		//순회 2*(N+M)-4 마다
		arr[n] = R%(2*(N+M-2)-8*n);
		make(n+1);
	}
	
	static void move() {
		
		//깊이별 
		for (int d = 0; d < depth; d++) {
			//start는 네모의 좌측상단부터
			// 0 > 0,0
			// 1 > 1,1
			int rLen = M-d*2;
			int cLen = N-d*2;
			int dir,cnt,r,c;

			//상하의 가로변
			for (int i = 0; i < rLen-1; i++) {
				
				//상
				//col -방향
				r=0+d;
				c=M-1-d-i;
				dir=0;
				cnt = arr[d];
				while(cnt-->0) {
					r+= dr[dir%4];
					c+= dc[dir%4];
					if((r==d&&c==d)||(r==N-1-d&&c==d)||(r==d&&c==M-1-d)||(r==N-1-d&&c==M-1-d))//check(ro,co,dir%4)
						dir++;
				}
				mBoard[r][c]=board[0+d][M-1-d-i];
				
				//하
				//col +방향
				r=N-1-d;
				c=d+i;
				dir=2;
				cnt = arr[d];
				while(cnt-->0) {
					r+= dr[dir%4];
					c+= dc[dir%4];
					if((r==d&&c==d)||(r==N-1-d&&c==d)||(r==d&&c==M-1-d)||(r==N-1-d&&c==M-1-d))//check(ro,co,dir%4)
						dir++;
				}
				mBoard[r][c]=board[N-1-d][d+i];
			}
			
			//좌우의 세로변
			for (int i = 0; i < cLen-1; i++) {
				//좌
				//row +방향
				r=d+i;
				c=0+d;
				dir=1;
				cnt = arr[d];
				while(cnt-->0) {
					r+= dr[dir%4];
					c+= dc[dir%4];
					if((r==d&&c==d)||(r==N-1-d&&c==d)||(r==d&&c==M-1-d)||(r==N-1-d&&c==M-1-d))//check(ro,co,dir%4)
						dir++;
				}
				mBoard[r][c]=board[d+i][0+d];
				
				//우
				//row -방향
				r=N-1-d-i;
				c=M-1-d;
				dir=3;
				cnt = arr[d];
				while(cnt-->0) {
					r+= dr[dir%4];
					c+= dc[dir%4];
					if((r==d&&c==d)||(r==N-1-d&&c==d)||(r==d&&c==M-1-d)||(r==N-1-d&&c==M-1-d))//check(ro,co,dir%4)
						dir++;
				}
				mBoard[r][c]=board[N-1-d-i][M-1-d];
			}
		}		
	}

//	static boolean check(int r, int c,int dir) {
//		if(dir == 0)
//			return (r==d&&c==d);
//		if(dir == 1)
//			return (r==d&&c==d+cLen);
//		if(dir == 2)
//			return (r==d+rLen&&c==d+cLen);
//		//if(dir == 3)
//			return (r==d+rLen&&c==d);
//	}
//	static void j(int r, int c, int d) {
//		
//	}
}
