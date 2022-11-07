package bj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_1937_욕심쟁이판다 {

	static int N;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] dp, map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < N; w++) {
				map[i][w] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int w = 0; w < N; w++) {

				ans = Math.max(DFS(i, w), ans);
			}
		}

		System.out.print(ans);

	}

	public static int DFS(int r, int c) {
		// 이미 방문한곳??
		if (dp[r][c] != 0) {
			return dp[r][c];
		}

		dp[r][c] = 1;

		int nr, nc;

		for (int d = 0; d < 4; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];

			// 범위에서 벗어났을 경우 continue.
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}

			// 현재 대나무 숲보다 더 많은 양의 대나무가 있는 경우.
			if (map[r][c] < map[nr][nc]) {

				dp[r][c] = Math.max(dp[r][c], DFS(nr, nc) + 1);
				//DFS(nr, nc);

			}
		}
		return dp[r][c];
	}

}
