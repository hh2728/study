package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_11722_가장긴감소하는부분순열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		int[] map = new int[n + 1];
		int[] dp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}



		int result = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (map[j] > map[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);

	}

}
