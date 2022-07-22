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

		// 다 폭발하면 FRULA, 아니면 답
		System.out.println((answer.length() == 0) ? "FRULA" : answer);
	}

	private static String solution(String str, String bomb) {

		Stack<Character> stack = new Stack<>();
		// 폭탄 길이 설정
		int blen = bomb.length();

		// 문자열 길이 만큼 돌리기
		for (int i = 0; i < str.length(); i++) {
			// 스택에 넣기
			stack.push(str.charAt(i));
			// 넣고있는 스택사이즈가 폭탄보다 길어지면 확인해보자
			if (stack.size() >= blen) {
				boolean flag = true;
				// 폭탄 길이만큼 반복하면서 확인해보기,
				for (int j = 0; j < blen; j++) {
					if (stack.get(stack.size() - blen + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				// 같으면 폭탄만큼 문자열 스택에서 꺼내기
				if (flag) {
					for (int j = 0; j < blen; j++) {
						stack.pop();
					}
				}
			}
		}
		// 남은 스택 반환
		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}
		return sb.toString();

	}

}
/*
public class BJ_G4_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		String str = br.readLine();

		while (true) {

			if (target.length() == 0) {
				System.out.println("FRULA");
				break;
			}

			String ntarget = "";
			
			//변환 없는거 확인하기 위해서 시작할때 저장해두기.
			String base = target;

			//문자열 - 폭탄열 만큼 돌려봐라 
			for (int i = 0; i < target.length() - str.length() + 1; i++) {
				// 몇개가 맞나 확인을 위해
				int fit = 0;
				//같으면 플러스
				for (int j = 0; j < str.length(); j++) {
					if (target.charAt(i + j) == str.charAt(j)) {
						fit += 1;
					}

				}
				// 폭탄만큼 같으면 처리
				if (fit == str.length()) {
					// 폭탄과 같은 문자열 부분 빼고 새로운 타겟 만들어주기
					for (int j = 0; j < i; j++) {
						ntarget += target.charAt(j);
					}

					for (int j = i + str.length(); j < target.length(); j++) {
						ntarget += target.charAt(j);

					}
					
					target = ntarget;
					break;

				}

			}
			// 처음이랑, 처리후에 변화없으면 끝이다
			if (base.equals(target)) {
				System.out.println(target);
				break;
			}

		}

	}

}
*/