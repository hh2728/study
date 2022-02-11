package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_2493_탑 {

	static int N;
	static int numbers[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= n) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}

				stack.pop();
				
			}
			
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}

			stack.push(new int[] { i, n });
		}

	}

}
