class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n<=k && m<=k)
            return 0;
        long cost=0;
        if(n>k && m<=k)
            cost+=(long)(n-k)*k;
        if(m>k && n<=k)
            cost+=(long)(m-k)*k;
        
        return cost;
    }
}