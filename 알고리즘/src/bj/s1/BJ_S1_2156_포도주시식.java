package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_2156_포도주시식 {
	
	static int N;
	static int[] arr,dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int n = 1; n<=N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N>1) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2]+arr[i], dp[i-3] + arr[i-1] + arr[i]));
		}
		
		System.out.println(dp[N]);
		
	}

}
