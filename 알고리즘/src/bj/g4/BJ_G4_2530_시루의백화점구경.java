package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2530_시루의백화점구경 {

	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N,M,K;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int spr = 0;
		int spc = 0;

		// 지도 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 4) { // 시작점 위치 저장
					spr = r;
					spc = c;
				}
				map[r][c] = num;
			}
		}
		
		// 지도에 마네킹 처리
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 3) {
					change(r, c ,map);
				}
			}
		}
		
		// 최단 거리 찾기
		int answer = bfs(spr, spc, map);

		// 거리를 음수로 표현했기 때문에 -1을 곱하여 출력한다
		System.out.println(answer * (-1));

	}

	static void change(int r, int c, int[][] map) {

		Queue<int[]> qu = new LinkedList<>();

		qu.add(new int[] { r, c });

		map[r][c] = 1; // 마네킹의 위치부터 변경

		while (!qu.isEmpty()) {

			int[] temp = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + deltas[d][0];
				int nc = temp[1] + deltas[d][1];

				// 지도안에 없으면 빠이	
				// 시작점이거나 이미 갈 수 없는곳
				if (!isOk(nr,nc) || map[nr][nc] == 4 || map[nr][nc] == 1) {
					continue;
				}

				// 마네킹 범위를 갈 수 없는 곳으로 바꾼다.
				if (Math.abs(r - nr) + Math.abs(c - nc) <= K) {
					map[nr][nc] = 1;
					qu.add(new int[] { nr, nc });					
				}

			}
		}
	}

	static int bfs(int r, int c,int[][] map) {
		Queue<int[]> qu = new LinkedList<>();

		qu.add(new int[] { r, c, 0 });

		map[r][c] = -1; // 초기위치 변경

		while (!qu.isEmpty()) {
			int[] temp = qu.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + deltas[d][0];
				int nc = temp[1] + deltas[d][1];
				int np = temp[2];
				
				// 지도 밖이면 안녕~
				if (!isOk(nr,nc)) {
					continue;
				}

				// 다음이 의자이면 바로 반환
				if (map[nr][nc] == 2) {
					return np-1; 
				}

				// 갈 수 있는 곳이면, 들른적도 없고
				if (map[nr][nc] == 0) {
					map[nr][nc] = np-1;
					qu.add(new int[] { nr, nc, np-1});
					
				}
			}
		}
		return 1;
	}
	
	static boolean isOk(int nr, int nc) {
		return nc>=0 && nr>=0 && nc< M && nr < N;
	}
}
