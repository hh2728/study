package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_13335_트럭 {

	static int n, L, W, time, weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		time = 0;
		weight = 0;

		// 다리를 의미하는 큐
		Queue<Integer> bridge = new LinkedList<Integer>();

		// 다리에 다 0으로 초기화시켜놓기
		for (int i = 0; i < W; i++) {
			bridge.add(0);
		}

		// 다리에서 값 다 나올때까지
		while (!bridge.isEmpty()) {

			time++;
			// 다리를 지나갔다
			weight -= bridge.poll();

			if (!truck.isEmpty()) {
				// 건너려는 트럭과 다리위에 있는 트럭 값을 더해서 제한보다 작은가?
				if (truck.peek() + weight <= L) {
					// 가능하면 다리위 무게에 더하기
					weight += truck.peek();
					// 트럭이 다리위로 올라갔다
					bridge.add(truck.poll());
				} else {
					// 트럭못가면 이번엔 0을 넣기
					bridge.add(0);
				}
			}
		}

		System.out.println(time);
	}

}
