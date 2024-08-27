package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ11003_P5_최솟값찾기 {

	static int N, ans;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());


		//N-L+1
		int [] a = monotoneDeque(L);
		
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
	static int[] monotoneDeque(int k) {
		Deque<Integer> q = new ArrayDeque<>();
		
        int len = arr.length;
        int[] result = new int[len];
		
		for (int i = 0; i < len; i++) {
			
			while(!q.isEmpty()&&q.peekFirst() < i-k+1) {
				q.pollFirst();
			}
			
			while(!q.isEmpty()&& arr[q.peekLast()] > arr[i]) {
				q.pollLast();
			}
			
			q.offerLast(i);
			
			result[i]=arr[q.peekFirst()];
		}
		return result;
	}

}
