package gold;

import java.io.*;
import java.util.*;
//변수 정리, readInt 메서드 사용
public class Q7569_토마토_ver2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,H, ans;
	static int [][][] space;
	static int [][][] depthArr = new int [2][1_000_000][3];
	static int cnt=0,cur=0,mod=0,rr,cc,hh, unripe;
	static int [] deltaR = {0,0,0,0,1,-1};
	static int [] deltaC = {0,0,-1,1,0,0};
	static int [] deltaH = {-1,1,0,0,0,0};
	public static void main(String args[]) throws IOException
	{			
		M = readInt();
		N = readInt();
		H = readInt();
		
		space = new int[N][M][H];
		
		unripe = 0;
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					space[r][c][h]=readInt();
					if(space[r][c][h]==1) {
						depthArr[mod][cnt][0]=r;
						depthArr[mod][cnt][1]=c;
						depthArr[mod][cnt++][2]=h;
					}else if(space[r][c][h]==0) {
						unripe++;
					}
				}
			}
		}	
		ans = bfs(0);
		
		System.out.println(unripe==0?ans:-1);
	}
	
	public static int bfs(int depth) {
		if(cnt ==0)
			return depth-1;
		
		int next = (mod+1)%2;
		
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < 6; j++) {
				rr = depthArr[mod][i][0]+deltaR[j];
				cc = depthArr[mod][i][1]+deltaC[j];
				hh = depthArr[mod][i][2]+deltaH[j];
				if(check(rr,cc,hh) && space[rr][cc][hh]==0) {
					space[rr][cc][hh]++;
					depthArr[next][cur][0]=rr;
					depthArr[next][cur][1]=cc;
					depthArr[next][cur++][2]=hh;
					unripe--;
				}
			}
			
		}
		cnt = cur;
		cur = 0;
		mod = next;
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