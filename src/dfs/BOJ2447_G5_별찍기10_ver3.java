package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//이차원 배열 => 일차원 배열 활용
//성능변화X, 가독성만 안 좋아짐
public class BOJ2447_G5_별찍기10_ver3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean [] stars;
	static int [] dr = {-1,-1,-1,0,0,0,1,1,1};
	static int [] dc = {-1,0,1,-1,0,1,-1,0,1};
	public static void main(String[] args) throws IOException {		
		N = Integer.parseInt(br.readLine());
		stars= new boolean[N*N];
		recursion(N, N*N/2);
		
		String star = "*";
		String gap = " ";
		
		for (int r = 0; r < N; r++) {
			int row = -Math.abs(r-N/2)+N/2;
			for (int c = 0; c < N; c++) {
				if(stars[row*N+c])
					sb.append(star);
				else
					sb.append(gap);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void recursion(int n, int sector) {
		if(n==3) {
			int row = sector/N;
			int col = sector%N;
			for (int i = 0; i < 9; i++) {
				if(i==4)
					continue;
				stars[(row+dr[i])*N+col+dc[i]]=true;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(i==4)
				continue;
			
			int center_sector = (n/3*dr[i]+sector/N)*N+n/3*dc[i]+sector%N;
			
			recursion(n/3, center_sector);
			
			if(n==N&&i==5)
				i+=3;
		}
	}

}
