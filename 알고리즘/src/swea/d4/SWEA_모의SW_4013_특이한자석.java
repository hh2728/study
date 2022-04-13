package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_모의SW_4013_특이한자석 {

	static int T, K;
	static int[][] magnet;
	static boolean[] spined;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());

			magnet = new int[5][9];
			for (int r = 1; r < 5; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 8; c++) {
					magnet[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				spined = new boolean[5];
				spin(a, b);
			}

			int sum=0;
			for(int i=1; i<5; i++) {
				sum += magnet[i][0] * (int)Math.pow(2, i-1);
				
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	//왼쪽 자석을 기준으로 오른쪽 자석 회전시키기
	public static void spinform(int l, int r) {
		if (magnet[l][2] != magnet[r][6] && magnet[l][8] == 1) {
			spined[r] = true;
			magnet[r][8] = -1;
		} else if (magnet[l][2] != magnet[r][6] && magnet[l][8] == -1) {
			spined[r] = true;
			magnet[r][8] = 1;
		}
	}
	//오른쪽자석 기준으로 왼쪽자석 회전시키기
	public static void spinform2(int l, int r) {
		if (magnet[l][2] != magnet[r][6] && magnet[r][8] == -1) {
			spined[l] = true;
			magnet[l][8] = 1;
		} else if (magnet[l][2] != magnet[r][6] && magnet[r][8] == 1) {
			spined[l] = true;
			magnet[l][8] = -1;
		}
	}

	public static void spin(int target, int dir) {
		spined[target] = true;
		magnet[target][8] = dir;
		
		if (target == 1) {
			
			spinform(1,2);

			if (spined[2] == true) {
				spinform(2,3);
			}

			if (spined[3] == true) {
				spinform(3,4);
			}
		}

		if (target == 2) {

			spinform2(1,2);

			spinform(2,3);

			if (spined[3] == true) {
				spinform(3,4);
			}
		}

		if (target == 3) {
		
			spinform2(2,3);

			spinform(3,4);

			if (spined[2] == true) {
				spinform2(1,2);
			}
		}
		
		if (target == 4) {
			spinform2(3,4);

			if (spined[3] == true) {
				spinform2(2,3);
			}

			if (spined[2] == true) {
				spinform2(1,2);
			}
		}

		// 회전
		for (int i = 1; i < 5; i++) {

			if (magnet[i][8] == 1) {
				int temp = magnet[i][7];
				for (int j = 7; j > 0; j--) {
					magnet[i][j] = magnet[i][j - 1];
				}
				magnet[i][0] = temp;
			} else if (magnet[i][8] == -1) {
				int temp = magnet[i][0];

				for (int j = 0; j < 7; j++) {
					magnet[i][j] = magnet[i][j + 1];
				}
				magnet[i][7] = temp;
			}
			magnet[i][8] = 0;

		}
	}

}
