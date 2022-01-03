import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}


class Solution {

    long getNthUglyNo(int n) 
    {
        long a[] = new long[n+1];
        a[1] = 1;
        int p2=1,p3=1,p5=1;
        
        for(int i=2;i<=n;i++)
        {
            long n2 = 2 * a[p2];
            long n3 = 3 * a[p3];
            long n5 = 5 * a[p5];
            
            long min = Math.min(n2,Math.min(n3,n5));
            a[i] = min;
            
            if(min==n2)p2++;
            if(min==n3)p3++;
            if(min==n5)p5++;
        }
        return a[n];
    }
    
}