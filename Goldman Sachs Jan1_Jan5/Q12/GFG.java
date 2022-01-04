import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int totalSquares = (n*(n+1)*((2*n)+1))/6;
		System.out.println(totalSquares);
        sc.close();
	}
}