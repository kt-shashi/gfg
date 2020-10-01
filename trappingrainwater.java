import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Trap obj = new Trap();
		    
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    
    public static int trappingWater(int a[], int n) {

        int[] leftMax = new int[n];
        leftMax[0] = a[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = getMax(leftMax[i - 1], a[i]);

        int[] rightMax = new int[n];
        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = getMax(a[i], rightMax[i + 1]);

        int[] waterStored = new int[n];
        for (int i = 0; i < n; i++) {
            waterStored[i] = getMin(leftMax[i], rightMax[i]) - a[i];
        }

        int sumWaterStored = 0;
        for (int i = 0; i < n; i++)
            sumWaterStored += waterStored[i];

        return sumWaterStored;
    }

    //utility function to find Max between 2 elements
    public static int getMax(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    //utility function to find Min between 2 elements
    public static int getMin(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }
}

