The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
        //remember digit = list.remove() and k--; as k start from 1; and remove start from 0
        k--;
        List<Integer> list = new ArrayList<>();
        String res = "";
        int total = 1;
        for (int i = 1; i <= n; i++){
            total *= i;
            list.add(i);
        }
        int i = 0;
        while(res.length() < n){
            total /= (n - i);
            int digit = list.remove(k / total);
            res += digit;
           // System.out.println("diig iis " + digit +" total is " + total);
            k %= total;
            i++;
        }
        return res;
    }
}
