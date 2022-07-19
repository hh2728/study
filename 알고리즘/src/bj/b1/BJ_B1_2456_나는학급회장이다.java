package bj.b1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_B1_2456_나는학급회장이다 {

	static int N;
	static List<Student> st = new ArrayList(); //리스트로 생성
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 사람수
		st.add(new Student(1, 0, 0, 0, 0)); //student 3개 생성
		st.add(new Student(2, 0, 0, 0, 0));
		st.add(new Student(3, 0, 0, 0, 0));
		
		for(int n=0; n<N; n++) {

			int st1 = sc.nextInt();  //후보 1번 점수
			int st2 = sc.nextInt();  //2번 점수
			int st3 = sc.nextInt();  //3번 점수
			
			if(st1 == 1) {  		//1번 후보    1점일때
				st.get(0).score1++;  		//1점 자리에 입력
			} else if(st1 == 2) {  			//2점일때 
				st.get(0).score2++;   		//2점 자리에 입력
			} else {						//3점ㅁ일대
				st.get(0).score3++;			//3점자리에 입력
			}
			if(st2 == 1) {
				st.get(1).score1++;
			} else if(st2 == 2) {
				st.get(1).score2++;
			} else {
				st.get(1).score3++;
			}
			if(st3 == 1) {
				st.get(2).score1++;
			} else if(st3 == 2) {
				st.get(2).score2++;
			} else {
				st.get(2).score3++;
			}
			st.get(0).sum += st1; 		//각 총점 더하기
			st.get(1).sum += st2; 
			st.get(2).sum += st3;
		}
		

		Collections.sort(st);    //정렬

		

		
		boolean option = false;      
		if(st.get(0).sum == st.get(1).sum) {		// 다 같을 경우
			if(st.get(0).score3 == st.get(1).score3) {
				if(st.get(0).score2 == st.get(1).score2) {
					option = true;
				}
			}
		}
		
		if(option) {
			System.out.println(0 + " " + st.get(0).sum);
		}else {
			System.out.println(st.get(0).num + " " + st.get(0).sum);
		}
	}
	
	static class Student implements Comparable<Student>{
		int num;
		int score3;
		int score2;
		int score1;
		int sum;
		
		public Student(int num, int score3, int score2, int score1, int sum) {
			super();
			this.num = num;
			this.score3 = score3;
			this.score2 = score2;
			this.score1 = score1;
			this.sum = sum;
		}


		@Override
		public int compareTo(Student o) {
			if(this.sum == o.sum) {   //합계같으면?
				if(this.score3 == o.score3) {		//3점같으면?
					return Integer.compare(o.score2, this.score2);		//2점비교
				}
				return Integer.compare(o.score3, this.score3);		//3점비교
			}
			return Integer.compare(o.sum, this.sum);	//합계비교
		}
	}

}
