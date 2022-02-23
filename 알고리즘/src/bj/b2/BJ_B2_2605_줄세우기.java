package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_B2_2605_줄세우기 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> arr = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		arr.add(0);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(i - num, i);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(arr.get(i) + " ");
		}

	}

}
