package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1967_트리의지름 {
	
	static List<Node> list[];
	static boolean visit[];
	static int answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
			list[to].add(new Node(from,weight));
			
		}
		
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			visit[i]= true;
			dfs(i,0);
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int num, int temp) {
		for(Node node : list[num]) {
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, temp + node.weight);
			}
		}
		
		answer = Math.max(answer, temp);
	}
	
	static class Node{
		int num, weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

}
