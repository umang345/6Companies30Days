import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

class Solution {
    public List<List<String>> Anagrams(String[] string_list) 
    {
        List<List<String>> result = new ArrayList<>();
        
        for(String s : string_list)
        {
             if(result.size()==0)
             {
                  List<String> newList = new ArrayList<>();
                  newList.add(s);
                  result.add(newList);
             }
             else
             {
                  boolean isFound = false;
                  for(int i=0;i<result.size();i++)
                  {
                       String t = result.get(i).get(0);
                       if(validateAnagrams(s,t))
                       {
                            isFound = true;
                            result.get(i).add(s);
                            break;
                       }
                  }
                  if(!isFound)
                   {
                        List<String> newList = new ArrayList<>();
                        newList.add(s);
                        result.add(newList);
                   }
             }
        }
        
        return result;
    }
    
    private boolean validateAnagrams(String a, String b)
    {
         if(a.length() !=b.length())
         {
              return false;
         }
         char x[] = new char[26];
         char y[] = new char[26];
         
         for(int i=0;i<a.length();i++)
         {
             x[a.charAt(i) - 'a']++;
         }
         
         for(int j=0;j<b.length();j++)
         {
             y[b.charAt(j) - 'a']++; 
         }
         
         for(int i=0;i<26;i++)
         {
              if(x[i]!=y[i])
              {
                   return false;
              }
         }
         
         return true;
    }
}
