package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_S4_9012_괄호 {

	static int T;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			sb.append(solution(br.readLine())).append('\n');

		}
		System.out.println(sb);
	}

	public static String solution(String s) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				st.push(c);
			} 
			
			else if (st.isEmpty()) {
				return "NO";
			} 
			
			else {
				st.pop();
			}
		}

		if (st.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
