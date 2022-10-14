package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int target = Integer.parseInt(br.readLine());

		int T = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];

		if (T >= 1) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < T; i++) {
				int n = Integer.parseInt(st.nextToken());
				broken[n] = true;
			}

		}

		int answer = Math.abs(target - 100); // 100번에서 시작

		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int length = str.length();

			boolean isBreak = false;

			for (int j = 0; j < length; j++) {
				if (broken[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}

			if (!isBreak) {
				int min = Math.abs(target - i) + length;
				answer = Math.min(min, answer);
			}
		}

		System.out.println(answer);

	}

}
