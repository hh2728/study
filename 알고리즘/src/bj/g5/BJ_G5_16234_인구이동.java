package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16234_인구이동 {

	static class Point {
		int r, c, people;

		public Point(int r, int c, int people) {
			super();
			this.r = r;
			this.c = c;
			this.people = people;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", people=" + people + "]";
		}

	}

	static int N, L, R;
	static int[][] map, finish;
	static boolean[][] visit;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		finish = new int[N][N];

		int day=0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			boolean isfinish = true;
			visit = new boolean[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					finish[r][c] = map[r][c];
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visit[r][c]) {
						go(r, c);
					}
				}
			}
			
			outer : for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(finish[r][c] != map[r][c]) {
						isfinish = false;
						break outer;
					}
				}
			}

			if(isfinish) {
				break;
			}
			day++;

		}

		System.out.println(day);

	}

	static void go(int r, int c) {
		Queue<Point> qu = new LinkedList<>();
		List<Point> plist = new ArrayList<>();
		qu.add(new Point(r, c, map[r][c]));
		plist.add(new Point(r, c, map[r][c]));

		visit[r][c] = true;
		int count = 1;
		int sum = map[r][c];

		while (!qu.isEmpty()) {
			Point temp = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];
		

				if (isOk(nr, nc) && !visit[nr][nc]) {
		
					if (L <= Math.abs(temp.people - map[nr][nc]) && Math.abs(temp.people - map[nr][nc]) <= R) {
						qu.add(new Point(nr, nc, map[nr][nc]));
						count++;
						sum += map[nr][nc];
						visit[nr][nc] = true;

						plist.add(new Point(nr, nc, map[nr][nc]));
					}

				}
			}

		}

		int avg = sum / count;

		for (int i = 0; i < plist.size(); i++) {
			Point temp = plist.get(i);
			map[temp.r][temp.c] = avg;
		}

	}

	static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
