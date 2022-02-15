package jo.ic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_IC_1828_냉장고 {

	static int N, num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		refrigerator[] refri = new refrigerator[N];
		num = N;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			refri[i] = new refrigerator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(refri);

		int maxTemp = refri[0].max;
		for (int i = 1; i < N; i++) {
			if (maxTemp >= refri[i].min) {
				num--;
			} else {
				maxTemp = refri[i].max;
			}
		}

		System.out.println(num);
	}

	private static class refrigerator implements Comparable<refrigerator> {
		int min;
		int max;

		public refrigerator(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(refrigerator o) {
			int gap = this.max - o.max;
			return gap != 0 ? gap : this.min - o.min;
		}

	}

}
