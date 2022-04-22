package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {

	static int y1, x1, y2, x2;
	static int y3, y4, x3, x4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 0; t < 4; t++) {

			st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());

			if ((x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x1 == x4 && y1 == y4)) {
				System.out.println("c");
			} else if ((x2 == x3 && y2 != y3) || (x1 == x4 && y2 != y3) || (x2 != x3 && y1 == y4)
					|| (x1 != x4 && y1 == y4)) {
				System.out.println("b");
			} else if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
				System.out.println("d");
			} else {
				System.out.println("a");
			}
		}

	}

}
