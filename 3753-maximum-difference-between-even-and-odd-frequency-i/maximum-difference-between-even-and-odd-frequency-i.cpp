class Solution {
public:
    int maxDifference(string s) {
        int n=s.size();
        unordered_map<char,int>freq;
        for(int i=0;i<n;i++)
        {
            freq[s[i]]++;
        }
 int odd=0,even=INT_MAX;
        for(auto x:freq)
        {
            if(x.second%2==0)
            {
                even=min(even,x.second);
            }
            else odd=max(odd,x.second);
        }
        return odd-even;
    }
};