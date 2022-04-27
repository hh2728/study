package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_G5_2631_줄세우기 {
	
	static int N;
	static int[] input, dp;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N];
		dp[0] = 1;

		int ans = 0;
		
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(N - ans);

	}
}	
	// 3 7 5 2 6 1 4
	// 1 2
	// 1 2 2
	// 1 2 2 1
	// 1 2 2 1 3
	// 1 2 2 1 3 1
	// 1 2 2 1 3 1 2

