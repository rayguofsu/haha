
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

    Given numerator = 1, denominator = 2, return "0.5".
    Given numerator = 2, denominator = 1, return "2".
    Given numerator = 2, denominator = 3, return "0.(6)".

Hint:

    No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
    Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
    Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "0";
        Map<Long, Integer> map = new HashMap<>();
        int one = 1;
        if (numerator < 0 && denominator > 0) one = -1;
        if (numerator > 0 && denominator < 0) one = -1;
        long p = Math.abs((long) numerator);
        long q = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(p / q);
        if (p % q != 0){
            sb.append(".");
        }
        p = p % q;
        int i = sb.length();
        while(p != 0){
            p *= 10;
            if (map.containsKey(p)){
                int pos = map.get(p);
                sb.insert(pos, "("); //remember
                sb.append(")");
                break;
            }
            else{
                map.put(p, i++);
                sb.append(p / q);
                p %= q;
            }
        }
        if (one == -1) sb.insert(0, "-");
        return sb.toString();
    }
}
