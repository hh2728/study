package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ_G5_14500_테트로미노 {

	static int N, M, ans;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j], visit);
				visit[i][j] = false;
				check(i, j);
			}
		}
		System.out.println(ans);

	}

	static void dfs(int r, int c, int cnt, int sum, boolean[][] visit) {

		if (cnt >= 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];

			if (!isOk(nr,nc)) {
				continue;
			}

			visit[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum + map[nr][nc], visit);
			visit[nr][nc] = false;
		}
	}
	
	// ㅗ 모양 찾기
	
	static void check(int r, int c) {
		if (r < N - 2 && c < M - 1)	//ㅏ
			ans = Math.max(ans, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);

		if (r < N - 2 && c > 0)	//ㅓ
			ans = Math.max(ans, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);

		if (r < N - 1 && c < M - 2)	//ㅜ
			ans = Math.max(ans, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);

		if (r > 0 && c < M - 2)	//ㅗ
			ans = Math.max(ans, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
	}
	
	static boolean isOk(int r,int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}
