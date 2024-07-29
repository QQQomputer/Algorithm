package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1302_베스트셀러 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,L;
	static String [] strArr;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		int max = 0;
		String max_str = "";
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(map.get(str)!=null)
				map.put(str, map.get(str)+1);
			else
				map.put(str, 1);
			
			if(map.get(str)>max) {
				max=map.get(str);
				max_str=str;
			}else if(map.get(str)==max) {
				int result = str.compareTo(max_str);
				if(result<0) {
					max=map.get(str);
					max_str=str;
				}
			}
		}
		
		System.out.println(max_str);
	}
}
