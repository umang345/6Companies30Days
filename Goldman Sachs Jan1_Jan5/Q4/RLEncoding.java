import java.util.*;

class RLEncoding {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T > 0) {

            String str = sc.nextLine();

            GfG g = new GfG();
            System.out.println(g.encode(str));

            T--;
        }
    }
}

class GfG {
    String encode(String str) {
        int start = 0;
        int end = 0;

        int n = str.length();
        StringBuilder sb = new StringBuilder();

        while (end < n) {
            char ch1 = str.charAt(start);
            char ch2 = str.charAt(end);

            if (ch1 == ch2) {
                end++;
            } else {
                sb.append(ch1).append(end - start);
                start = end;
            }
        }

        sb.append(str.charAt(start)).append(end - start);
        return sb.toString();
    }

}