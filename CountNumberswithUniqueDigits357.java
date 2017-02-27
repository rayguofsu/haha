;Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99]) 

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //DP solution f(i) is the count of numbers with unique digits with length equals k.
        if (n <= 0) return 1;
        n = Math.min(n, 10);
        int count = 10; //for f(1);
        int dp = 9, factor = 9;
        for (int i = 2; i <= n; i++){
            dp *= factor;
            factor--;
            count += dp;
        }
        return count;
    }
}
