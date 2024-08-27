package math;

import java.io.*;
import java.util.*;

public class BOJ10158_S3_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int p, q, curX, curY, tw, th;

		curX=1;
		curY=1;
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		p=Integer.parseInt(st.nextToken());
		q=Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		tw = time%(2*w);
		th = time%(2*h);
		
		
		for (int i = 0; i < tw; i++) {
			if(p == 0 || p == w)
				curX*=-1;
			p+=curX;
		}
			

		for (int i = 0; i < th; i++) {
			if(q == 0 || q == th)
				curY*=-1;
			q+=curY;
		}
		
		System.out.println(p+" "+q);
	}

}
