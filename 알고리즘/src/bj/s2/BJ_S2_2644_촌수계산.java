package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_2644_촌수계산 {
	
	static int N,t1,t2;
	static int[][] map;
	static int[] count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());		
		t1 = Integer.parseInt(st.nextToken());
		t2 = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		count = new int[N+1];
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		bfs(t1,t2);
		if(count[t2] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(count[t2]);
		}
	}
	static void bfs(int start, int end) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		
		while(!qu.isEmpty()) {
			int temp = qu.poll();
			
			if(temp == end) {
				break;
			}
			
			for(int i=1; i<=N; i++) {
				if(map[temp][i] == 1 && count[i] == 0) {
					count[i] = count[temp] + 1;
					qu.add(i);
				}
			}
					
		}
	}
	
}
