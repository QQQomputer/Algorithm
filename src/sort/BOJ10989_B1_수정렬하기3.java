package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989_B1_수정렬하기3 {

	public static void main(String[] args) throws IOException {		
		//10,000,000 x 4byte  => 38MB 불가		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int [] arr = new int[10001];
		
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		while(cnt-->0)
			arr[Integer.parseInt(br.readLine())]++;

		for (int i = 1; i < arr.length;i++) {
			if(arr[i]<=0)
				continue;
			
			sb.append(i).append("\n");
			
			if(--arr[i]>0)
				--i;
		}
		System.out.println(sb.toString());
	}
}
