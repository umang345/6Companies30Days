public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> source = new ArrayList<>();
        for(int i=0;i<1000000;i++)
        {
             source.add(sc.nextInt());
        }
        
        for(int i=0;i<10;i++)
        {
             pq.add(source.get(i));
        }
        for(int i=10;i<source.size();i++)
        {
             if(pq.peek()<source.get(i))
             {
                  pq.poll();
                  pq.add(source.get(i));
             }
        }
        Deque<Integer> largest10 = new ArrayDeque<>();
        while(pq.size()!=0)
        {
             largest10.addFirst(pq.poll());
        }
        System.out.println(largest10);
    }
}