package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayDeque<Integer> deque;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "[],");

			deque = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			solution(command, deque);
		}

		System.out.println(sb);

	}

	public static void solution(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true;

		for (char cmd : command.toCharArray()) {

			if (cmd == 'R') {
				isRight = !isRight;
				continue;
			}

			if (isRight) {
				if (deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if (deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}

		Answer(deque, isRight);
	}

	public static void Answer(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');

		if (deque.size() > 0) {
			if (isRight) {
				sb.append(deque.pollFirst());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');
	}

}
