import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class LC215_kth_Largest_Element {

    //LC: 215. kth Largest Element
    public int findKthLargest(int[] nums, int k)
    {

        HashSet<Integer> hashSet=new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(hashSet.contains(nums[i])){
                continue;
            }
            minHeap.offer(nums[i]);
            hashSet.add(nums[i]);
            if(minHeap.size()>k){
                Integer poll = minHeap.poll();
                hashSet.remove(poll);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(4);
        for (int x : new int[]{5, 3, 8, 1, 9, 2}) h.insert(x);

        while (!h.isEmpty()) {
            System.out.print(h.extractMin() + " ");  // 1 2 3 5 8 9
        }
    }

    public static class MinHeap {
        private int[] heap;
        private int size;

        public MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        // ---- helpers ----
        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i)   { return 2 * i + 1; }
        private int right(int i)  { return 2 * i + 2; }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        private void grow() {
            heap = java.util.Arrays.copyOf(heap, heap.length * 2);
        }

        // ---- core operations ----
        public void insert(int val) {
            if (size == heap.length) grow();
            heap[size] = val;          // add at the end
            siftUp(size);              // restore heap property
            size++;
        }

        public int peek() {
            if (size == 0) throw new NoSuchElementException("Heap is empty");
            return heap[0];
        }

        public int extractMin() {
            if (size == 0) throw new NoSuchElementException("Heap is empty");
            int min = heap[0];
            heap[0] = heap[--size];    // move last element to the root
            siftDown(0);               // restore heap property
            return min;
        }

        private void siftUp(int i) {
            while (i > 0 && heap[parent(i)] > heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void siftDown(int i) {
            while (true) {
                int smallest = i;
                int l = left(i), r = right(i);

                if (l < size && heap[l] < heap[smallest]) smallest = l;
                if (r < size && heap[r] < heap[smallest]) smallest = r;

                if (smallest == i) break;   // heap property holds
                swap(i, smallest);
                i = smallest;
            }
        }

        public int size()        { return size; }
        public boolean isEmpty() { return size == 0; }

        // ---- demo ----

    }

}
