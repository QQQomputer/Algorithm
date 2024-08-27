package sample;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_일곱난쟁이 {

	static int N=9, R=7;
	static int[] p;
	static int[] nums, result;
	// visited 필요없다. 1) 중복사용필요없다. => 2)선택 비선택을 구별할 필요가 없다. 
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		p=new int[N];
		for (int i = 0; i < N; i++) {
			p[i]=scann.nextInt();
		}
		nums=new int[R];
		result=new int[R];
		nCr(0,0,0);
		Arrays.sort(nums);
		for (int s : result) {
			System.out.println(s);
		}
	}
	// 추가 -> 모든 깊이까지의 합 tot 
	static void nCr(int cnt, int start, int tot) {
		if(cnt==R) {    // BC 7 depth
			if(tot==100)
				System.arraycopy(nums, 0, result, 0, R);
			return ;
		}
		for (int i = start; i < N; i++) {
			nums[cnt]=p[i];
			nCr(cnt+1, i+1, tot+p[i]);
			nums[cnt]=0;
		}
	}

}
