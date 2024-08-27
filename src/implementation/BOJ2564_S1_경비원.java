package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1 북 2 남 3 서 4 동
public class BOJ2564_S1_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken())-1;
			int len =Integer.parseInt(st.nextToken());
			//시계방향
			arr[i][1] = arr[i][0]%3==0?len:(arr[i][0]/2==1?r-len:c-len);
			//반시계방향
			arr[i][2] = arr[i][0]%3==0?(arr[i][0]/2==1?r-len:c-len):len;
		}
		
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken())-1;
		int len = Integer.parseInt(st.nextToken());
		//시계방향
		int fwd = dir%3==0?(dir/2==1?r-len:c-len):len;
		//반시계방향
		int rev = dir%3==0?len:(dir/2==1?r-len:c-len);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int result = 0;
			
			if(arr[i][0]/2==dir/2){
				if(dir == arr[i][0]) {
					result = dir/2==1?r-fwd-arr[i][1]:c-fwd-arr[i][1];
				}else
					result = (dir/2==1?c:r)+Math.min(arr[i][1]+fwd, arr[i][2]+rev);
			}else {
				result = Math.min(arr[i][1]+fwd, arr[i][2]+rev);
			}
			
			sum += result;
		}
		System.out.println(sum);
	}
}