class Solution {
public:
    bool canMeasureWater(int j1, int j2, int tc) {
        return (tc%__gcd(j1,j2)==0 and tc<=(j1+j2));
    }
};