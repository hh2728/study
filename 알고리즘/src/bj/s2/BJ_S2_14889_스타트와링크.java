package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_14889_스타트와링크 {

	static int N,Min;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N];
		Min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);
		System.out.println(Min);

	}

	// idx는 인덱스, count는 조합 개수
	static void combination(int idx, int count) {
		// 팀 조합이 완성
		if (count == N / 2) {

			diff();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true; // 방문으로 변경
				combination(i + 1, count + 1);
				visit[i] = false; 
			}
		}
	}

	// 두 팀의 능력치 차이를 계산하는 함수
	static void diff() {
		int team_start = 0;
		int team_link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// 스타트팀
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// 링크팀
				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// 두 팀의 점수 차이
		int val = Math.abs(team_start - team_link);

		// 차이가 0이면 무조건 이게 답
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}

		Min = Math.min(val, Min);

	}

}
