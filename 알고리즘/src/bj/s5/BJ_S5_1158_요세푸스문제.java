package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S5_1158_요세푸스문제 {

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Queue<Integer> queue = new LinkedList();
		Queue<Integer> queue2 = new LinkedList();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		for (int i = 1;; i++) {
			if (i == K) {
				queue2.add(queue.peek());
				queue.poll();
				i = 0;
			} else {
				queue.add(queue.peek());
				queue.poll();

			}

			if (queue.isEmpty())
				break;
		}

		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if (i < N - 1)
				System.out.printf("%d, ", queue2.poll());
			else
				System.out.printf("%d>", queue2.poll());
		}

	}

}
