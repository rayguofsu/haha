Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hint:

    Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?
public class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i * i < n; i++){
            for (int j = i * i; j < n; j += i){
                primes[j] = false;
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++){
            if (primes[i] ==true) res++;
        }
        return res;
    }
}
