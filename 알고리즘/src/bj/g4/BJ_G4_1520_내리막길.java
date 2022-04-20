package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_1520_내리막길 {
	static int T, M, N, count; // 변수 선언
	static int[][] map; // 지도
	static int[][] dp;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // 사방탐색

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력받은 데이터 자르기
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 지도의 가로,세로 받기

		map = new int[M][N]; // 지도 배열 선언
		dp = new int[M][N];

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()); // 지도 입력 받기
				dp[r][c] = -1;
			}
		}

		System.out.println(dfs(0, 0)); // 출력
	}

	private static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) { // 지도의 목적지 도착하면 count를 증가시켜 도착하는 경로가 하나 더있다고 표시
			return 1;
		}

		if (dp[r][c] != -1) {
			return dp[r][c];
		} else {
			dp[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1]; // 사방탐색

				if (!isOk(nr, nc)) {
					continue;
				}

				if (map[r][c] > map[nr][nc]) { // 내려갈수있으면 더해라
					dp[r][c] += dfs(nr, nc);
				}
			}
		}
		return dp[r][c];
	}

	private static boolean isOk(int r, int c) { // 다음 좌표가 지도안에 있나 확인하기
		return r >= 0 && c >= 0 && r < M && c < N;
	}
}
