package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300_B2_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] arr = new int[13];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())*6+Integer.parseInt(st.nextToken())]++;
		}
		
		int room = 0;
		for (int i = 1; i < arr.length; i++)
			room += arr[i]/K+(arr[i]%K!=0?1:0);
		System.out.println(room);
	}
}