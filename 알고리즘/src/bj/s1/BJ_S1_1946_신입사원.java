package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S1_1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Grade> list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Grade(a,b));
			}
			
			Collections.sort(list);
			
			int ans = 1;
			int min = list.get(0).b;
			for(int i = 1; i< N; i++) {
				if(list.get(i).b < min) {
					ans++;
					min = list.get(i).b;
				}
			}
			
			System.out.println(ans);
			
		}

	}
	
	
	
	static class Grade implements Comparable<Grade>{
		int a;
		int b;
		
		Grade(int a, int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Grade o) {
			if(this.a > o.a) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}
