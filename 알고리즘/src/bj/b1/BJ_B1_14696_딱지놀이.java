package bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_B1_14696_딱지놀이 {

	static int N, a, b;
	static Integer[] arr, brr;
	static boolean isOk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			arr = new Integer[a];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());

			b = Integer.parseInt(st.nextToken());
			brr = new Integer[b];

			for (int j = 0; j < brr.length; j++) {
				brr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(brr, Collections.reverseOrder());

			isOk = false;
			int state = 2;
			int length = 0;
			if (a > b) {
				length = b;
				state = 1;
			} else if (a < b) {
				length = a;
				state = -1;
			} else if (a == b) {
				length = a;
				state = 0;
			}

			for (int i = 0; i < length; i++) {
				if (arr[i] == brr[i]) {

				} else if (arr[i] > brr[i]) {
					System.out.println("A");
					isOk = true;
					break;
				} else if (arr[i] < brr[i]) {
					System.out.println("B");
					isOk = true;
					break;
				}
			}

			if (!isOk && state == 0) {
				System.out.println("D");
			} else if (!isOk && state == 1) {
				System.out.println("A");
			} else if (!isOk && state == -1) {
				System.out.println("B");
			}

		}

	}

}
