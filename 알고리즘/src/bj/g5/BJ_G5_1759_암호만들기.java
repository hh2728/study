package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1759_암호만들기 {

	static int L, C;
	static String[] str, choose;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		str = new String[C];
		choose = new String[L];
		check = new boolean[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < str.length; i++) {

			str[i] = st.nextToken();
		}

		Arrays.sort(str);
		dfs(str, "", L, 0);
	}

	public static void dfs(String[] arr, String password, int n, int index) {

		if (password.length() == n) {
			if (check(password)) {
				System.out.println(password);
			}
			return;
		}

		if (index >= arr.length)
			return;

		dfs(arr, password + arr[index], n, index + 1);
		dfs(arr, password, n, index + 1);
	}

	

	public static boolean check(String password) {
		int mo = 0;
		int ja = 0;

		for (char ch : password.toCharArray()) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				mo++;
			} else {
				ja++;
			}
		}

		return mo >= 1 && ja >= 2;

	}

}
