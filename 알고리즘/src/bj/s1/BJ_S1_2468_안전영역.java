package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2468_안전영역 {

	static int N, max, cnt, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		max = 0;
		ans = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (max < map[r][c])
					max = map[r][c];
			}
		}

		for (int i = 0; i <= max; i++) {
			visit = new boolean[N][N];
			cnt = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > i && !visit[r][c]) {
						bfs(r, c, i);
						cnt++;
					}
				}
			}

			if (ans < cnt)
				ans = cnt;
		}
		System.out.println(ans);
	}

	public static void bfs(int r, int c, int level) {

		Queue<point> qu = new LinkedList<>();
		point tem = new point(r, c);
		qu.add(tem);
		visit[r][c] = true;

		while (!qu.isEmpty()) {
			point temp = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nr = deltas[d][0] + temp.r;
				int nc = deltas[d][1] + temp.c;

				if (isOk(nr, nc) && !visit[nr][nc] && map[nr][nc] > level) {
					qu.add(new point(nr, nc));
					visit[nr][nc] = true;
				}
			}

		}

	}

	static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
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
