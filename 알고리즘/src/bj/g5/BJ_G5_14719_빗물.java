package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G5_14719_빗물 {

	static int H, W;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		height = new int[W];
	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		
		for (int i = 1; i < W - 1; i++) { // 인덱스 별로  모이는 빗물 계산하기. 맨 왼쪽,맨 오른쪽 빼고 구해보자
			
			int left = 0;	//초기화
			int right = 0;

			for (int j = 0; j < i; j++) {
				left = Math.max(height[j], left);	// 왼쪽 높은 기둥
			}

			for (int j = i + 1; j < W; j++) {
				right = Math.max(height[j], right);	//오른쪽 높은기둥
			}

			if (height[i] < left && height[i] < right)	// 기둥들 보다 높이가 낮은가?
				result += Math.min(left, right) - height[i];	// 낮다면 기둥중에 낮은거 많큼 채울 수 있다.
		}
		System.out.println(result);
	}
}
