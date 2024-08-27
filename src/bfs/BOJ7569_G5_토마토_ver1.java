package bfs;

import java.io.*;
import java.util.*;

public class BOJ7569_G5_토마토_ver1 {

	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,H, ans;
	static int [][][] space;
	static int [][][] depthArr = new int [2][1_000_000][3];
	static int cnt=0,curCnt=0,two=0;
	static int row,col,hei, unripe;
	static int [][] move = {{0,0,-1},{0,0,1},{0,-1,0},{0,1,0},{1,0,0},{- 1,0,0}};
	public static void main(String args[]) throws IOException
	{		
		System.setIn(new FileInputStream("src/gold/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		space = new int[N][M][H];
		
		unripe = 0;
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());	
				for (int c = 0; c < M; c++) {
					space[r][c][h]=Integer.parseInt(st.nextToken());
					if(space[r][c][h]==1) {
						depthArr[two][cnt][0]=r;
						depthArr[two][cnt][1]=c;
						depthArr[two][cnt++][2]=h;
					}else if(space[r][c][h]==0) {
						unripe++;
					}
				}
			}
		}	
		ans = bfs(0);
		
		System.out.println(unripe==0?ans:-1);
	}
	
	public static boolean check(int row, int col, int height) {
		return row >= 0 && row < N && col >= 0 && col < M && height >= 0 && height < H;
	}
	
	public static int bfs(int depth) {
		if(cnt ==0)
			return depth-1;
		
		for (int i = 0; i < cnt; i++) {
			row = depthArr[two][i][0];
			col = depthArr[two][i][1];
			hei = depthArr[two][i][2];			
			for (int j = 0; j < 6; j++) {
				if(check(row+move[j][0],col+move[j][1],hei+move[j][2]) && space[row+move[j][0]][col+move[j][1]][hei+move[j][2]]==0) {
					space[row+move[j][0]][col+move[j][1]][hei+move[j][2]]++;
					depthArr[(two+1)%2][curCnt][0]=row+move[j][0];
					depthArr[(two+1)%2][curCnt][1]=col+move[j][1];
					depthArr[(two+1)%2][curCnt++][2]=hei+move[j][2];
					unripe--;
				}
			}
			
		}
		cnt = curCnt;
		curCnt = 0;
		two = ++two%2;
		return bfs(depth+1);
	}

}