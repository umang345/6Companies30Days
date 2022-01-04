import java.io.*;

class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

class Solve {
    int[] findTwoElement(int arr[], int n) 
    {
         int f[] = new int[n+1];
         for(int i=0;i<arr.length;i++)
         {
              f[arr[i]]++;
         }
         int result[] = new int[2];
         for(int i=1;i<=n;i++)
         {
              if(f[i]==2)
              {
                  result[0] = i;
              }
              if(f[i]==0)
              {
                   result[1] = i;
              }
              if(result[0]>0 && result[1]>0)
              {
                   break;
              }
         }
         return result;
    }
}