package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1124_S1_언더프라임 {
	static boolean [] isNotPrime;
	static int [] prime;
	static int A,B,sum;
	static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[B+1];
		prime = new int[B];
		sum=0;
		
		eratos();
		
		for (int i = A; i < B+1; i++) {
			int cur = i;
			int cnt = 0;
			for (int j = 0; j < idx; j++) {
				if(cur==1)
					break;
				while(cur%prime[j]==0) {
					cur/=prime[j];
					cnt++;
				}
			}

			if(!isNotPrime[cnt])
				sum++;
		}

		System.out.println(sum);
	}
	
	static void eratos() {
		isNotPrime[1] = true;
		for (int i = 2; i < B+1; i++) {
			if(!isNotPrime[i]) {
				prime[idx++]=i;
				for (int j = i+i; j < B+1; j+=i) {
					isNotPrime[j]=true;
				}
			}
		}
	}
}
