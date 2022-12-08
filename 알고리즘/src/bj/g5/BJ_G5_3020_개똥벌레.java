package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_3020_개똥벌레 {
	
	static int N,H;
	static int[] bottom, top;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		bottom = new int[H+2];
		top = new int[H+2];
		
		for(int i=0; i<N/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[H-Integer.parseInt(br.readLine()) +1]++;
		}
		
		for(int i=1; i<=H; i++) {
			bottom[i] += bottom[i-1];
		}
		
		for(int i=H; i>=1; i--) {
			top[i] += top[i+1];
		}
		
		int min = N;
		int count = 0;
		
		for(int i=1; i<=H; i++) {
			int temp = (bottom[H] - bottom[i-1]) + (top[1] - top[i+1]);
			
			if(temp < min) {
				min = temp;
				count = 1;
			}else if(temp == min) {
				count++;
			}
		}
		System.out.println(min+" "+count);
	}

}
