import java.util.*;
import java.math.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        //최대 공약수를 찾?
        //10과 17의 최대 공약수 
        int a_gcd = getGCD(arrayA);
        int b_gcd = getGCD(arrayB);
        boolean flagA = false, flagB = false;
        flagA = calc(arrayB, a_gcd);
        flagB = calc(arrayA, b_gcd);
        if(flagA && flagB) {
            answer = Math.max(a_gcd, b_gcd);
        }
        else if(flagA && !flagB) {
            answer = a_gcd;
        }
        else if(!flagA && flagB) {
            answer = b_gcd;
        }
        return answer;

    }
    int getGCD(int[] nums) {
        BigInteger result = BigInteger.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            result = result.gcd(BigInteger.valueOf(nums[i]));
        }
        return result.intValue();
    }
    boolean calc(int[] arr, int n) {
        for(int a : arr) {
            if(a % n == 0) return false;
        }
        return true;
    }
}