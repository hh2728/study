package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_1244_스위치켜고끄기 {

	static int N, X;
	static int[] swit;
	static int R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		swit = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int j = 1; j <= N; j++) {
			swit[j] = Integer.parseInt(st.nextToken());
		}

		R = Integer.parseInt(br.readLine());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (s == 1) {
				int j = 1;
				while (true) {
					if (n * j > N)
						break;

					if (swit[n * j] == 0) {
						swit[n * j] = 1;

					} else {
						swit[n * j] = 0;

					}
					j++;

				}
			} else if (s == 2) {
				if (swit[n] == 1) {
					swit[n] = 0;
				} else {
					swit[n] = 1;
				}
				int j = 1;
				while (true) {

					if (n - j < 1 || n + j > N)
						break;
					if (swit[n - j] != swit[n + j]) {
						break;
					} else if (swit[n - j] == swit[n + j] && swit[n - j] == 1) {
						swit[n - j] = 0;
						swit[n + j] = 0;
					} else if (swit[n - j] == swit[n + j] && swit[n - j] == 0) {
						swit[n - j] = 1;
						swit[n + j] = 1;
					}
					j++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(swit[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
