import java.util.NoSuchElementException;
import java.util.Comparator;

public class MinPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int n = 0;
        private Comparator<Key> comparator;

        public MinPQ(int capacity)
        {
            pq = (Key[]) new Comparable[capacity + 1];
        }

        public boolean isEmpty()
        {
            return n == 0;
        }

        public int size()
        {
            return n;
        }

        public void insert(Key k)
        {
            if(n  == pq.length - 1) resize(2 * pq.length);
            pq[++n] = k;
            swim(n);
        }

        public Key delMin()
        {
            if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
            Key min = pq[1];
            exch(1, n--);
            sink(1);
            pq[n+1] = null;
            if(n>0 && (n == (pq.length - 1) / 4))
            {
                resize(pq.length / 2);
            }
            return min;
        }

    private void swim(int k)
    {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
}
