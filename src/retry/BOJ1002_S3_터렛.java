package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002_S3_터렛 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int x1,y1,r1,x2,y2,r2;
		int dx,dy,dr,sumr,squareOfDistance,ans;

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			ans=0;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			dx = x1-x2;
			dy = y1-y2;
			dr = r1-r2;
			sumr = r1+r2;

			squareOfDistance = dx*dx+dy*dy;
			
			if(dr*dr==squareOfDistance)
				ans= -1;
			else if(sumr*sumr==squareOfDistance)
				ans= 1;
			else if(dx==0 && dy==0) {
				if(dr==0)
					ans = -1;
				else
					ans = 0;
			}				
			else if(sumr*sumr>squareOfDistance)
				ans= 2;
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}

}