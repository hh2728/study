package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_1987_알파벳 {

	static int R, C, ans;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int deltas[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c) - 'A';
			}
		}

		ans = 0;
		dfs(0, 0, 0);

		System.out.println(ans);
	}

	public static void dfs(int r, int c, int count) {

		if (visit[map[r][c]]) {
			ans = Math.max(count, ans);
			return;
		} else {
			visit[map[r][c]] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					dfs(nr, nc, count + 1);
				}
			}

			visit[map[r][c]] = false;

		}

	}

}
