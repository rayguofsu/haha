
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

public class Solution {
    public int[] countBits(int num) {//dp[i] = dp[i/2] +(1) if i is odd or +(0) if i is even.
            int[] dp = new int[num + 1];    
    for(int i = 1; i <= num; i++){
        dp[i] = dp[i/2];   //bit[i] means how many one bits in bit[i];
        if(i%2 == 1) dp[i]++;   //so how to get bit[i] from bit[i/2]: two cases:
    }                             //1). i/2 shift to left by 1 bit gives i (same number of 1 bits)
                                  //2). if i%2 ==1; then it means we need to add one bit to the end;
    return dp;
 }

}
