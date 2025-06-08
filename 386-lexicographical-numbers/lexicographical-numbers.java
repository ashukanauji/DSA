class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        int num = 1;
        for(int i = 0; i<n; i++){
            result.add(num);
            if(num*10 <= n)
                num*=10;
            else{
                if(num >= n){
                    num = num/10;
                }
                num++;
                while(num%10 == 0)
                    num = num /10;
            }
        }
        return result;
    }

}