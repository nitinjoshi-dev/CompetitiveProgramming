package com.leetcode;

//https://leetcode.com/problems/guess-number-higher-or-lower/
public class FirstBadVersion {

    private int firstBadVersion;

    public int firstBadVersion(int n) {
        int low = 1, high = n;
        int minBadVersion = n;
        int mid;
        while(low <= high) {
            mid = low + ((high - low) / 2);
            boolean isBadVersion = isBadVersion(mid);
            if (isBadVersion) {
                high = mid - 1;
                if(minBadVersion > mid) {
                    minBadVersion = mid;
                }
            } else {
                low = mid + 1;
            }
        }
        return minBadVersion;
    }

    private boolean isBadVersion(int version) {
        if(version >= firstBadVersion)
            return true;
        return false;
    }

    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();

        obj.firstBadVersion = 6;
        System.out.println(obj.firstBadVersion(10));
        obj.firstBadVersion = 1;
        System.out.println(obj.firstBadVersion(1));
        obj.firstBadVersion = 1;
        System.out.println(obj.firstBadVersion(2));
        obj.firstBadVersion = 4;
        System.out.println(obj.firstBadVersion(5));
        obj.firstBadVersion = 1;
        System.out.println(obj.firstBadVersion(2));
    }
}
