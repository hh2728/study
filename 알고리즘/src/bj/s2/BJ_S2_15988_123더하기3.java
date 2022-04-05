package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S2_15988_123더하기3 {
	
	static int T,N;
	static long dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new long[1000001];
			dp[1] = 1;		// 1
			dp[2] = 2;		// 1+1 , 2
			dp[3] = 4;		// 1+1+1 , 1+2 , 2+1 , 2
			dp[4] = 7;		// 1+1+1+1, 1+1+2 , 1+2+1 , 2+1+1 , 2+2, 1+3 , 3+1
			for(int i =5; i<= N; i++) {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
			}
			
			
			System.out.println(dp[N]);
		}
	}

}
