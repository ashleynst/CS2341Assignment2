public class Task2 {

    public static void main(String[] args)
    {
        MinPQ<Job> pq2 = new MinPQ<>(100);

        int size = 0;
        while (!StdIn.isEmpty()) {
            int id = StdIn.readInt();
            int processingTime = StdIn.readInt();
            int priority = StdIn.readInt();
            pq2.insert(new Job(id, processingTime, priority));
            size++;
        }

        int currTime = 0;
        int totalTime = 0;
        System.out.print("Execution Order [");
        while (!pq2.isEmpty()) {
            Job job = pq2.delMin();
            currTime += job.processingTime;
            totalTime += currTime;
            System.out.print(job.id);
            if (!pq2.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        double avgTime = ((double)totalTime /size);
        System.out.println("Average completion time: " + avgTime);
    }
}
