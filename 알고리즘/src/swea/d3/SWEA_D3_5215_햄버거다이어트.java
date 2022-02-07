package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_5215_햄버거다이어트 {
	
	static int T;
	static int N,limit;
	static int best=0;
	static int score[],calorie[];
	static boolean isSelected[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			calorie = new int[N];
			isSelected = new boolean[N];
			best=0;
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				score[n] = Integer.parseInt(st.nextToken());
				calorie[n] =Integer.parseInt(st.nextToken());
			}
			
			bestBurger(0);
			
			System.out.printf("#%d %d\n",t,best);
		}
		
		
		
	}
	
public static void bestBurger(int cnt) {
		
		
		if(cnt==N) { 
			int sum =0;
			int sco=0;
			
			for(int i =0; i< N; i++) {
				if(isSelected[i]) {
					sum += calorie[i];
					sco += score[i];
				}
			}
			
			if(sum<limit && sco>best) best = sco;
			
			return ;
		}
		
		
		
		
		isSelected[cnt] = true;
		bestBurger(cnt+1);
		
		isSelected[cnt] = false;
		bestBurger(cnt+1);
	}

}



/*
package swea.d3;

import java.util.Scanner;

public class SWEA_D3_5215_햄버거다이어트 {
	
	static int T;
	static int N,limit;
	static int best=0;
	static int score[],calorie[];
	static boolean isSelected[];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			N=sc.nextInt();
			limit=sc.nextInt();
			
			score = new int[N];
			calorie = new int[N];
			isSelected = new boolean[N];
			best=0;
			
			for(int n=0; n<N; n++) {
				score[n]  = sc.nextInt();
				calorie[n] = sc.nextInt();
			}
			
			bestBurger(0);
			
			System.out.printf("#%d %d\n",t,best);
		}
		

	}
	
	public static void bestBurger(int cnt) {
		
		
		if(cnt==N) { //마지막 원소까지 부분집합에 다 고려된 상황
			int sum =0;
			int sco=0;
			
			for(int i =0; i< N; i++) {
				if(isSelected[i]) {
					sum += calorie[i];
					sco += score[i];
				}
			}
			
			if(sum<limit && sco>best) best = sco;
			
			return ;
		}
		
		//현재 원소를 선택
		isSelected[cnt] = true;
		bestBurger(cnt+1);
		//현재 원소를 비선택
		isSelected[cnt] = false;
		bestBurger(cnt+1);
	}

}
*/
