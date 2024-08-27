package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1 동 2 서 3 남 4 북
public class BOJ2477_S2_참외밭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[6];
		int [] dir = new int[6];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0;
		for (int i = 0; i < 6; i++)
			if(dir[i] == dir[(i+2)%6]) {
				if(dir[(i+1)%6] == dir[(i+3)%6])
					start=i;
				else
					start=(i-1)%6;
				break;
			}

		int square = arr[(start+5)%6]*arr[(start+4)%6];
		int subSquare = arr[(start+1)%6]*arr[(start+2)%6];
		
		System.out.println((square-subSquare)*n);
	}
}