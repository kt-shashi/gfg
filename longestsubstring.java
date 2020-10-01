//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine());
    
	    while(t > 0){
	        String s = br.readLine();
	        Solution T = new Solution();
	        
	        System.out.println(T.SubsequenceLength(s));
	        
            t--;
	    }
	}
    
}



// } Driver Code Ends


//User function Template for Java


class Solution
{
    

    int SubsequenceLength(String s) 
    {
        if (s == null || s.length() == 0)
            return 0;

        int previousPoniter = 0;
        int currentPointer = 0;
        int maxSize = Integer.MIN_VALUE;

        HashSet<Character> hashSet = new HashSet<>();

        while (currentPointer < s.length()) {
            char ch = s.charAt(currentPointer);

            while (hashSet.contains(ch)) {
                hashSet.remove(s.charAt(previousPoniter));
                previousPoniter++;
            }

            hashSet.add(ch);
            maxSize = Math.max(maxSize, currentPointer - previousPoniter + 1);
            currentPointer++;
        }

        return maxSize;
    }
    
}

