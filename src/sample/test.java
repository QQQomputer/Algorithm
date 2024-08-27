package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

	static int N, ans,max;
	static int [] board;
	static int [] arrL;
	static int [] arrR;
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
		
		int idx =0;

		max = Math.max(Math.max(Math.abs(r1), Math.abs(r2)),Math.max(Math.abs(c1), Math.abs(c2)));
		
		int len = max<1?2:max+1;
		//가장 좌측 부터 가장 우측		
		arrR = new int[len];
		arrR[0] = 1;
		arrR[1] = 2;
		
		// f(n+1) = f(n)+8 
		arrL = new int[len];
		arrL[0] = 1;
		arrL[1] = 6;
		
		//맥스 껍질 까지 arr 생성
		if(max>=2)
			arithmeticSequence(1);
		
		max=0;
		for (int i = r1; i < r2+1; i++) {
			//col 0 일 때 값
			int std = arrL[Math.abs(i)]+Integer.compare(i, 0)*Math.abs(i)*2;
			for (int j = c1; j < c2+1; j++) {
				int gap = Math.abs(i)-Math.abs(j);
				if(gap<0) {
					int nd = Math.abs(i)+Math.abs(gap);
					//좌측
					if(j<0)
						board[idx] = arrL[nd] + Integer.compare(i, 0)*((nd)- Math.abs(gap));
					//우측
					else
						board[idx] = arrR[nd] - Integer.compare(i, 0)*((nd)- Math.abs(gap));
				}
				//
				else
					board[idx] = std+Integer.compare(i, 0)*j;
				max = Math.max(max, (int)(Math.log10(board[idx])+1));
				idx++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <M; j++)
				sb.append(String.format("%"+max+"s", board[i*M+j])).append(" ");
				
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static void arithmeticSequence(int depth) {
		if(depth==max)
			return;
		arrL[depth+1] = arrL[depth] + 5 + 8 * depth;
		arrR[depth+1] = arrR[depth] + 1 + 8 * depth;
		arithmeticSequence(depth+1);
	}
}