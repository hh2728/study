package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_7562_나이트의이동 {

	static int T, N, cnt;
	static boolean[][] visit;
	static int[][] map;
	static point start, target;
	static int deltas[][] = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];

			st = new StringTokenizer(br.readLine());
			start = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			target = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			//입력완료..
			
			//탐색하자..
			bfs(start.r, start.c);

			System.out.println(cnt);
		}
	}

	static void bfs(int r, int c) {
		Queue<point> qu = new LinkedList<point>();
		//시작점 큐에 넣기
		qu.add(new point(r, c));
		//시작점 방문 ok!
		visit[r][c] = true;
		// 카운트 초기화
		cnt =0;

		//안에 있는 if문에서 바로 나오기 위한 outer
		outer:while (!qu.isEmpty()) {
			// 변수를 할당해서 하지 않으니까 계속 값이 바꼇다.. 멍청했다.
			int qq = qu.size();
			
			// 그래서 qq로 받아서 고정시켜주었다.
			for (int i = 0; i < qq; i++) {
				//큐에서 값꺼내서
				point now = qu.poll();

				// 목표위치이면 밖으로!
				if (now.r == target.r && now.c == target.c) {
					break outer;
				}

				//탐색!
				for (int d = 0; d < 8; d++) {
					int nr = now.r + deltas[d][0];
					int nc = now.c + deltas[d][1];

					if (isOk(nr, nc) && !visit[nr][nc]) {
						//있으면 방문처리하고 큐에 넣기
						// 꺼낼때 방문처리하면 중복이 생길수 있다.
						visit[nr][nc] = true;
						qu.add(new point(nr, nc));

					}
				}
				
			}
			// 한번에 움직일 수 있는거 끝나면 이동횟수 올려주기.
			cnt++;

		}

	}
	//범위안에 있나 찾기
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
