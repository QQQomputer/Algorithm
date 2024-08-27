package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309_B1_일곱난쟁이 {
	static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] arr = new int[9];
		
		for (int i = 0; i < 9; i++)
			arr[i]=Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int [] tiny = new int[7];
		
		dfs(0,0,0,arr,tiny);
	}
	static void dfs(int depth, int idx, int sum, int[] arr,int[] tiny) {
		if(depth == 7) {
			if(sum==100) {
				for (int i = 0; i < tiny.length; i++) {
					System.out.println(tiny[i]);
				}
				found = true;
			}
			return;
		}
		if(sum>100)return;
		
		for (int i = idx; i < 9; i++) {
			tiny[depth]=arr[i];
			dfs(depth+1,i+1,sum+arr[i],arr,tiny);
			if(found) return;
		}
	}
}