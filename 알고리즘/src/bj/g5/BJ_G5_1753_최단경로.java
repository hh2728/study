package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class BJ_G5_1753_최단경로 {
	
	static int v,e,k;
	static boolean visited[];
	static int[] dist;
	static ArrayList<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		
		dist = new int[v+1];
		list = new ArrayList[v+1];
		visited = new boolean[v+1];
		
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[k] = 0;
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,w));
		}
		dijkstra();
		for( int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
		
		
		
		
		
	}
	public static void dijkstra(){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(k,0));
		while(!pq.isEmpty()) {
			Node a = pq.poll();
			if(visited[a.idx]) {
				continue;
			}
			visited[a.idx] = true;
			for(Node o : list[a.idx]) {
				if(dist[o.idx] > dist[a.idx] + o.w) {
					dist[o.idx] = dist[a.idx] + o.w;
					pq.add(new Node(o.idx,dist[o.idx]));
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int idx,w;
		Node(int idx, int w){
			this.idx = idx;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
		
	}

}
