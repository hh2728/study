package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_3055_탈출 {

	static int R, C, ans;
	static char[][] map;
	static Queue<Point> go = new LinkedList<>();	//고슴도치 이동
	static Queue<Point> water = new LinkedList<>();	// 물 이동
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = Integer.MAX_VALUE;
		
		// 지도 입력받아서, 고슴도치, 물 위치 저장

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'S') {
					go.add(new Point(r, c, 0));
				} else if (map[r][c] == '*') {
					water.add(new Point(r, c, 0));
				}
			}
		}

		bfs();
		
		System.out.println(ans == Integer.MAX_VALUE? "KAKTUS" : ans);

	}

	private static void bfs() {
		
		//고슴도치가 이동할 수 있을 때 까지 계속 반복
		while (go.size() != 0) {
			//물이 찰 예정인 곳은 고슴도치가 가지 못함. 물부터 시작.
			int len = water.size();
			for (int i = 0; i < len; i++) {

				Point temp = water.poll();

				for (int d = 0; d < 4; d++) {
					int nr = temp.r + deltas[d][0];
					int nc = temp.c + deltas[d][1];

					if (!isOk(nr, nc))
						continue;
					if (map[nr][nc] == 'D' || map[nr][nc] == 'X' || map[nr][nc] == '*')
						continue;
					//아무것도 없는데만 물 전파
					map[nr][nc] = '*';
					water.add(new Point(nr, nc, 0));
				}
			}

			len = go.size();
			for (int i = 0; i < len; i++) {
				Point temp = go.poll();

				for (int d = 0; d < 4; d++) {
					int nr = temp.r + deltas[d][0];
					int nc = temp.c + deltas[d][1];
					
					if (!isOk(nr, nc))
						continue;
					// 비버굴 도착? 
					if (map[nr][nc] == 'D') {
						ans = Math.min(ans, temp.time + 1);
						return;
					// 이동할 수 있는 곳이면 이동.
					} else if (map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						go.add(new Point(nr, nc, temp.time + 1));
					}
				}
			}
		}
	}

	private static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

}
