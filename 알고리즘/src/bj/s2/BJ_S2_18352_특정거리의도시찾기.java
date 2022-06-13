package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_S2_18352_특정거리의도시찾기 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int n, m, k, x;
	static int[] d = new int[300001]; // 최단거리 저장 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		// 연결리스트에 노드 추가
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1; // 최단거리 -1로 초기화
		}

		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
		}


		d[x] = 0;	//시작점 초기화

		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while (!q.isEmpty()) {
			
			int now = q.poll();

			for (int i = 0; i < graph.get(now).size(); i++) {
				int next = graph.get(now).get(i);
				if (d[next] == -1) {	//방문한적 없으면.이전 최단거리에 +1한 값 저장
					d[next] = d[now] + 1;
					q.offer(next);
				}
			}
		}

		// 최단거리가 k인 노드 찾기
		boolean check = false;
		
		for (int i = 1; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}

		// 최단거리가 k인 노드가 없다면 -1 출력
		if (check == false)
			System.out.println(-1);
	}
}
