import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=2; i<N+1; i++){

            for(int r=1; r<i; r++){
                if(arr[i] > arr[r]){
                    dp[i] = Math.max(dp[i],dp[r] + 1);
                }
            }
        }

        int result = 0;
        for(int i = 1; i<=N; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.print(result);
    }
}
