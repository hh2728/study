package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_G4_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		String bomb = br.readLine();

		String answer = solution(target, bomb);
		
		System.out.println((answer.length() == 0) ? "FRULA" : answer);
	}

	private static String solution(String str, String bomb) {
		
		Stack<Character> stack = new Stack<>();
		
		int blen = bomb.length();

		for (int i = 0; i < str.length(); i++) {
			
			stack.push(str.charAt(i));

			if (stack.size() >= blen) {
				boolean flag = true;
				for (int j = 0; j < blen; j++) {
					if (stack.get(stack.size() - blen + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < blen; j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}
		return sb.toString();

	}

}

/*
 * public class BJ_G4_9935_문자열폭발 {
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in));
 * 
 * String target = br.readLine(); String str = br.readLine();
 * 
 * while (true) {
 * 
 * if(target.length() ==0) { System.out.println("FRULA"); break; }
 * 
 * String ntarget = ""; String base = target;
 * 
 * for (int i = 0; i < target.length() - str.length() + 1; i++) {
 * 
 * int fit = 0;
 * 
 * for (int j = 0; j < str.length(); j++) { if (target.charAt(i + j) ==
 * str.charAt(j)) { fit += 1; }
 * 
 * 
 * }
 * 
 * if (fit == str.length()) { for (int j = 0; j < i; j++) { ntarget +=
 * target.charAt(j); }
 * 
 * for (int j = i + str.length(); j < target.length(); j++) { ntarget +=
 * target.charAt(j);
 * 
 * }
 * 
 * target = ntarget; break;
 * 
 * }
 * 
 * }
 * 
 * if(base.equals(target)) { System.out.println(target); break; }
 * 
 * }
 * 
 * }
 * 
 * }
 */
