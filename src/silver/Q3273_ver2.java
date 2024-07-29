package silver;

import java.io.*;
import java.util.*;

public class Q3273_ver2  {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, idx, ans;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		idx=1;
		for (int i = 0; i < N; i++)
			arr[i]=Integer.parseInt(st.nextToken()); 

		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			if(arr[i]>=x)
				break;
			
			for (int j = i+1; j < N; j++)
				if(arr[i]+arr[j]==x)
					ans++;
		}
		
		for (int i = N-1; i >0; i--) {
			if(arr[i]>=x) {
				idx=i;
				continue;
			}
			
			if(arr[idx-1]+arr[i]<x)
				break;
			
			for (int j = i-1; j < N; j++) {
				if(arr[i]+arr[j]<x)
					break;				
				if(arr[i]+arr[j]==x)
					ans++;
			}
		}
		
		System.out.println(ans);
	}

}