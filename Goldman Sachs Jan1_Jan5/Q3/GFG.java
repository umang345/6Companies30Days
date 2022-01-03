import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}

class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int left = 0;
        int right = 0;
        
        long p = 1l;
        int result=0;
        
        while(right<a.length)
        {
             p*=a[right];
             while(p>=k && left<=right)
             {
                 p/=a[left];
                 left++;
             }
             result += right-left+1;
             right++;
        }
        return result;
    }
}