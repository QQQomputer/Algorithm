package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//투포인터
//양끝시작
//l<r 까지
//차이가 0이면 끝
public class BOJ2470_G5_두용액 {
	static int N,min, acid, alkal;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		min=Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());	
		arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		binarySearch();
		System.out.println(arr[alkal] + " "+ arr[acid]);
	}
	static void binarySearch() {
		int l = 0;
		int r = N-1;
		while(l<r) {
			int sum = arr[l]+arr[r];
			if(min>Math.abs(sum)) {
				acid=r;
				alkal=l;
				min = Math.abs(sum);
			}
			if(0<sum)r--;
			else if(0>sum)l++;
			else {break;}
		}
	}
}
