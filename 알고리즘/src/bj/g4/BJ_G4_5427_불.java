package bj.g4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_5427_불 {

	static int W, H, T;
	static char map[][];
	static boolean visit[][];
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Point> fire;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		int y = 0;
		int x = 0;

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			fire = new LinkedList<>();

			for (int r = 0; r < H; r++) {
				String line = br.readLine();
				for (int c = 0; c < W; c++) {
					map[r][c] = line.charAt(c);
					if (map[r][c] == '@') {
						y = r;
						x = c;
					} else if (map[r][c] == '*')
						fire.add(new Point(r, c));	//불이면 큐에 넣기
				}
			}
			escape(y, x);
		}
		System.out.println(sb.toString());
	}

	public static void escape(int r, int c) {
		Queue<Point> qu = new LinkedList<>();
		visit = new boolean[H][W];
		visit[r][c] = true;
		qu.offer(new Point(-1, -1)); // 한턴 확인하기 위해서
		qu.offer(new Point(r, c));
		int time = -1;

		while (!qu.isEmpty()) {
			Point temp = qu.poll();

			if (temp.r == -1 && temp.c == -1) { // 한턴 끝나면 불옮기고 시간 더하기
				burn();

				if (!qu.isEmpty())	//큐가 아직 채워져있으면 다시 한턴 구별
					qu.offer(temp);
				time++;
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (!isOk(nr,nc)) { // 맵을 빠져나가면 탈출 성공
					sb.append(time + 1 + "\n");
					return;
				}
				if (isOk(nr, nc) && map[nr][nc] == '.' && !visit[nr][nc]) { // 이동
					qu.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}

		sb.append("IMPOSSIBLE\n");
	}

	public static void burn() {
		int size = fire.size();

		for (int s = 0; s < size; s++) {
			Point temp = fire.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + deltas[d][0];
				int nc = temp.c + deltas[d][1];

				if (isOk(nr, nc) && (map[nr][nc] == '.' || map[nr][nc] == '@')) {
					fire.offer(new Point(nr, nc));
					map[nr][nc] = '*';
				}
			}
		}
	}

	static boolean isOk(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
