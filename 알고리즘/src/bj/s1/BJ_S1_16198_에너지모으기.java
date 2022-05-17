package bj.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_16198_에너지모으기 {
	
	static List<Integer> balls = new ArrayList<Integer>();
	static int power;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		power=0;
		for(int i=0; i< N; i++) {
			balls.add(Integer.parseInt(st.nextToken()));
		}
		dfs(N, balls, 0);
		System.out.println(power);
	}
	
	private static void dfs(int n, List<Integer> balls, int sum) {
		if(n == 2) { // 첫번째와 마지막 구슬만 남았을 때
			power = Math.max(sum, power); 
			return;
		}
		
		for(int i=1; i< balls.size() -1; i++) { // 첫번째와 마지막 구슬은 제외
			int s = balls.get(i-1) * balls.get(i+1); // 양쪽 구슬을 곱한 값
			int temp = balls.get(i); 
			balls.remove(i); // 가운데 구술 빼기
			dfs(n-1, balls, sum+s); // 재귀 호출 dfs(구슬 개수 -1, i구슬 제외된 배열, s를 더한 sum값)
			balls.add(i, temp); // 뺏던 구술 제자리로
		}
	}

}
