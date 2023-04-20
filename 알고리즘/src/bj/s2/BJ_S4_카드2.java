package bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_S4_카드2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> qu = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			qu.add(i);
		}
		
		while(qu.size() > 1) {
			qu.poll();
			
			int num = qu.poll();
			
			qu.add(num);
		}
		
		System.out.println(qu.peek());
	}

}
