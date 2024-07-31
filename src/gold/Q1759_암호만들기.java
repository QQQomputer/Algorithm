package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1. 145
public class Q1759_암호만들기 {
//모음 5개		a,e,i,o,u
//자음 21개
//65, 97~122
//97,101,105,111,117
//경우의 수 구하는 문제면 => 모든 경우의 수 - 자음으로만 만든 경우의수
//하지만 다 출력

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb= new StringBuilder();
	static char [] arr;
	static char [] vowel = {'a','e','i','o','u'};
	static char [] isUsed;
	static int sum=0;
	static int L,C,last;
	public static void main(String[] args) throws IOException {		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		last = C-L+1;
		arr = new char[C];
		isUsed= new char[L];
		
		for (int i = 0; i < C; i++)
			arr[i] = readChar();
		
		Arrays.sort(arr);
		
		dfs(0,0);		

		System.out.println(sb);
	}
	static void dfs(int depth, int idx) {
		if(depth==L) {
			if(sum==0 || L-sum<2)
				return;
			sb.append(isUsed).append("\n");
			return;
		}
		
		for (int i = idx; i < last+depth; i++) {
			isUsed[depth]=arr[i];
			//모음 들어감?
			if(Arrays.binarySearch(vowel, arr[i])>=0) {
				sum++;
				dfs(depth+1,i+1);
				sum--;
			}else
				dfs(depth+1,i+1);
		}
	}
	static char readChar() throws IOException {
		int read = br.read();
		
		while(read<97 || read > 122)
			read = br.read();
		
		return (char)read;
	}

//	static int factorial(int n) {
//		if(n==1)
//			return 1;		
//		return n*factorial(n-1);
//	}
}
