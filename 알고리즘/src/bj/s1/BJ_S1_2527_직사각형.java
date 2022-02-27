package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {

	static int r1, c1, r2, c2;
	static int r3, r4, c3, c4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 0; t < 4; t++) {

			st = new StringTokenizer(br.readLine());

			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			c3 = Integer.parseInt(st.nextToken());
			r3 = Integer.parseInt(st.nextToken());
			c4 = Integer.parseInt(st.nextToken());
			r4 = Integer.parseInt(st.nextToken());

			if ((c2 == c3 && r2 != r3) || (c1 == c4 && r2 != r3) || (c2 != c3 && r1 == r4) || (c1 != c4 && r1 == r4)) {
				System.out.println("b");
			} else if ((c2 == c3 && r2 == r3) || (c1 == c4 && r2 == r3) || (c2 == c3 && r1 == r4)|| (c1 == c4 && r1 == r4)) {
				System.out.println("c");
			} else if (c2 < c3 || c4 < c1 || r2 < r3 || r4 < r1) {
				System.out.println("d");
			} else {
				System.out.println("a");
			}
		}

	}

}
