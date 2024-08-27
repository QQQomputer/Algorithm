package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606_S3_바이러스 {	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;	
	static int n, con, x, y, max;
	static boolean [][] pair;
	static boolean [] used;

	public static void main(String[] args) throws IOException {		
		n = Integer.parseInt(br.readLine());
		con = Integer.parseInt(br.readLine());
		
		pair = new boolean [n+1][n+1];
		used = new boolean [n+1];
		for (int i = 0; i < con; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			pair[x][y]= true;
			pair[y][x]= true;
		}
		max = -1;
		dfs(0,1);
		
		System.out.println(max);
	}
	
	static void dfs(int depth, int idx) {
		if(depth==n || used[idx])
			return;
		used[idx]=true;
		max++;

		for (int i = 1; i < n+1; i++)
			if(pair[idx][i])
				dfs(depth+1, i);
	}
}