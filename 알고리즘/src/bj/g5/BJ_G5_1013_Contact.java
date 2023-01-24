package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G5_1013_Contact {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String vega = "(100+1+|01)+";
		
		for(int t=0; t<T; t++) {
			String temp = br.readLine();
			if(temp.matches(vega)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}

}
