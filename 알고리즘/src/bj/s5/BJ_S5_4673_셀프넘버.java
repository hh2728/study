package bj.s5;

public class BJ_S5_4673_셀프넘버 {

	static boolean isNot[];

	public static void main(String[] args) {

		isNot = new boolean[10001];

		for (int i = 1; i < 10001; i++) {

			int n = self(i);

			if (n < 10001) {
				isNot[n] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (!isNot[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);

	}

	public static int self(int number) {

		int sum = number;

		while (number != 0) {

			sum = sum + (number % 10);

			number = number / 10;

		}
		return sum;

	}

}

