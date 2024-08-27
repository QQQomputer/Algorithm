package sort;

import java.io.*;
import java.util.*;

public class BOJ10431_S5_줄세우기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, ans;
	static StringTokenizer st;
	static int [] arr;
	//19 20 17 18 15 16 13 14 11 12 9 10 7 8 5 6 3 4 1 2
	public static void main(String[] args) throws IOException {		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			arr = new int[st.countTokens()];
			
			arr[0] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < i; j++) 
					if(arr[j]>arr[i]) {
						int tmp = arr[i];
						for (int k = i; k > j; k--) {
							arr[k] = arr[k-1];
							ans++;
						}
						arr[j] = tmp;
						break;
					}
			}		
			sb.append(t + " " + ans+"\n");
		}
		System.out.println(sb.toString());
	}
	
	
}
