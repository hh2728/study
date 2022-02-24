package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_4047_영준이의카드카운팅 {

	static int T;
	static int[] S, D, H, C;
	static boolean isError;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			isError = false;
			S = new int[14];
			D = new int[14];
			H = new int[14];
			C = new int[14];

			st = new StringTokenizer(br.readLine(), "H,S,C,D", true);

			while (st.hasMoreTokens()) {

				String s = st.nextToken();

				int num = Integer.parseInt(st.nextToken());

				switch (s) {
				case "S":
					if (S[num] >= 1) {
						isError = true;
						continue;
					}
					S[num]++;
					break;
				case "D":
					if (D[num] >= 1) {
						isError = true;
						continue;
					}
					D[num]++;
					break;
				case "H":
					if (H[num] >= 1) {
						isError = true;
						continue;
					}
					H[num]++;
					break;
				case "C":
					if (C[num] >= 1) {
						isError = true;
						continue;
					}
					C[num]++;
					break;
				}

			}
			System.out.print("#" + t + " ");
			if (isError) {
				System.out.println("ERROR");
				continue;
			}

			int count = 0;
			for (int i = 1; i < S.length; i++) {
				if (S[i] == 0)
					count++;

			}
			System.out.print(count + " ");

			count = 0;
			for (int i = 1; i < D.length; i++) {
				if (D[i] == 0)
					count++;

			}
			System.out.print(count + " ");

			count = 0;
			for (int i = 1; i < H.length; i++) {
				if (H[i] == 0)
					count++;

			}
			System.out.print(count + " ");

			count = 0;
			for (int i = 1; i < C.length; i++) {
				if (C[i] == 0)
					count++;

			}
			System.out.print(count + " ");
			System.out.println();
		}

	}

}
