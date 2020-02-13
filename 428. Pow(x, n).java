428. Pow(x, n)
Implement pow(x, n). (n is an integer.)

Example
Example 1:

Input: x = 9.88023, n = 3
Output: 964.498
Example 2:

Input: x = 2.1, n = 3
Output: 9.261
Example 3:

Input: x = 1, n = 0
Output: 1
Challenge
O(logn) time

Notice
You don't need to care about the precision of your answer, it's acceptable if the expected answer and your answer 's difference is smaller than 1e-3.

//recursion
public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if(n==0){
            return 1.0;
        }
        
        double ans=myPow(x,n/2);
        ans=ans*ans;
        if(n%2==1){
            ans=ans*x;
        }
        else if(n%2==-1){
            ans=ans/x;
        }
        return ans;
    }
}

//non-recursion
public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if(n==0){
            return 1.0;
        }
        
        double ans=1;
        double temp=(n>0)?x:1/x;
        while(n!=0){
            if(n%2==1 || n%2==-1){
                ans=ans*temp;
            }
            temp=temp*temp;
            n=n/2;
        }
        return ans;
    }
}