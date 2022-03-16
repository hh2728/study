package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2178_미로탐색 {

	static int[][] map;
	static int N, M;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			String str = br.readLine();
			for (int c = 1; c <= M; c++) {
				map[r][c] = str.charAt(c - 1) - '0';
			}
		}

		bfs();

		System.out.println(map[N][M]);

	}

	static void bfs() {

		Queue<point> qu = new LinkedList<point>();
		qu.add(new point(1, 1));
		visit[1][1] = true;

		while (!qu.isEmpty()) {
			point temp = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (isOk(nr, nc) && !visit[nr][nc] && map[nr][nc] == 1) {
					visit[nr][nc] = true;
					qu.add(new point(nr, nc));
					map[nr][nc] = map[temp.r][temp.c] + 1;

				}

			}
		}

	}

	static boolean isOk(int r, int c) {
		return r >= 1 && c >= 1 && r <= N && c <= M;
	}

	static class point {
		int r, c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "point [r=" + r + ", c=" + c + "]";
		}

	}

}
