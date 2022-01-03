import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}

class Solution
{
    public int CountWays(String str)
    {
         if(str.charAt(0)=='0')return 0;
         int mod =1000000007; 
         long[] dp = new long[str.length()];
         dp[0] = 1l;
         for(int i=1;i<dp.length;i++)
         {
              char c1 = str.charAt(i-1);
              char c2 = str.charAt(i);
              
              if(c1=='0' && c2=='0')
              {
                   dp[i] = 0l;
              }
              else if(c1=='0' && c2!='0')
              {
                  dp[i] = dp[i-1]%mod;
              }
              else if(c1!='0' && c2=='0')
              {
                   if(c1=='1' || c1=='2')
                   {
                        dp[i] = i>=2? dp[i-2]%mod : 1;
                   }
                   else
                   {
                        dp[i] = 0l;
                   }
              }
              else
              {
                   if(Long.parseLong(str.substring(i-1,i+1))<=26)
                   {
                        dp[i] = (dp[i-1]%mod + (i>=2? dp[i-2]%mod : 1))%mod;
                   }
                   else
                   {
                        dp[i] = dp[i-1]%mod;
                   }
              }
         }
          return (int)dp[str.length()-1];
    }
}