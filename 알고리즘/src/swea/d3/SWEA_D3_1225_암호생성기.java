package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> qu = new LinkedList<Integer>();
		
		while(true) {
			String s = br.readLine();
			if(s==null)break;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<8; i++) qu.add(Integer.parseInt(st.nextToken()));
			
			outer : while(true) {
				for(int i=1; i<=5; i++) {
					int n =0;
					n = qu.poll();
					n = n-i;
					if(n<=0) {
						qu.add(0);
						break outer ;
					}
					qu.add(n);
					
					
				}
			}
			
			System.out.printf("#%s ",s);
			for(int i=0; i<8; i++)
				System.out.print(qu.poll()+" ");
			System.out.println();
		}
	}

}
