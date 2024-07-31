package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[W];
		
		int l = 0;
		int r = W-1;
		int sum = 0;
		int ans = 0;
		int maxIdx=0;
		for (int i = 0; i < W; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[maxIdx]<arr[i])
				maxIdx=i;	
		}
		
		for (int i = 1; i <= maxIdx; i++) {
			if(arr[l]<=arr[i]) {
				l=i;
				ans+=sum;
				sum=0;
				continue;
			}
			sum+=arr[l]-arr[i];
		}
		
		for (int i = W-2; i >= maxIdx; i--) {
			if(arr[r]<=arr[i]) {
				r=i;
				ans+=sum;
				sum=0;
				continue;
			}
			sum+=arr[r]-arr[i];
		}
		
		System.out.println(ans);
	}

}
