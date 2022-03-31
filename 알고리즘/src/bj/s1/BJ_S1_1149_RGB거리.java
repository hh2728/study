package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1149_RGB거리 {

	static int N;
	static int[][] dp;
	static int[][] house;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][4];
		dp = new int[N+1][4];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 3; i++) {
				house[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=3; i++) {
			dp[1][i] = house[1][i];
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=3; j++) {
				if(j==1) {
					dp[i][j] = Math.min(dp[i-1][j+1] + house[i][j], dp[i-1][j+2] + house[i][j]);
				}else if(j==2) {
					dp[i][j] = Math.min(dp[i-1][j-1] + house[i][j], dp[i-1][j+1] + house[i][j]);
				}else {
					dp[i][j] = Math.min(dp[i-1][j-2] + house[i][j], dp[i-1][j-1] + house[i][j]);
				}
				
			}
		}
		
		System.out.println(Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3])));
	}

}
