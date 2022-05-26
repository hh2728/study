package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_G4_1715_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> qu = new PriorityQueue<Long>();

		for (int i = 0; i < N; i++) {
			qu.add(Long.parseLong(br.readLine()));
		}

		long num = 0;

		//10, 20 ,40
		//(10+20) + (30+40) = 100
		//(10+40) + (50+20) = 120
		while (qu.size() > 1) {
			long temp1 = qu.poll();
			long temp2 = qu.poll();

			num += temp1 + temp2;
			qu.add(temp1 + temp2);
		}

		System.out.println(num);

	}
}
