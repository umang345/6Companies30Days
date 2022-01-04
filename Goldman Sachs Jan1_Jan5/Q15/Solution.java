import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : arr)
        {
             int rem = (i%k + k)%k;
             map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet())
        {
             int key = e.getKey();
             if(key==0)
             {
                  if(e.getValue()%2!=0)
                  {
                       return false;
                  }
             }
             else
             {
                  int key_comp = map.getOrDefault(k-key,0);
                  if(e.getValue()!=key_comp)
                  {
                       return false;
                  }
             }
        }
        return true;
    }
}