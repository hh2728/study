package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {

	static int T, N, map[][], minCnt, maxCore;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static List<core> clist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			clist = new ArrayList<>();

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 1) {

						if (r == 0 || c == 0 || r == N - 1 || c == N - 1) {
							continue;
						}
						clist.add(new core(r, c));
					}
				}
			}
			minCnt = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			find(0, 0, 0);
			System.out.println("#" + t + " " + minCnt);
		}

	}

	private static void find(int idx, int corecnt, int wirecnt) {
		if (idx == clist.size()) {
			if (maxCore < corecnt) {
				maxCore = corecnt;
				minCnt = wirecnt;
			} else if (maxCore == corecnt) {
				minCnt = Math.min(wirecnt, minCnt);
			}
			return;
		}

		int r = clist.get(idx).r;
		int c = clist.get(idx).c;

		for (int d = 0; d < 4; d++) {
			int count = 0;
			int nr = r;
			int nc = c;

			while (true) {
				nr += dr[d];
				nc += dc[d];
				
				if(!isOk(nr,nc))
					break;

				if (map[nr][nc] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			int fr = r;
			int fc = c;

			for (int i = 0; i < count; i++) {
				fr += dr[d];
				fc += dc[d];
				map[fr][fc] = 1;
			}

			if (count == 0)
				find(idx + 1, corecnt, wirecnt);
			else {
				find(idx + 1, corecnt + 1, wirecnt + count);

				fr = r;
				fc = c;
				for (int i = 0; i < count; i++) {
					fr += dr[d];
					fc += dc[d];
					map[fr][fc] = 0;
				}
			}
		}

	}

	static boolean isOk(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

	static class core {
		int r, c;

		public core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
