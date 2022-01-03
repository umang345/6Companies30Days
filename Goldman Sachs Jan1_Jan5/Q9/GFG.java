import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}

class Solution{
    String printMinNumberForPattern(String s)
    {
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=1;i<=s.length();i++)
        {
             st.push(i);
             if(s.charAt(i-1)=='I')
             {
                  while(!st.isEmpty())
                  {
                       sb.append(st.pop());
                  }
             }
        }
        st.push(s.length()+1);
        while(!st.isEmpty())
          {
               sb.append(st.pop());
          }
          return sb.toString();
        
    }
}
