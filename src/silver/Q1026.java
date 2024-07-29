package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {		
		int N = Integer.parseInt(br.readLine());
		int [] A =new int[N];
		int [] B =new int[N];
		boolean [] arr = new boolean[50];
		
		for (int i = 0; i < N; i++)
			A[i]=readInt();
		
		for (int i = 0; i < N; i++)
			B[i]=readInt();
		
		Arrays.sort(A);
		
		int sum =0;
		for (int i = 0; i < N; i++) {
			int max = -1;
			int idx = -1;
			for (int j = 0; j < N; j++) {
				if(arr[j])
					continue;				
				if(B[j]>max) {
					max = B[j];
					idx = j;
				}				
			}
			arr[idx] = true;
			sum+=A[i]*max;
		}
		System.out.println(sum);
	}
	
	private static int readInt() throws IOException {
		int result = 0;
		int read = br.read();
		
		while(read > '9' || read < '0')
			read=br.read();
					
		while(read <= '9' && read >= '0') {
			result = 10 * result + read - '0';
			read = br.read();
		}
		
		return result;
	}
}
