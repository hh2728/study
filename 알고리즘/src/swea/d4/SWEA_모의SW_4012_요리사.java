package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_모의SW_4012_요리사 {
	
	static boolean[] choice;
	static int[][] map;
	static int n,answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			n = N;
			choice = new boolean[N+1];
			answer = Integer.MAX_VALUE;
			map = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(1,0);
			System.out.println("#"+t+" "+answer);
		}		
		
	}
	
	static void dfs(int depth, int count) {
		if(depth == n+1) {
			if((n) /2 == count) {
				solution();
			}
				//System.out.println(Arrays.toString(choice));
			return;
		}
		
		choice[depth] = true;
		dfs(depth + 1, count+1);
		choice[depth] = false;
		dfs(depth + 1, count);
	}
	
	static void solution() {
		ArrayList<Integer> alist = new ArrayList<>();
		ArrayList<Integer> blist = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			if(choice[i] == true) {
				alist.add(i);
			}else {
				blist.add(i);
			}
		}
		
		int point = 0;
		int ap = 0;
		int bp = 0;
		
		for(int i=0; i<alist.size(); i++) {
			for(int j=0; j<alist.size(); j++) {
				if(i != j) {
					ap += map[alist.get(i)][alist.get(j)];
				}
			}
		}
		
		for(int i=0; i<blist.size(); i++) {
			for(int j=0; j<blist.size(); j++) {
				if(i != j) {
					bp += map[blist.get(i)][blist.get(j)];
				}
			}
		}
		
		point = Math.abs(ap - bp);
		
		answer = Math.min(answer, point);
	}

}
