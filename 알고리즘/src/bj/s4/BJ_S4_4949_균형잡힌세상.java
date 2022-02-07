package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		String s;
		
		while(true) {
			
			s = br.readLine();
			if(s.equals(".")) break;	//. 입력받으면 while문 아웃
			
			sb.append(solution(s)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static String solution (String s) {
		Stack<Character> stack = new Stack<>();	
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[') {			//여는 괄호 스택에 넣기
				stack.push(c);
			} 
			else if (c == ')') {				//닫는괄호가 들어왔을때
				if (stack.empty() || stack.peek() != '(') {		//스택이 비어있거나 이전 스택에 '(' 가 없을때
					return "no";								// no
				} else {
					stack.pop();								//그렇지 않으면 ( ) 맞으니까  ( pop
				}
			} 
			else if (c == ']') {
				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}

			}
		}
			
		if(stack.empty()) {									// 모든 처리를 했는데  스택이 비어있으면 완벽  yes  남아있으면 no
			return "yes";
		}else {
			return "no";
		}
		
		
	}

}
