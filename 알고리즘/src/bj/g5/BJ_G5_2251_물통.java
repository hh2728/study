package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G5_2251_물통 {
	
	static int[] input;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[3];
		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		input[2] = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		boolean[][][] visit = new boolean[input[0]+1][input[1]+1][input[2]+1];
		visit[0][0][input[2]] = true;
		set.add(input[2]);
		q.add(new int[] {0,0,input[2]});
		System.out.println(Arrays.toString(input));
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == 0) {
				set.add(now[2]);
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == j) {
						continue;
					}
					int[] next = solve(now, i, j);
					if(!visit[next[0]][next[1]][next[2]]) {
						visit[next[0]][next[1]][next[2]] = true;
						q.add(next);
					}
				}
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>(set);
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for( Integer i : ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		
	}
	
	static int[] solve(int[] now, int i, int j) {
		if(now[i] == 0 || now[j] == input[j]) {
			return now;
		}
		
		int[] next = now.clone();
		
		int temp = input[j] - next[j];
		if(next[i] > temp) {
			next[j] += temp;
			next[i] -= temp;
		} else {
			next[j] += next[i];
			next[i] = 0;
		}
		
		return next;
	}

}
