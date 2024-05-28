class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int l = 0;
        int n = s.length();
        int sum = 0;
        int ans = 0;
        for(int r = 0; r < n; r++){
            sum += abs(t[r] - s[r]);
            while(sum > maxCost){
                sum -= abs(t[l] - s[l]);
                l++; 
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};