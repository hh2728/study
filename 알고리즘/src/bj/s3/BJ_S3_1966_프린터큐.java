package bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_S3_1966_프린터큐 {

	static int T, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
			
			//입력끝
			
			
			int cnt = 0;
			
			while (!queue.isEmpty()) {

				//맨앞에꺼 빼서 비교, 큰거 맞나 체크할수 있게
				int[] num = queue.poll();
				boolean isMax = true;
				
				//큐 크기만큼 돌면서 비교하기
				for (int i = 0; i < queue.size(); i++) {
					
					//중요도 높은게 뒤에 있다면? 다시 맨뒤로 넣기
					if (num[1] < queue.get(i)[1]) {
						queue.offer(num);
						
						//i가 제일 중요하니까 앞에는 다 뒤로 넘겨~
						for (int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}
						
						// 제일중요하지 않아.
						isMax = false;
						break;
					}
				}
				
				//중요하지않으니까 첨부터 다시해
				if (isMax == false) {
					continue;
				}
				
				//하나 뺏으니까 카운트 올려.
				cnt++;
				
				// M번째가 맞으면 나가
				if(num[0] == M) {
					break;
				}

			}
			System.out.println(cnt);
		}
	}

}
