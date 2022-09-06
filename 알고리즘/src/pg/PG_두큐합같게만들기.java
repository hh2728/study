package pg;

import java.util.ArrayDeque;
import java.util.Queue;

public class PG_두큐합같게만들기 {
	
	static int[] queue1 = {3,2,7,2};
	static int[] queue2 = {4,6,5,1};
	
	public static int main(String[] args) {
		Queue<Integer> qu1 = new ArrayDeque<>();
		Queue<Integer> qu2 = new ArrayDeque<>();
		
		// 합계산을 위한 변수
		long s1=0;
		long s2=0;
		long sum;
		
		for(int n : queue1) {
			qu1.add(n);
			s1 += n;
		}
		
		for(int n : queue2) {
			qu2.add(n);
			s2 += n;
		}
		
		sum = s1 + s2;
		
		// 홀수면 못나눈다.
		if(sum%2 != 0) {
			return -1;
		}
		
		//타겟 넘버
		sum /= 2;
		
		//이동횟수 카운트
		int p1 =0;
		int p2 =0;
		int limit = queue1.length*2;
		
		// 최대로 했는데 안되면 나갈수있게 하기
		while(p1 <= limit && p2 <= limit) {
			
			//목표 달성 
			if(s1 == sum) {
				return p1+p2;
			}
			
			//1번 큐가 더 크면 1번큐에서 2번큐로 이동
			if(s1 > sum) {
				s1 -= qu1.peek();
				s2 += qu1.peek();
				qu2.add(qu1.poll());
				p1++;
			}else {	//반대로
				s2 -= qu2.peek();
				s1 += qu2.peek();
				qu1.add(qu2.poll());
				p2++;
			}
		}
		
		return -1;
		
	}
}
