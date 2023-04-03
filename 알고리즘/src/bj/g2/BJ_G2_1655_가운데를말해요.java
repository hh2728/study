package bj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_G2_1655_가운데를말해요 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> qu1 = new PriorityQueue<>((o1,o2) -> o1-o2);
		//작은수부터
		
		PriorityQueue<Integer> qu2 = new PriorityQueue<>((o1,o2) -> o2-o1);		
		//큰수부터
		
		for(int i=1; i<=N; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			if(qu1.size() == qu2.size()) qu2.add(temp);
			else qu1.add(temp);
			
			if(!qu1.isEmpty() && !qu2.isEmpty()) {
				if(qu1.peek() < qu2.peek()) {
					int num = qu1.poll();
					qu1.add(qu2.poll());
					qu2.add(num);
				}
			}
			
			sb.append(qu2.peek()+"\n");
			//System.out.println(qu1);
			//System.out.println(qu2);
		}
		System.out.println(sb);
	}
	
}
