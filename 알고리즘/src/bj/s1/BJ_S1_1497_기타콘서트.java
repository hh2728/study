package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1497_기타콘서트 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,M;
	static String[] play;
	static int MAX_MUSIC = Integer.MIN_VALUE, MIN_GUITAR = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		play = new String[N];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			play[n] = st.nextToken();
		}
		
		subSetByRecur2(N, 0, new int[M]);
		System.out.println(MAX_MUSIC==0?-1:MIN_GUITAR);
		
		
		
	}
	
	private static void subSetByRecur2(int toCheck, int guitar, int[] songs) {
		
		//base part
		if(toCheck ==0) {
			int musicCnt = 0;
			for(int i =0; i< songs.length; i++) {
				if(songs[i] > 0) {
					musicCnt++;
				}
			}
			if(musicCnt >= MAX_MUSIC && MIN_GUITAR > guitar) {
				MAX_MUSIC = musicCnt;
				MIN_GUITAR = guitar;
			}
			
			return;
		}
		
		//inductive part
		String yn = play[N - toCheck];
		for(int i =0; i<yn.length();i++) {
			if(yn.charAt(i)=='Y') {
				songs[i]++;
			}
		}
		subSetByRecur2(toCheck -1, guitar+1, songs);
		
		for(int i =0; i<yn.length();i++) {
			if(yn.charAt(i)=='Y') {
				songs[i]--;
			}
		}
		subSetByRecur2(toCheck-1, guitar, songs);
		
		
	}

}
