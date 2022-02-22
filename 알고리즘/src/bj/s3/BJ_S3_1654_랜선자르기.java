package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1654_랜선자르기 {

	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		long high = arr[K - 1];
		long low = 1;
		long mid = 0;

		while (low <= high) {
			long count = 0;

			mid = (low + high) / 2;

			for (int i = 0; i < arr.length; i++) {
				count += arr[i] / mid;
			}

			if (count >= N)
				low = mid + 1;
			else if (count < N)
				high = mid - 1;
		}
		System.out.println(high);

	}

}
