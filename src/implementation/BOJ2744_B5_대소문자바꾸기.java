package implementation;

import java.io.*;
import java.util.*;

public class BOJ2744_B5_대소문자바꾸기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char [] charArr = str.toCharArray();
		
		for(int i = 0 ;i<charArr.length;i++) {
			if(charArr[i]>='a') {
				charArr[i] = (char) (charArr[i]-('a'-'A'));
			}else {
				charArr[i] = (char) (charArr[i]+('a'-'A'));
			}
			System.out.print(charArr[i]);
		}
		
	}

}
