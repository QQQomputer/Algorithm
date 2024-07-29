package silver;

import java.io.*;
import java.util.*;
//747
//
//
//512	256	128	64	32	16	8	4	2	1
//1		0	1	1	1	0	1	0	1	1
//
//256	64	16	4	1
//2		3	2	2	3
//2		2	
//
//
//100	10	1
//7		4	7
public class Q11068 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	static int n, ans;
	public static void main(String[] args) throws IOException {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder ans = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			boolean flag = false;
			int num = Integer.parseInt(br.readLine());
			
			for (int b = 2; b < 65; b++) {
				sb1.setLength(0);
				sb2.setLength(0);
				int n = num;
				int m = 1;
				int exponet = 0;
				
				while(n>=m) {
					m*=b;
					exponet++;
				}
				
				for (int i = 0; i < exponet; i++) {
					m/=b;
					int value = n/m;
					if(value < 10) {
						sb1.append(value);
						sb2.insert(0,value);
					}else {
						sb1.append((char)('A'+value-10));
						sb2.insert(0,(char)('A'+value-10));
					}
					n%=m;
				}
				
				if(sb1.length()> 0 && sb1.toString().equals(sb2.toString())) {
//					System.out.println(b);
//					System.out.println(sb1.toString());
//					System.out.println(sb2.toString());
					flag = true;
					break;
				}
			}
			ans.append(flag?1:0).append("\n");			
		}
		System.out.println(ans.toString());
	}

}