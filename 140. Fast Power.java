140. Fast Power
Calculate the a^n % b where a, b and n are all 32bit non-negative integers.

Example
For 2^31 % 3 = 2

For 1001000 % 1000 = 0

Challenge
O(logn)

//recursion
public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        
        long ans = fastPower(a, b, n/2);
        ans = (ans * ans) % b;
        if (n % 2 == 1) {
            ans = (ans * a) % b;
        }
        return (int)ans;
    }
}


//non recursion
public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        long ans = 1;
        long tmp = a;
        
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * tmp) % b;
            }
            tmp = (tmp * tmp) % b;
            n = n/2;
        }
        
        return (int)(ans % b);
    }
}