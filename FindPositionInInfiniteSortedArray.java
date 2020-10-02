package com.shashi.dsalgo.searchingandsorting;

//Approach
//When using binary search, we find the
//key is always bounded between start and end

//Here we will first find the bound
//Then we apply binary search in the bounds

//To find the bound
//Set: start = 0 and end = 1
//We increase the end until we find the element at end is
//smaller than the key
//Since, the key is bigger, we also increment start

public class FindPositionInInfiniteSortedArray {

    public static int findPosition(int[] a, int key) {
        int start = 0;
        int end = 1;

        while (a[end] < key) {
            start = end;
            end = end * 2;
        }

        int answer = binarySearch(a, start, end, key);
        return answer;
    }

    public static int binarySearch(int[] a, int lowerLimit, int upperLimit, int n) {
        while (lowerLimit <= upperLimit) {
            int middleValue = (lowerLimit + upperLimit) / 2;
            if (a[middleValue] < n) {
                lowerLimit = middleValue + 1;
            } else if (a[middleValue] > n) {
                upperLimit = middleValue - 1;
            } else {
                return middleValue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int answer = findPosition(a, 10);

        if (answer == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + answer);
    }

}
