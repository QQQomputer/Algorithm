package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1h
//2차배열 누적합 실패 => 1차 누적합으로 품
public class BOJ11660_S1_구간합구하기5 {
	// 1 ≤ N ≤ 2^10, 1 ≤ M ≤ 100,000
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int [][] arr;
		
		int N =  Integer.parseInt(st.nextToken());
		int M =  Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())+arr[i][j-1];
			}
		}			
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());

			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
			for (int r = y1; r < y2+1; r++) {
				sum+=arr[r][x2]-arr[r][x1-1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
