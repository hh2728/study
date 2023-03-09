package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Classe[] classes = new Classe[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			classes[i] = new Classe(start, end);
		}

		Arrays.sort(classes);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(classes[0].end);

		for (int r = 1; r < N; r++) {
			if (pq.peek() <= classes[r].start) {
				pq.poll();
			}

			pq.offer(classes[r].end);
		}
		
		System.out.println(pq.size());

	}
}

class Classe implements Comparable<Classe> {
	int start, end;

	Classe(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Classe o) {
		if (this.start == o.start) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}
}
