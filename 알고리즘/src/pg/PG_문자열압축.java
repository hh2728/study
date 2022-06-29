package pg;

public class PG_문자열압축 {

	public static void main(String[] args) {
		String s = "aabbaccc";
		
		int answer = s.length();        
        
        for(int i=1; i<=s.length(); i++){
            int count=1;
            String ans = "";
            String cut = s.substring(0,i);
            String target = "";

            
            for(int j=i; j<=s.length(); j=j+i){
                
                if(j+i >= s.length()){          
                    target = s.substring(j);                 
                }else{
                    target = s.substring(j,j+i);
                }
                
                if(target.equals(cut)){
                    count++;
                }
                else if(count == 1){
                    ans += cut;
                    cut = target;
                }else{
                    ans += count + cut;
                    cut = target;
                    count = 1;
                }              
                              
            }
            
            if( i != cut.length()){
                //System.out.println(ans+" cut:"+cut);
                ans += cut;
            }

            answer = Math.min(answer, ans.length());
        }
               
       
        //return answer;

	}

}
