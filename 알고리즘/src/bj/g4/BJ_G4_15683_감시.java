package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_G4_15683_감시 {

	 /*
    1번 - 상,하,좌,우 - 4개
    2번 - 상하, 좌우 - 2개
    3번 - 상우, 우하, 하좌, 좌상 - 4개
    4번 - 좌상우, 상우하, 우하좌, 하좌상 - 4개
    5번 - 상하좌우 - 1개
    */
    static ArrayList<CCTV> cctvs;
    static int[] directions;
    // cctv 방향 돌려보기위한 배열
    static int[][] board, temp;

    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int total, N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        cctvs = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());

                if (board[r][c] >= 1 && board[r][c] <= 5) {
                    cctvs.add(new CCTV(r, c, board[r][c]));
                }
            }
        }

        directions = new int[cctvs.size()];
        total = cctvs.size();

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int level) {
        if(level == total) {
            copy();

            for (int i = 0; i < total; i++) {
                int d = directions[i];
                CCTV cctv = cctvs.get(i);

                makeTemp(d, cctv);
            }

            find();

        } else {
            for (int i = 0; i < 4; i++) {
                directions[level] = i;
                dfs(level+1);
            }
        }
    }

    /**
     * cctv의 감시 방향이 d일 때 각 cctv의 방향 개수에 맞추어 감시
     */
    private static void makeTemp(int d, CCTV cctv) {
        if (cctv.type == 1) {
            check(cctv, d);
        } else if (cctv.type == 2) {
            if (d == 0) {
                check(cctv, 0);
                check(cctv, 2);
            } else if(d == 1){
                check(cctv, 1);
                check(cctv, 3);
            } else {
            	return;
            }
        } else if (cctv.type == 3) {
            if (d == 3) {
                check(cctv, 0);
                check(cctv, 3);
            } else {
                check(cctv, d);
                check(cctv, d +1);
            }
        } else if (cctv.type == 4) {
            if (d == 0) {
                check(cctv, 0);
                check(cctv, 1);
                check(cctv, 3);
            } else if (d == 1) {
                check(cctv, 0);
                check(cctv, 1);
                check(cctv, 2);
            } else if(d == 2) {
                check(cctv, 1);
                check(cctv, 2);
                check(cctv, 3);
            } else if (d == 3) {
                check(cctv, 2);
                check(cctv, 3);
                check(cctv, 0);
            }
        } else if (cctv.type == 5) {
            check(cctv, 0);
            check(cctv, 1);
            check(cctv, 2);
            check(cctv, 3);
        }
    }

    /**
     * cctv를 direction 방향으로 감시한다.
     * @param direction 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
     */
    private static void check(CCTV cctv, int direction) {
        int nr = cctv.r + deltas[direction][0];
        int nc = cctv.c + deltas[direction][1];

        while(nr >= 0 && nr < N && nc >= 0 && nc < M && temp[nr][nc] != 6) {
            temp[nr][nc] = -1;

            nr += deltas[direction][0];
            nc += deltas[direction][1];
        }
    }

    /**
     * 사각지대의 개수를 구한다.
     */
    private static void find() {
        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (temp[r][c] == 0) {
                    count++;
                }
            }
        }

        answer = Math.min(answer, count);
    }

    private static void copy() {
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, temp[i], 0, M);
            // board를 0 부터 M 까지 temp에 0부터 똑같이 복사하기
        }
    }
    static class CCTV {
        int r,c,type;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
	
}
