package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_10282_해킹 {

	static int T, n, d, c;
	static int[] dist;
	static List<Computer>[] cList;
	static int count, time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dist = new int[n + 1];
			cList = new ArrayList[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);

			for (int i = 0; i <= n; i++) {
				cList[i] = new ArrayList<>();
			}

			for (int w = 0; w < d; w++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				cList[b].add(new Computer(a, s));
			}
			dist[c] = 0;
			dijkstra();
			count = 0;
			time = 0;
			
			for (int i = 1; i <= n; i++) {
				if (dist[i] != Integer.MAX_VALUE) {
					count++;
					time = Math.max(time, dist[i]);
				}
			}
			System.out.println(count + " " + time);
		}

	}

	static void dijkstra() {
		PriorityQueue<Computer> qu = new PriorityQueue<>();
		qu.add(new Computer(c, 0));

		while (!qu.isEmpty()) {
			Computer temp = qu.poll();
			int number = temp.number;
			int cost = temp.cost;
			if (dist[number] < cost) {
				continue;
			}
			for (int i = 0; i < cList[number].size(); i++) {
				int number2 = cList[number].get(i).number;
				int cost2 = cList[number].get(i).cost + cost;
				if (dist[number2] > cost2) {
					dist[number2] = cost2;
					qu.add(new Computer(number2, cost2));
				}
			}
		}
	}

	static class Computer implements Comparable<Computer> {
		int number;
		int cost;

		public Computer(int number, int cost) {
			super();
			this.number = number;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return cost - o.cost;
		}

	}

}
