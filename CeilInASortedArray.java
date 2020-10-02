package com.shashi.dsalgo.searchingandsorting;

//If element at mid is greater, then it could be the ans
//Hence we store it, and find is there an element which is also
//larger than K, but is smaller than the previous ans
//And we go to the left half, end = mid - 1

public class CeilInASortedArray {
    public static int findCeil(int[] a, int n, int x) {
        int start = 0;
        int end = n - 1;
        int mid;
        int ans = -1;

        if (a[n - 1] < x)
            return -1;
        if (a[n - 1] == x)
            return 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(findCeil(a, 7, 5));
    }
}
