package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//26 40 83	14
//49 60 57	8
//13 89 99	76
public class Q1149 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {		
		int N = readInt();
		int minSum = 0;
		int min1=0,min2=0;
		int [] delta = new int[N];
		int [] rgb = new int[3];
		boolean [] colored = new boolean[N];
		
		for (int n = 0; n < N; n++) {
			rgb[0] = readInt();
			rgb[1] = readInt();
			rgb[2] = readInt();			
			Arrays.sort(rgb);			
			minSum+=rgb[0]+rgb[1];
			delta[n]=rgb[1]-rgb[0];
		}
		

	}
	private static int readInt() throws IOException {
		int result = 0;
		int read = br.read();
		
		while(read > '9' || read < '0')
			read=br.read();
					
		while(read <= '9' && read >= '0') {
			result = 10 * result + read - '0';
			read = br.read();
		}
		
		return result;
	}
}
