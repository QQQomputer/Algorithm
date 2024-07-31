package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Math.log10을 이용했더니 더 오래 걸림
public class Q1790_수이어쓰기2_ver2 {
//1. 	stringbulilder로 구현해보기
//		int %로
//2. 	한번 더할 때마다 cnt 내리면서 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			int length = (int)Math.log10(i)+1;
			if(cnt<=length) {
				System.out.println(i/(int)Math.pow(10,length-cnt)%10);	
				return;
			}
			cnt-=length;
		}
		System.out.println(-1);
	}
}
