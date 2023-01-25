package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_2170_선긋기 {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<line> pq = new PriorityQueue<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		
		
		int sum = 0;
        int bfX = pq.peek().x;
        int bfY = pq.peek().y;
      
        pq.poll();
        
        while (!pq.isEmpty()) {
            line cur = pq.poll();
            if (cur.x > bfY) {
                sum += bfY-bfX;
                bfX = cur.x;
                bfY = cur.y;
                continue;
            }
            bfY = Math.max(bfY, cur.y);
        }
        
        //마지막에 나뉜거 까지 더하기
        System.out.println(sum+bfY-bfX);
        

	}
	
	public static class line implements Comparable<line>{
		int x,y;
		
		public line(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(line o) {
			if(this.x == o.x) return o.y - this.y;
			return this.x - o.x;
		}
	}

}
