package bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class BJ_S5_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] list = new String[N];
		
		for(int i=0; i<N; i++) {
			list[i] = br.readLine();
		}
		
		Arrays.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {			//글자수 비교
					return o1.compareTo(o2);			//같으면 비교 -> 양수가 나오면 바꾸고 음수면 안바꿈  (기본)
				}
				else {
					return o1.length()-o2.length();		//글자수 비교
				}
			}
		});
		
		System.out.println(list[0]);					//미리 첫번째 출력
		for(int i =1; i<N; i++) {
			if(!list[i].equals(list[i-1]))				//앞에 문자와 비교해서 중복이면 출력 X
					System.out.println(list[i]+" ");
		}
		
	}
	

}
