package p12.exercise;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MultiQueueImpl<T, Q> implements MultiQueue<T, Q>{
    private final Map<Q, Queue<T>> queues;

    public MultiQueueImpl() {
        this.queues = new HashMap<Q, Queue<T>>();
    }

    @Override
    public Set<Q> availableQueues() {
        return this.queues.keySet();
    }

    @Override
    public void openNewQueue(Q queue) {
        // Check if the argument is valid
        if (queue == null) {
            throw new NullPointerException();
        }
        if (this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("This queue already exists");
        }

        // Creates the entry in the Map and the associated List
        this.queues.put(queue, new LinkedList<T>());
    }

    @Override
    public boolean isQueueEmpty(Q queue) {
        // Check if the argument is valid
        if (queue == null) {
            throw new NullPointerException();
        }
        if (!this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("The queue requested doesn't exist");
        }

        return this.queues.get(queue).isEmpty();
    }

    @Override
    public void enqueue(T elem, Q queue) {
        // Check if the arguments are valid
        if (queue == null || elem == null) {
            throw new NullPointerException();
        }
        if (!this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("The queue requested doesn't exixsts");
        }

        this.queues.get(queue).add(elem);
    }

    @Override
    public T dequeue(Q queue) {
        // Check if the argument is valid
        if (queue == null) {
            throw new NullPointerException();
        }
        if (!this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("The queue requested doesn't exist");
        }
        return this.queues.get(queue).poll();
    }

    @Override
    public Map<Q, T> dequeueOneFromAllQueues() {
        Map<Q,T> toReturn = new HashMap<Q,T>();

        /* Iterates all the queues and removes the head.
         * If the removed element exists, adds it into the map
         * that will be returned.
         */
        for (Q key: this.queues.keySet()) {
            T element = this.queues.get(key).poll();
            toReturn.put(key, element);
        }

        return toReturn;
    }

    @Override
    public Set<T> allEnqueuedElements() {
        Set<T> toReturn = new HashSet<T>();
        
        /* Iterates all the queues and puts all the elements
         * in the Set that will be returned.
         */
        for (Q key: this.queues.keySet()) {
            for (T element: this.queues.get(key)) {
                toReturn.add(element);
            }
        }

        return toReturn;
    }

    @Override
    public List<T> dequeueAllFromQueue(Q queue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeueAllFromQueue'");
    }

    @Override
    public void closeQueueAndReallocate(Q queue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeQueueAndReallocate'");
    }

}
