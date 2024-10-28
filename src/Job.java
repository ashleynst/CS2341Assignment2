public class Job implements Comparable<Job> {
        int id;
        int processingTime;
        int priority;

        public Job(int id, int processingTime) {
            this.id = id;
            this.processingTime = processingTime;
        }

    public Job(int id, int processingTime, int priority)
    {
        this.id = id;
        this.processingTime = processingTime;
        this.priority = priority;
    }

        @Override
        public int compareTo(Job other) {
            if(this.priority != other.priority)
            {
                return Integer.compare(this.priority, other.priority);
            }
            return Integer.compare(this.processingTime, other.processingTime);
        }
    }
