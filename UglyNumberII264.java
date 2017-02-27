 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 

public class Solution {
    public int nthUglyNumber(int n) {//ugly[] = dp[]; dp[i] = Min{dp[p2] * 2, dp[p3] * 3..}
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0, c = 1;
        while(c < n){
            int next = Math.min(ugly[p2] * 2, ugly[p3] * 3);
            next = Math.min(next, ugly[p5] * 5);
            ugly[c] = next;
            if (next == ugly[p2] * 2) p2++;
            if (next == ugly[p3] * 3) p3++;
            if (next == ugly[p5] * 5) p5++;
            c++;
        }
        return ugly[n - 1];
    }
}
