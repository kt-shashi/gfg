package com.shashi.dsalgo.searchingandsorting;

//Given a sorted array A of size N and a number X, y
// ou need to find the number of occurrences of X in A.

//Input:
// 2
//1 1 2 2 2 2 3
// 4
//1 1 2 2 2 2 3
//Output:
//4
//-1

//Approach:
//We use the formula
//Count = ( Last occurrence - first occurrence ) + 1

public class CountOfAnElementInASortedArray {

    public static int findCount(int[] a, int n, int x) {

        int start = 0;
        int end = n - 1;
        int mid = 0;
        int firstOccurrence = -1;

        //Find first occurrence
        while (start <= end) {
            mid = (start + end) / 2;

            if (a[mid] == x) {
                firstOccurrence = mid;
                end = mid - 1;
            } else if (a[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }

        start = 0;
        end = n - 1;
        mid = 0;
        int lastOccurrence = -1;

        //Find last occurrence
        while (start <= end) {
            mid = (start + end) / 2;

            if (a[mid] == x) {
                lastOccurrence = mid;
                start = mid + 1;
            } else if (a[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (firstOccurrence == -1)
            return -1;
        return (lastOccurrence - firstOccurrence) + 1;
    }

    public static void main(String[] args) {
        int[] a2 = {1, 1, 2, 2, 2, 2, 3};
        int[] a3 = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(findCount(a2, 7, 2));
        System.out.println(findCount(a3, 7, 4));
    }
}
