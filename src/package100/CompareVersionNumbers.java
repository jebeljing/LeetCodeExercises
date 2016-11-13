package package100;

/**
 * Created by jingshanyin on 11/13/16.
 * 165. Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        int length = Math.max(vers1.length, vers2.length);

        for (int i = 0; i < length; i++) {
            Integer int1 = i < vers1.length ? Integer.parseInt(vers1[i]) : 0;
            Integer int2 = i < vers2.length ? Integer.parseInt(vers2[i]) : 0;
            int compVal = int1.compareTo(int2);
            if (compVal != 0)
                return compVal;
        }
        return 0;
    }
}
