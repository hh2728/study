package bj.b2;

import java.util.Scanner;

public class BJ_B2_10988_팰린드롬인지확인하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		boolean ok = false;

		for (int i = 0; i <= st.length() / 2; i++) {
			if (st.charAt(i) - '0' == st.charAt(st.length() - 1 - i) - '0') {
				ok = true;
			} else {
				ok = false;
				break;
			}
		}

		if (ok) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}
