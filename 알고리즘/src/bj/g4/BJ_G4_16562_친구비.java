package bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_16562_친구비 {
	
	static int parent[];
    static int cost[];
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        cost = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            parent[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<m;i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        int ans = 0;
        for(int i=1;i<n+1;i++){
            ans+=cost[i];
        }
        
        System.out.println(ans>k?"Oh no":ans);
    }
    
    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return find(parent[a]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b] = a;
        cost[a] = Math.min(cost[a], cost[b]);
        cost[b] = 0;
    }

}
