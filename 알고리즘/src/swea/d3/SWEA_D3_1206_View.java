package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1206_View {

	static int N;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(num[i - 2], Math.max(num[i - 1], Math.max(num[i + 1], num[i + 2])));
				if (num[i] - max > 0)
					cnt += num[i] - max;
			}
			
			System.out.printf("#%d %d\n",t,cnt);
		}

	}

}
