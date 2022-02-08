package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			
			LinkedList<Integer> list = new LinkedList<>();
			
			int N = Integer.parseInt(br.readLine());

			String s = br.readLine();
			st = new StringTokenizer(s, " ");


			for (int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int time = Integer.parseInt(br.readLine());
			String str = br.readLine();
			st = new StringTokenizer(str, " ");

			for (int i = 0; i < time; i++) {
				st.nextToken();
				int where = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for (int j = 0; j < count; j++) {
					list.add(where + j, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.printf("#%d ",t);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();
		}
	}

}
