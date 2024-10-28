import java.util.Scanner;
import java.io.File;
import java.util.Iterator;

public class Task1 {

    public static void main(String[] args) {
        MinPQ<Job> pq = new MinPQ<>(100);

        int size = 0;
        while (!StdIn.isEmpty()) {
            int id = StdIn.readInt();
            int processingTime = StdIn.readInt();
            pq.insert(new Job(id, processingTime));
            size++;
        }

        int currTime = 0;
        int totalTime = 0;
        System.out.print("Execution Order [");
        while (!pq.isEmpty()) {
            Job job = pq.delMin();
            currTime += job.processingTime;
            totalTime += currTime;
            System.out.print(job.id);
            if (!pq.isEmpty()) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        double avgTime = ((double)totalTime /size);
        System.out.println("Average completion time: " + avgTime);

    }
}