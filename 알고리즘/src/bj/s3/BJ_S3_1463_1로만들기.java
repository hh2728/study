package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S3_1463_1로만들기 {

	static int N;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		count = Integer.MAX_VALUE;
		
		find(N,0);
		System.out.println(count);

	}

	static void find(int n, int cnt) {
		if (n == 1) {
			count = Math.min(cnt, count);
			return;
		}

		if (cnt >= count)
			return;

		if (n % 3 == 0) {
			find(n / 3, cnt + 1);
		}
		if (n % 2 == 0) {
			find(n / 2, cnt + 1);
		}
		find(n - 1, cnt + 1);
	}

}
