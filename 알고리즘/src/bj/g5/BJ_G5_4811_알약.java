package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_G5_4811_알약 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// dp[i][j] = i개의 완전한 알약, j개의 반절짜리 약이 남았을 때 조합의 수
		double[][] dp = new double[31][31];
		
		for (int i = 1; i <= 30; i++) { // 반알짜리만 남아있으면 일렬로 나열
			dp[0][i] = 1;
		}

		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j < 30; j++) {
				// 완전한 알약 하나를 먹으면 반절짜리 알약이 하나 생긴다.
				if (j == 0)
					dp[i][j] = dp[i - 1][j + 1];
				// 반절짜리 약을 하나 먹은 상황 + 완전한 알약 하나를 먹은 상황
				else
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j + 1];
			}
		}
		// 결과 출력 부분
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			sb.append(String.format("%.0f", dp[n][0])).append('\n');
		}
		System.out.print(sb);
	}
}
