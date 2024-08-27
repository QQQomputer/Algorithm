package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2605_B2_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		List<Integer> list = new ArrayList<>();		
		for (int i = 0; i < n; i++)
			list.add(i-Integer.parseInt(st.nextToken()), i+1);

		for (int i : list)
			sb.append(i).append(" ");
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
	}
}
