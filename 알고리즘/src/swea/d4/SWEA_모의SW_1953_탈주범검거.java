package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의SW_1953_탈주범검거 {

	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	static int T, N, M, SR, SC, L;
	static int[][] map;
	static int[][] time;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 하 좌 우
	static Queue<Point> qu = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			SR = Integer.parseInt(st.nextToken());
			SC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			time = new int[N][M];
			visited = new boolean[N][M];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					time[r][c] = Integer.MAX_VALUE;
				}
			}

			bfs(SR, SC);

			int count = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (time[r][c] <= L) {
						count++;
					}
				}
			}
			System.out.println("#" + t + " " + count);
		}

	}

	private static void up(Point temp) {
		// 상
		int nr = temp.r - 1;
		int nc = temp.c;
		if (isOk(nr, nc) && !visited[nr][nc]) {
			if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {

				qu.add(new Point(nr, nc, temp.time + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static void down(Point temp) {
		// 하
		int nr = temp.r + 1;
		int nc = temp.c;
		if (isOk(nr, nc) && !visited[nr][nc]) {
			if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
				qu.add(new Point(nr, nc, temp.time + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static void left(Point temp) {
		// 좌
		int nr = temp.r;
		int nc = temp.c - 1;
		if (isOk(nr, nc) && !visited[nr][nc]) {
			if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
				qu.add(new Point(nr, nc, temp.time + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static void right(Point temp) {
		// 우
		int nr = temp.r;
		int nc = temp.c + 1;
		if (isOk(nr, nc) && !visited[nr][nc]) {
			if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
				qu.add(new Point(nr, nc, temp.time + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static void bfs(int r, int c) {
		// Queue<Point> qu = new LinkedList<>();
		qu.add(new Point(r, c, 1));
		visited[r][c] = true;

		while (!qu.isEmpty()) {
			Point temp = qu.poll();
			if (time[temp.r][temp.c] > temp.time) {
				time[temp.r][temp.c] = temp.time;
			}
			switch (map[temp.r][temp.c]) {

			case 1: // 1번 상하좌우일때
				// System.out.println("1");

				for (int d = 0; d < 4; d++) {

					if (d == 0) {
						up(temp);
					} else if (d == 1) {
						down(temp);
					} else if (d == 2) {
						left(temp);
					} else if (d == 3) {
						right(temp);
					}
				}
				break;
			case 2: // 상하일때
				// System.out.println("2");
				for (int d = 0; d < 2; d++) {
					if (d == 0) {
						up(temp);
					} else if (d == 1) {
						down(temp);
					}
				}
				break;
			case 3: // 좌우일때
				// System.out.println("3");
				for (int d = 2; d < 4; d++) {
					if (d == 2) {
						left(temp);
					} else if (d == 3) {
						right(temp);
					}
				}
				break;
			case 4: // 상 우일때
				// System.out.println("4");
				for (int d = 0; d < 4; d += 3) {
					if (d == 0) {
						up(temp);
					} else if (d == 3) {
						right(temp);
					}
				}
				break;
			case 5: // 하 우일때
				// System.out.println("5");
				for (int d = 1; d < 4; d += 2) {
					if (d == 1) {
						down(temp);
					} else if (d == 3) {
						right(temp);
					}
				}
				break;
			case 6: // 하 좌 일때
				// System.out.println("6");
				for (int d = 1; d < 3; d++) {
					if (d == 1) {
						down(temp);
					} else if (d == 2) {
						left(temp);
					}
				}
				break;
			case 7: // 상 좌 일때
				// System.out.println("7");
				for (int d = 0; d < 3; d += 2) {
					if (d == 0) {
						up(temp);
					} else if (d == 2) {
						left(temp);
					}
				}
				break;
			}

		}
	}

	private static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
