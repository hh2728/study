package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1963_소수경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//에라토스테네스의 체
		boolean[] prime = new boolean[10000];
		prime[0] = prime[1] = true;
		for(int i=2; i<10000; i++) {
			if(!prime[i]) {
				for(int j = i+ i; j<10000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		while( t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Queue<Integer> qu = new LinkedList<>();
			boolean[] visited = new boolean[10000]; // 방문체크
			int[] count = new int[10000]; // 최소 저장	
			
			qu.add(a);
			visited[a] = true;
			
			while(!qu.isEmpty()) {
				int num = qu.poll();
				for(int i=0; i<4; i++) {
					for(int j=0; j<=9; j++) {
						if(i ==0 && j == 0) {
							continue;
						}
						int k = change(num , i, j);
						if(!prime[k] && !visited[k]) {
							qu.add(k);
							visited[k] = true;
							count[k] = count[num] + 1;
						}
					}
				}
			}
			System.out.println(count[b]);
		}

	}
	public static int change(int num, int i, int j) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.setCharAt(i, (char)(j + '0')); // string으로 해서 인덱스 사용(위치), 숫자 바꾸기
		return Integer.parseInt(sb.toString()); // 다시 인트로
	}

}
