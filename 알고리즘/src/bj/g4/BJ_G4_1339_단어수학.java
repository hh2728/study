package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_G4_1339_단어수학 {
	
	static int N, alpha[];
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		alpha = new int[26];
		
		//입력받기
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		
		
		for(int i=0; i<N; i++) {
			//자리수 배열에 더해주기
			int temp = (int)Math.pow(10, arr[i].length()-1);
			
			for(int j=0; j<arr[i].length(); j++) {
				// 자리에 있는 알파벳에 넣어주기
				alpha[(int)arr[i].charAt(j)-65] += temp;
				//다음자리 수로 가자
				temp /= 10;
			}
		}
		
		//큰 수로 정렬
		Arrays.sort(alpha);
		int number = 9;
		int sum=0;
		
		for(int i= alpha.length-1; i>=0; i--) {
			if(alpha[i] == 0)break;
			
			//제일 큰수부터 9~1 곱해서 숫자 만들기
			sum += alpha[i] * number;
			number--;
		}
		
		System.out.println(sum);

	}

}
