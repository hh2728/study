package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B2_13300_방배정 {

	static int N, K, S, Y, ans;
	static int[][] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new int[2][7];
		ans = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			students[S][Y]++;

		}

		for (int i = 1; i <= 6; i++) {
			if (students[0][i] == 0)
				continue;

			else if (students[0][i] <= K)
				ans++;
			else if (students[0][i] % K == 0)
				ans += students[0][i] / K;
			else if (students[0][i] % K != 0) {
				ans += students[0][i] / K;
				ans++;
			}
		}

		for (int i = 1; i <= 6; i++) {
			if (students[1][i] == 0)
				continue;

			else if (students[1][i] <= K)
				ans++;
			else if (students[1][i] % K == 0)
				ans += students[1][i] / K;
			else if (students[1][i] % K != 0) {
				ans += students[1][i] / K;
				ans++;
			}
		}

		System.out.println(ans);

	}

}
