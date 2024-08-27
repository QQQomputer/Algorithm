package brute_force;

public class BOJ4673_S5_셀프넘버 {
	static boolean [] arr;
	public static void main(String[] args) {	
		StringBuilder sb = new StringBuilder();
		arr = new boolean[10036];
		
		recursion(1);
		for (int i = 1; i < 10001; i++) {
			if(!arr[i])
				sb.append(i).append("\n");
		}		
		System.out.println(sb.toString());
	}
	static void recursion(int n) {
		if(n>=10001)return;
		int m = n;
		int sum =0;
		while(m>0) {
			sum+=m%10;
			m/=10;
		}
		int result = n+sum;
		if(!arr[result]) {
			arr[result] = true;
			recursion(result);
		}
//		else return;		
		recursion(n+1);
	}
}