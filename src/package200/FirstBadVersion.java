package package200;

/**
 * Created by jingshanyin on 11/30/16.
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed
 * based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad.
 Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end) {
            //Use final to reuse the middle to reduce creating new int
            final int middle = start + (end - start)/2;
            if (isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    public int firstBadVersion2(int n) {
        int start = 1;
        int end = n;
        int middle = 1 + (end - start)/2;
        while(start < end) {
            final boolean bad = isBadVersion(middle);
            if (bad) {
                end = middle;
                middle = start + (end - start)/2;
            } else {
                start = middle + 1;
                middle = start + (end-start)/2;
            }
        }
        return start;
    }

    private boolean isBadVersion(int n) {
        return false;
    }
}
