package bj.s5;

public class BJ_S5_4673_셀프넘버 {

	static boolean isNot[];

	public static void main(String[] args) {

		isNot = new boolean[10001];    			//확인을 위한 배열

		for (int i = 1; i < 10001; i++) {		// 1부터 10000까지 확인하기

			int n = self(i);

			if (n < 10001) {					// 셀프넘버가 아닌것들만 true로 바꾸기
				isNot[n] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {		// 셀프넘버인것만 StringBuilder에 넣기
			if (!isNot[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);

	}

	public static int self(int number) {

		int sum = number;

		while (number != 0) {					//넘버가 0이 아니면 계속 하기

			sum = sum + (number % 10);			// 10으로 나누어 1의 자리수 더하기

			number = number / 10;				// 그다음을 위해  10으로 나눈다.

		}
		return sum;

	}

}

