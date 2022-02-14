package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2961_도영이가만든맛있는음식 {

	static int N;
	static long sin, sseun, score;
	static int[][] ingredient;
	static boolean[] checked;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		ingredient = new int[N][2];
		checked = new boolean[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			ingredient[n][0] = Integer.parseInt(st.nextToken());
			ingredient[n][1] = Integer.parseInt(st.nextToken());
		}
		score = Integer.MAX_VALUE;

		calc(N, checked);

		System.out.println(score);
	}

	static void calc(int toCheck, boolean checked[]) {
		if (toCheck == 0) {

			sin = 1;
			sseun = 0;
			int cnt = 0;

			for (int i = 0; i < checked.length; i++) {
				if (checked[i]) {
					sin *= ingredient[i][0];
					sseun += ingredient[i][1];
					cnt++;

				}
			}
			if (cnt == 0)
				return; 			// 무조건 하나 이상의 재료는 써야한다.
			if (score > Math.abs(sin - sseun)) {
				score = Math.abs(sin - sseun);
			}

			return;
		}

		checked[checked.length - toCheck] = true;
		calc(toCheck - 1, checked);
		checked[checked.length - toCheck] = false;
		calc(toCheck - 1, checked);
	}

}
