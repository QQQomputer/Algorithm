package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1790_수이어쓰기2 {
//1. 	stringbulilder로 구현해보기
//		int %로
//2. 	한번 더할 때마다 cnt 내리면서 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder sub = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sum = 0;
		int cnt = K;
		char [] arr = new char[N];
		
		for (int i = 1; i <= N; i++) {
			sub.setLength(0);
			sub.append(i);
			//arr = sub.append(i).toString();
			//System.arraycopy(sub, 0, arr, 0, sub.length());
			if(cnt-sub.length()<=0) {			
				System.out.println(sub.substring(cnt-1, cnt));	
				return;
			}
			cnt-=sub.length();
		}
		System.out.println(-1);
	}

}
