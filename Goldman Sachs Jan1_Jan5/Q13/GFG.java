import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}

class Solution{
    String decodedString(String s)
    {
         int index = 0;
         Deque<Integer> count = new ArrayDeque<>();
         Deque<String> temp = new ArrayDeque<>();
         
         String result = "";
         
         while(index < s.length())
         {
              if(Character.isDigit(s.charAt(index)))
              {
                   int c = 0;
                   while(Character.isDigit(s.charAt(index)))
                   {
                        c = (c*10)+(s.charAt(index)-'0');
                        index++;
                   }
                   count.addFirst(c);
              }
              else if(s.charAt(index)=='[')
              {
                   temp.addFirst(result);
                   result = "";
                   index++;
              }
              else if(s.charAt(index)==']')
              {
                   StringBuilder sb = new StringBuilder(temp.removeFirst());
                   int c = count.removeFirst();
                   for(int i=0;i<c;i++)
                   {
                        sb.append(result);
                   }
                   result = sb.toString();
                   index++;
              }
              else
              {
                   result+=s.charAt(index);
                   index++;
              }
         }
         return result;
         
    }
}