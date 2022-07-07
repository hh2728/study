package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_B2_17608_막대기 {

	public static void main(String[] args) throws IOException {

		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);

		int h = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			h = Integer.parseInt(str);
			stack.push(h);
		}

		int standard = stack.pop();
		int cnt = 1;
		int current = 0;
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (current > standard) {
				standard = current;
				cnt++;
			}
		}

		System.out.print(cnt);

	}

}
