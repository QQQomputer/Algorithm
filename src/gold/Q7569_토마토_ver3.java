package gold;

import java.io.*;
import java.util.*;
//arr 3차원 배열 > 1차원 배열로 관리
//	=> 가시성↑
public class Q7569_토마토_ver3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,H, ans;
	static boolean [][][] space;
	static int [] arr = new int[1_000_000*3];
	static int start, end=0,cur=0,rr,cc,hh, unripe;
	static int [] deltaR = {0,0,0,0,1,-1};
	static int [] deltaC = {0,0,-1,1,0,0};
	static int [] deltaH = {-1,1,0,0,0,0};
	public static void main(String args[]) throws IOException
	{			
		M = readInt();
		N = readInt();
		H = readInt();
		
		space = new boolean[N][M][H];
		
		unripe = 0;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {		
					int a = readInt();
					if(a==0) {
						unripe++;
						space[r][c][h]= true;
					}
					else if(a == 1) {
						arr[end++]=r;			
						arr[end++]=c;			
						arr[end++]=h;
					}
				}
			}
		}				
		cur = end;
		ans = bfs(0);
		
		System.out.println(unripe==0?ans:-1);
	}
	
	public static int bfs(int depth) {
		if(cur ==0)
			return depth-1;
		start = end-cur;
		cur = 0;
		for (int i = start; i < end; i+=3) {
			for (int j = 0; j < 6; j++) {
				rr = arr[i]+deltaR[j];
				cc = arr[i+1]+deltaC[j];
				hh = arr[i+2]+deltaH[j];
				if(check(rr,cc,hh) && space[rr][cc][hh]) {
					arr[end+cur++]=rr;
					arr[end+cur++]=cc;
					arr[end+cur++]=hh;
					unripe--;
					space[rr][cc][hh]=false;
				}
			}
			
		}
		end += cur;		
		return bfs(++depth);
	}
	
	public static boolean check(int row, int col, int height) {
		return row >= 0 && row < N && col >= 0 && col < M && height >= 0 && height < H;
	}
	
    public static int readInt() throws IOException {
        int result = 0;
        boolean negative = false;
        int read = br.read();
         
        while (read < '0' || read > '9') {
            if (read == '-') {
                negative = true;
            }
            read = br.read();
        }
 
        while (read >= '0' && read <= '9') {
            result = result * 10 + (read - '0');
            read = br.read();
        }
        return negative ? -result : result;
    }

}