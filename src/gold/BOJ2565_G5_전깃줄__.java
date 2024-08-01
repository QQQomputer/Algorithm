package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2565_G5_전깃줄__ {
	//구상 14m
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//A기준 500개
		int [] pointA = new int[501];
		int [] pointB = new int[501];
		
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		int [] B = new int[N];
		int cnt =0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < i; j++) {
				int tmp = b-B[j]-a+A[j];
				if(tmp == 0 || ((a-A[j])/tmp > 0 && (a-A[j])/tmp < 1)) {
					pointA[a]++;
					pointB[B[j]]++;
					cnt++;
				}
			}
			A[i]=a;
			B[i]=b;
		}
		
		Arrays.sort(pointA);
		Arrays.sort(pointB);
		int idxA = 500;
		int idxB = 500;
		
		while(cnt>0) {			
			if(pointA[idxA]>pointB[idxB]) {
				cnt-=pointA[idxA];
				idxA--;
			}else {
				cnt-=pointB[idxB];
				idxB--;
			}
		}
	}

}
