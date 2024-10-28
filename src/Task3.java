public class Task3 {

    public static void main(String[] args)
    {
        MinPQ<Job> pq3 = new MinPQ<>(100);
        int size = 0;
        while (!StdIn.isEmpty()) {
            int id = StdIn.readInt();
            int processingTime = StdIn.readInt();
            int arrivalTime = StdIn.readInt();
            pq3.insert(new Job(id, processingTime, arrivalTime));
            size++;
        }

        int currTime = 0;
        int totalTime = 0;
        System.out.print("Execution Order [");
        while (!pq3.isEmpty()) {
            Job job = pq3.delMin();
            currTime += job.processingTime;
            totalTime += currTime;
            System.out.print(job.id);
            if (!pq3.isEmpty()) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        double avgTime = ((double)totalTime /size);
        System.out.println("Average completion time: " + avgTime);

    }

}
