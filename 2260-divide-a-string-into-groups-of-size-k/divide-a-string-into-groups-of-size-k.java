class Solution {
    public String[] divideString(String s, int k, char fill) {

        int n = s.length();
        int flag = 0;

        if(n % k != 0){
            n = (n/k + 1) * k;
            flag = 1;
        }
            
        String[] result = new String[n/k];

        int i = 0, j = 0;
        int idx = 0;

        while(j < s.length()  && i <= j){
            // System.out.print( s.substring(i,j));
            if(j-i+1 <= k){
                j++;
                continue;
            }
            else{
                result[idx++] = s.substring(i,j);
                i = j;
            }    
        }
        if(flag == 1){
            String str = s.substring(i,j);
            while(j != n){
                str += fill;
                j++;
            }
            result[idx++] = str;
            return result;
        }
        result[idx++] = s.substring(i,j);
        

        return result;
    }
}