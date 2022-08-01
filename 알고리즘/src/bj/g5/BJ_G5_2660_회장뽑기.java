package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_2660_회장뽑기 {
	
	static int INF = 987654321;
	static int n,cnt,min, answer[];
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		
		// map 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					map[i][j] = INF;
			}
		}

		String str;		
		while (!(str = br.readLine()).equals("-1 -1")) {
			
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			map[a][b] = 1;
			map[b][a] = 1;

		}
		
		//플로이드 와샬
		// i 출발 , k 중간, j 도착
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		min = INF;
		answer = new int[n];		
		
		// map 돌면서 i회원의 점수를 찾아서 status에 저장, 제일 작은 점수를 min에 저장.
		for (int i = 0; i < n; i++) {
			int status = 0;
			
			for (int j = 0; j < n; j++) {
				status = Math.max(status, map[i][j]);
			}
			
			answer[i] = status;
			min = Math.min(min, status);
		}

		cnt = 0;		
		StringBuilder sb = new StringBuilder();
		
		//제일 작은 점수랑 같은 애들 다 찾기
		for (int i = 0; i < n; i++) {
			if (answer[i] == min) {
				cnt++;
				sb.append((i + 1) + " ");
			}
		}

		System.out.println(min + " " + cnt);
		System.out.println(sb.toString());

	}
}
