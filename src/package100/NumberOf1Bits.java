package package100;

/**
 * Created by Jebeljing on 11/8/2016.
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            if (n%2 == 1 | n%2 == -1)
                result++;
            n = n>>>1;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        String str = Integer.toBinaryString(n);

        Character[] res = new Character[str.length()];
        for(int i=0;i<str.length();i++){
            res[i]=str.charAt(i);
        }
        int count = 0;
        for(int i=0;i<res.length;i++){
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}
